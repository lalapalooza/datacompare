package com.clinbrain.datac.compare;

import com.clinbrain.datac.service.ConnectionService;
import com.clinbrain.datac.common.conf.ImpalaConfig;
import com.clinbrain.datac.service.TableConfigService;
import com.clinbrain.datac.service.TableLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Liaopan on 2019/7/3.
 * 项目启动后执行的类，已废弃
 *
 */
@Deprecated
public class LauncherApplicationRunner implements ApplicationRunner {

  @Autowired
  TableConfigService configService;

  @Autowired
  TableLoggerService loggerService;

  @Autowired
  ConnectionService connectionService;

  @Value("${pool.size}")
  private int poolSize;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    /*DataSource impalaDataSource = DataSourceManager.getInstance(impalaConfig.getDriverClassName(),
        impalaConfig.getUrl(), impalaConfig.getUsername(), impalaConfig.getPassword());
    // 保存有表分区时间字段的配置
    final List<EtlHistablePartitionsConfiguration> hisPartConf = connectionService.getHisPartConf();
    //加载所有需要的表
    List<TableConfig> tableList = configService.selectAll();
    System.out.println(tableList.size());

    final Launcher launcher = new Launcher();
    launcher.initialize(poolSize, tableList);
    launcher.setImpalaDataSource(impalaDataSource);
    launcher.setHisTablePartitionConfig(hisPartConf);
    launcher.doTheTask();*/
  }
}
