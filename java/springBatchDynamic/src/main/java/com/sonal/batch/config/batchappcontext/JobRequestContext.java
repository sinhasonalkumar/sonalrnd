package com.sonal.batch.config.batchappcontext;

public class JobRequestContext {

    private JobRequestContext(){}
    
    private static final InheritableThreadLocal<JobRequestVO> jobRequestContext = new InheritableThreadLocal<JobRequestVO>();

    public static void setJobRequestVO(JobRequestVO jobRequestVO) {
	jobRequestContext.set(jobRequestVO);
    }

    public static JobRequestVO getJobRequestVO() {
	return jobRequestContext.get();
    }

    public static void removeJobRequestVO() {
	jobRequestContext.remove();
    }
}
