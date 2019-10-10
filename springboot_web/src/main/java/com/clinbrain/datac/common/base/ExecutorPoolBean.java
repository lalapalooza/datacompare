package com.clinbrain.datac.common.base;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Liaopan on 2019/7/31.
 */
@Component
@ConfigurationProperties(prefix = "pool")
public class ExecutorPoolBean {

    private Integer size;
    private Integer maxPoolSize;
    private Integer queueCapacity;
    private Integer keepAliveSeconds;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(Integer queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public Integer getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(Integer keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }
}
