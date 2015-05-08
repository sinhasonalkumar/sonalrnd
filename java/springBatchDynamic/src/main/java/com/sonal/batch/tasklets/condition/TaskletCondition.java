package com.sonal.batch.tasklets.condition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TaskletCondition {

    public Map<String, String> getStepToTaskletMap(){
	Map<String, String> stepToTaskletMap = new HashMap<String, String>();
	
	stepToTaskletMap.put("Step1", "taskletA");
	stepToTaskletMap.put("Step2", "taskletC");
	stepToTaskletMap.put("Step3", "taskletD");
	stepToTaskletMap.put("Step4", "taskletB");
	
	return stepToTaskletMap;
    }
    
}
