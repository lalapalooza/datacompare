package com.clinbrain.datac.common.conf;

import com.clinbrain.datac.common.base.ExecutorPoolBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Liaopan on 2019/7/31.
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Autowired
    private ExecutorPoolBean configBean;

    @Bean
    public ThreadPoolTaskExecutor taskComparePool() {

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(configBean.getSize());
        taskExecutor.setMaxPoolSize(configBean.getMaxPoolSize());
        taskExecutor.setQueueCapacity(configBean.getQueueCapacity());
        taskExecutor.setKeepAliveSeconds(configBean.getKeepAliveSeconds());
        taskExecutor.setThreadNamePrefix("taskComparePool-");

        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
