package com.rest.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.scheduling.quartz.*;
import org.springframework.stereotype.Service;


public class QuartzManager {

    private static QuartzManager ourInstance = new QuartzManager();

    public static QuartzManager getInstance() {
        return ourInstance;
    }

    private QuartzManager() {
    }


    private static SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";


    /**
     *
     */
    @SuppressWarnings("unchecked")
    public static void addJob(SchedulerFactoryBean schedulerFactoryBean) {
        try {
            JobBean jobBean = new JobBean();
            jobBean.setJobId("id");
            jobBean.setJobGroupName("group");
            jobBean.setJobCronExpression("0/5 * * * * ?");


            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity(jobBean.getJobId(), jobBean.getJobGroupName()).build();
            jobDetail.getJobDataMap().put("jobBean", jobBean);
            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(jobBean.getJobCronExpression());

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobBean.getJobId(), jobBean.getJobGroupName()).withSchedule(cronSchedule).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务
     * @param time             时间设置，参考quartz说明文档
     * @Description: 添加一个定时任务
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:48:15
     * @version V2.0
     */
    @SuppressWarnings("unchecked")
    public static void addJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName, Class jobClass,
                              String time) {
        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            JobDetail jobDetail = new JobDetail(jobName, jobGroupName, jobClass);// 任务名，任务组，任务执行类
//            // 触发器
//            CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);// 触发器名,触发器组
//            trigger.setCronExpression(time);// 触发器时间设定
//            sched.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param jobName
     * @param time
     * @Description: 修改一个任务的触发时间(使用默认的任务组名 ， 触发器名 ， 触发器组名)
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:49:21
     * @version V2.0
     */
    @SuppressWarnings("unchecked")
    public static void modifyJobTime(String jobName, String time) {
        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
//            if (trigger == null) {
//                return;
//            }
//            String oldTime = trigger.getCronExpression();
//            if (!oldTime.equalsIgnoreCase(time)) {
//                JobDetail jobDetail = sched.getJobDetail(jobName, JOB_GROUP_NAME);
//                Class objJobClass = jobDetail.getJobClass();
//                removeJob(jobName);
//                addJob(jobName, objJobClass, time);
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param triggerName
     * @param triggerGroupName
     * @param time
     * @Description: 修改一个任务的触发时间
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:49:37
     * @version V2.0
     */
    public static void modifyJobTime(String triggerName,
                                     String triggerGroupName, String time) {
        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName, triggerGroupName);
//            if (trigger == null) {
//                return;
//            }
//            String oldTime = trigger.getCronExpression();
//            if (!oldTime.equalsIgnoreCase(time)) {
//                CronTrigger ct = (CronTrigger) trigger;
//                // 修改时间
//                ct.setCronExpression(time);
//                // 重启触发器
//                sched.resumeTrigger(triggerName, triggerGroupName);
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param jobName
     * @Description: 移除一个任务(使用默认的任务组名 ， 触发器名 ， 触发器组名)
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:49:51
     * @version V2.0
     */
    public static void removeJob(String jobName) {
        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);// 停止触发器
//            sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);// 移除触发器
//            sched.deleteJob(jobName, JOB_GROUP_NAME);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @Description: 移除一个任务
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:50:01
     * @version V2.0
     */
    public static void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            sched.pauseTrigger(triggerName, triggerGroupName);// 停止触发器
//            sched.unscheduleJob(triggerName, triggerGroupName);// 移除触发器
//            sched.deleteJob(jobName, jobGroupName);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:50:18
     * @version V2.0
     */
    public static void startJobs() {
//        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            sched.start();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    /**
     * @Description:关闭所有定时任务
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:50:26
     * @version V2.0
     */
    public static void shutdownJobs() {
//        try {
//            Scheduler sched = gSchedulerFactory.getScheduler();
//            if (!sched.isShutdown()) {
//                sched.shutdown();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

}
