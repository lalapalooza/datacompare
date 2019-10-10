package com.clinbrain.datac.controller;

import com.clinbrain.datac.common.quartz.MyScheduler;
import com.clinbrain.datac.common.quartz.QuartzBean;
import com.clinbrain.datac.common.quartz.job.CompareJob;
import com.clinbrain.datac.model.auto.TComparePropertites;
import com.clinbrain.datac.service.ComparePropertitesService;
import com.clinbrain.datac.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author：ligen
 * @Date: Created:14:14  2019/7/9
 * @Description: 前端修改数据对比配置
 **/
@Controller
@RequestMapping("/properties")
public class ComparePropertiesController extends BaseController {

    @Autowired
    private MyScheduler myScheduler;
    @Autowired
    private ComparePropertitesService comparePropertitesService;
    @PostMapping("update")
    @ResponseBody
    public boolean update(@RequestParam("cron") String cron,@RequestParam("id") int id){
        // region
        /*boolean succescc = false;
        String key = "compare.config.cron";
        succescc = CompareProperties.updateProperties(key,cron);
        if(succescc){
            QuartzBean quartzBean = new QuartzBean();
            quartzBean.setCron((String) CompareProperties.getProperty(key));
            quartzBean.setGroupName("CompareGroup");
            quartzBean.setJobName("CompareJob");
            quartzBean.setTriggerName("CompareTrigger");
            quartzBean.setClassName(CompareJob.class);
            myScheduler.updateReLoadSchedulerJob(quartzBean);
        }
        return succescc;
        */
        // endregion
        boolean success = false;
        TComparePropertites properties = new TComparePropertites();
        properties.setId(id);
        properties.setPropertitesCron(cron);
        if(comparePropertitesService.update(properties)>0){
            QuartzBean quartzBean = new QuartzBean();
            quartzBean.setCron(properties.getPropertitesCron());
            quartzBean.setGroupName("CompareGroup");
            quartzBean.setJobName("CompareJob");
            quartzBean.setTriggerName("CompareTrigger");
            quartzBean.setClassName(CompareJob.class);
            myScheduler.updateReLoadSchedulerJob(quartzBean);
            success = true;
        }
        return success;
    }
    @PostMapping("add")
    @ResponseBody
    public int add(@RequestBody TComparePropertites tComparePropertites){
        return  comparePropertitesService.add(tComparePropertites);
    }


}
