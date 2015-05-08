package com.sonal.batch.tasklets.condition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TaskletCondition {

    public Map<String, Boolean> getExecutableTaskletMap(){
	Map<String, Boolean> executableTaskletMap = new HashMap<String, Boolean>();
	
	executableTaskletMap.put("taskletA", true);
	executableTaskletMap.put("taskletC", false);
	executableTaskletMap.put("taskletD", false);
	executableTaskletMap.put("taskletB", true);
	
	return executableTaskletMap;
    }
    
}
