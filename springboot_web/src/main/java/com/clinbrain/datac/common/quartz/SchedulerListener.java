package com.clinbrain.datac.common.quartz;
import com.clinbrain.datac.model.auto.TComparePropertites;
import com.clinbrain.datac.service.ComparePropertitesService;
import com.clinbrain.datac.common.quartz.job.CompareJob;
import com.clinbrain.datac.model.custom.CompareProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerListener.class);

    @Autowired
    private MyScheduler myScheduler;
    @Autowired
    private ComparePropertitesService comparePropertitesService;

    @Autowired
    Environment env;
    /**
     * 定时任务执行方法入口
     *
     * @param event 对象
     */

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            LOGGER.info("<<-----定时器启动------>>");
            Map<String, Object> jobMap = new HashMap<>();
            TComparePropertites comparePropertites = comparePropertitesService.selectPropertites("compare_propertites");
            String cron = "";
            if(comparePropertites!=null){
                cron = comparePropertites.getPropertitesCron();
            }else{
                cron =(String)CompareProperties.getProperty("compare.config.cron");
            }
            /***定时数据对对**/
            QuartzBean quartz = new QuartzBean();
            quartz.setCron(cron);
            quartz.setGroupName("CompareGroup");
            quartz.setJobName("CompareJob");
            quartz.setTriggerName("CompareTrigger");
            quartz.setClassName(CompareJob.class);
            myScheduler.addJob(quartz,jobMap);

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("定时器任务执行失败:"+e.getMessage());
        }
    }
}
