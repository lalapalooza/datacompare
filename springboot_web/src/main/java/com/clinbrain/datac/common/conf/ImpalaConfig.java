package com.clinbrain.datac.common.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Liaopan on 2019/7/3.
 */
public class ImpalaConfig {

  private String url;
  private String username;
  private String password;
  private String driverClassName = "com.cloudera.impala.jdbc41.Driver";

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }
}
