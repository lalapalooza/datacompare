package com.clinbrain.datac.common.quartz;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class MyScheduler {

//    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    @Autowired
    private Scheduler scheduler;


    /**
     * 先删除定时任务在创建新的定时任务
     *
     * @param quartzDto 定时器设置
     * @param jobMap    业务数据参数
     */
    public void reLoadSchedulerJob(QuartzBean quartzDto, Map<String, Object> jobMap) {
        try {
            //删除定时任务
            removeJob(quartzDto);

            if (quartzDto.getStop_start_type()) {
                //修改后启动修改
                addJob(quartzDto, jobMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据参数修改已知定时器任务
     *
     * @param quartzDto 定时器信息
     */
    public void updateReLoadSchedulerJob(QuartzBean quartzDto) {
        try {
            //获取默认
//            Scheduler scheduler = schedulerFactory.getScheduler();

            //获取定时器key
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzDto.getTriggerName(), quartzDto.getGroupName());

            //获取调度对象
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzDto.getCron());
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 新增定时任务
     *
     * @param quartzDto 定时器设置对象
     * @param jobMap    参数对象
     * @Description: 添加一个定时任务
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addJob(QuartzBean quartzDto, Map<String, Object> jobMap) {
        try {
            //获取默认
//            Scheduler scheduler = schedulerFactory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(quartzDto.getClassName()).withIdentity(quartzDto.getJobName(), quartzDto.getGroupName()).build();
            //参数传递
            if (jobMap != null && jobMap.isEmpty() == false) {
                for (String key : jobMap.keySet()) {
                    jobDetail.getJobDataMap().put(key, jobMap.get(key));
                }
            }
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();

            // 触发器名,触发器组
            triggerBuilder.withIdentity(quartzDto.getTriggerName(), quartzDto.getGroupName());
//            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(quartzDto.getCron()));

            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除定时任务
     *
     * @param quartzDto 定时器设置对象
     * @Description: 移除一个任务
     */
    public void removeJob(QuartzBean quartzDto) {
        try {

//            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzDto.getTriggerName(), quartzDto.getGroupName());
            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            boolean sa = scheduler.deleteJob(JobKey.jobKey(quartzDto.getJobName(), quartzDto.getGroupName()));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}