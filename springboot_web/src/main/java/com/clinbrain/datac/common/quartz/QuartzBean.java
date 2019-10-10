package com.clinbrain.datac.common.quartz;

/**
 * @Author：ligen
 * @Date: Created:17:44  2019/7/8
 * @Description: Quartz实体
 **/
public class QuartzBean {
    /**
     * job名称
     */
    private String jobName;

    /**
     * group 名称
     */
    private String groupName;

    /**
     * trig 名称
     */
    private String triggerName;

    /**
     * 执行规律
     */
    private String cron;

    /**
     * 访问类名
     */
    private Class className;

    /**
     * 启停状态
     */
    private boolean stop_start_type;

    /**
     * 获取job名称
     * @return
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * job名称
     * @param jobName job名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取组名
     * @return 组名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置组名
     * @param groupName 组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取trig名称
     * @return 名称
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * 设置trig 名称
     * @param triggerName 名称
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    /**
     * 获取时间频率
     * @return 获取时间
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置执行频率或者时间
     * @param cron
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * 获取类名
     * @return 类名
     */
    public Class  getClassName() {
        return className;
    }

    /**
     * 设置类名
     * @param className 类名
     */
    public void setClassName(Class  className) {
        this.className = className;
    }

    /**
     * 获取定时器状态
     * @return 定时器状态
     */
    public boolean getStop_start_type() {
        return stop_start_type;
    }

    /**
     * 设置启停定时器
     * @param stop_start_type 定时器状态
     */
    public void setStop_start_type(boolean stop_start_type) {
        this.stop_start_type = stop_start_type;
    }

    public QuartzBean(String jobName, String groupName, String triggerName, String cron, Class className, boolean stop_start_type) {
        this.jobName = jobName;
        this.groupName = groupName;
        this.triggerName = triggerName;
        this.cron = cron;
        this.className = className;
        this.stop_start_type = stop_start_type;
    }

    public QuartzBean() {
    }
}
