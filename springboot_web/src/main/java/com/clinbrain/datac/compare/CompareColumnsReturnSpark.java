package com.clinbrain.datac.compare;

import cn.hutool.setting.Setting;
import com.clinbrain.datac.compare.define.CompareResult;
import com.clinbrain.datac.util.SSHClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Liaopan on 2019/7/17.
 */
public class CompareColumnsReturnSpark extends BaseCompare {
    private static final Logger LOG = LoggerFactory.getLogger(CompareColumnsReturnSpark.class);

    @Override
    public CompareResult compare(String sourceQuery, String targetQuery) throws Exception {

        Setting setting = new Setting("compare.setting", true);

        String command = setting.getStr("ssh.command");
        LOG.info("====提交spark执行查询sql====");
        LOG.info("-》 source:" + sourceQuery);
        LOG.info("-》 target:" + targetQuery);
        LOG.info("==========end====");
        // source 和 target 的jdbc连接
        int loggerId = getTableLogger().getId();
        String sourceBuilder = sourceConfig.getUrl() + "~" +
                sourceConfig.getDriver() + "~" + "tableName" + "~" +
                sourceQuery + "~" + sourceConfig.getUser() + "~" +
                sourceConfig.getPassword();
        String targetBuilder = targetConfig.getUrl() + "~" +
                targetConfig.getDriver() + "~" + "tableName" + "~" +
                targetQuery + "~" + targetConfig.getUser() + "~" +
                targetConfig.getPassword();
        String commandParams = "\"" + sourceBuilder.replaceAll("\"", "\\\"") + "\" \"" +
                targetBuilder.replaceAll("\"", "\\\"") + "\" " + loggerId;
        LOG.info("连接远程SSH机器执行: [" + setting.getStr("ssh.user") + ":" +
                setting.getStr("ssh.password") + "@" + setting.getStr("ssh.host") + ":"
                + setting.getInt("ssh.port") + "");
        LOG.info("Command: " + command + " " + commandParams);

        SSHClient sshClient = new SSHClient(setting.getStr("ssh.host"),
                setting.getInt("ssh.port"), setting.getStr("ssh.user"),
                setting.getStr("ssh.password"));
        new Thread(() -> {
            try {
                sshClient.execCommand(command + " " + commandParams);
            } catch (Exception e) {
                LOG.error("提交远程spark命令出错！", e);
                throw new RuntimeException(e);
            }
        }).start();
        return null;
    }
}
