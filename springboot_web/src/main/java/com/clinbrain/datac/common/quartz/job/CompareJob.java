package com.clinbrain.datac.common.quartz.job;

import com.clinbrain.datac.compare.Launcher;
import com.clinbrain.datac.model.auto.TableConfig;
import com.clinbrain.datac.model.auto.TableConfigExample;
import com.clinbrain.datac.model.custom.EtlHistablePartitionsConfiguration;
import com.clinbrain.datac.service.ConnectionService;
import com.clinbrain.datac.util.DataSourceManager;
import com.clinbrain.datac.common.conf.ImpalaConfig;
import com.clinbrain.datac.service.TableConfigService;
import com.clinbrain.datac.service.TableLoggerService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author：ligen
 * @Date: Created:17:35  2019/7/8
 * @Description: 数据对比定时任务
 **/
@Component
public class CompareJob implements org.quartz.Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompareJob.class);

    @Autowired
    TableConfigService configService;

    @Autowired
    TableLoggerService loggerService;

    @Autowired
    ConnectionService connectionService;

    @Value("${pool.size}")
    private int poolSize;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        LOGGER.info("数据对比CompareJob启动..."+ LocalDateTime.now());

        try {
            // 保存有表分区时间字段的配置
            final List<EtlHistablePartitionsConfiguration> hisPartConf = connectionService.getHisPartConf();


            //加载所有需要的表
            TableConfigExample configExample = new TableConfigExample();
            TableConfigExample.Criteria criteria = configExample.createCriteria();
            criteria.andEnableEqualTo(1);
            List<TableConfig> tableList = configService.selectByExample(configExample);
            for(TableConfig config : tableList) {
                config.setSourceConfig(connectionService.selectByPrimaryKey(config.getSourceCode()));
                config.setTargetConfig(connectionService.selectByPrimaryKey(config.getTargetCode()));
            }

            final Launcher launcher = new Launcher();
            launcher.initialize(poolSize, tableList);
            launcher.setHisTablePartitionConfig(hisPartConf);
            launcher.doTheTask();
        }catch(Exception e) {
            LOGGER.error("启动任务出错", e);
        }
    }
}
