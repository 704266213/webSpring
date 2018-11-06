package com.rest.quartz;

public class JobBean {
    private String jobId;
    private String jobGroupName;
    private String JobCronExpression;
    private String JobDesc;
    private Class<?> JobClass;
    private String JobMethod;
    private String JobMethodSwhere1;
    private String JobMethodSwhere2;
    private String JobStatus;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getJobCronExpression() {
        return JobCronExpression;
    }

    public void setJobCronExpression(String jobCronExpression) {
        JobCronExpression = jobCronExpression;
    }

    public String getJobDesc() {
        return JobDesc;
    }

    public void setJobDesc(String jobDesc) {
        JobDesc = jobDesc;
    }

    public Class<?> getJobClass() {
        return JobClass;
    }

    public void setJobClass(Class<?> jobClass) {
        JobClass = jobClass;
    }

    public String getJobMethod() {
        return JobMethod;
    }

    public void setJobMethod(String jobMethod) {
        JobMethod = jobMethod;
    }

    public String getJobMethodSwhere1() {
        return JobMethodSwhere1;
    }

    public void setJobMethodSwhere1(String jobMethodSwhere1) {
        JobMethodSwhere1 = jobMethodSwhere1;
    }

    public String getJobMethodSwhere2() {
        return JobMethodSwhere2;
    }

    public void setJobMethodSwhere2(String jobMethodSwhere2) {
        JobMethodSwhere2 = jobMethodSwhere2;
    }

    public String getJobStatus() {
        return JobStatus;
    }

    public void setJobStatus(String jobStatus) {
        JobStatus = jobStatus;
    }

}
