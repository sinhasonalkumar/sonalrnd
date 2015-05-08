package com.sonal.batch.tasklets;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.batch.tasklets.condition.TaskletCondition;

@Component("taskletD")
public class TaskletD implements IAppTasklet {

    @Autowired
    private TaskletCondition taskletCondition;
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

	Map<String, Boolean> executableTaskletMap = taskletCondition.getExecutableTaskletMap();
	if (executableTaskletMap.get("taskletD")) {
	    System.out.println("******** Executing TaskletD **********");
	    Thread.sleep(5000);
	}else{
	    System.out.println("******** Skipping TaskletD **********");
	}

	return null;
    }

}
