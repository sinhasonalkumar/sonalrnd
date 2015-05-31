package com.sonal.batch.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StepConfigDao implements IStepConfigDao {

    @Override
    public Map<String, String> getStepToTaskletMapping(String jobRequestId) {
	Map<String, String> executableTaskletMap = new HashMap<String, String>();

	executableTaskletMap.put("step1", "taskletA");
	executableTaskletMap.put("step2", "taskletC");
	executableTaskletMap.put("step3", "taskletD");
	executableTaskletMap.put("step4", "taskletB");
	executableTaskletMap.put("jobWrapupStep", "jobWrapupTasklet");

	return executableTaskletMap;
    }
}
