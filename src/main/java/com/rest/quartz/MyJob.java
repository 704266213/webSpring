package com.rest.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.lang.reflect.Method;
import java.util.Date;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz Spring XML 配置 - MyJob");


        JobBean jobBean = (JobBean) jobExecutionContext.getMergedJobDataMap().get("jobBean");
        System.out.println("============JobId=================" + jobBean.getJobId());
        System.out.println("============JobName=================" + jobBean.getJobGroupName());


//        Class<?> jobClass = jobBean.getJobClass();
//        try {
//            Object newInstance = jobClass.newInstance();
//            Method method = jobClass.getMethod(jobBean.getJobMethod(), new Class[]{});
//            method.invoke(newInstance, new Object[]{});
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }
}
