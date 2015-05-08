package com.sonal.batch.tasklets;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.batch.tasklets.condition.TaskletCondition;

@Component("taskletB")
public class TaskletB implements IAppTasklet {

    @Autowired
    private TaskletCondition taskletCondition;
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	
	Map<String, Boolean> executableTaskletMap = taskletCondition.getExecutableTaskletMap();
	if (executableTaskletMap.get("taskletB")) {
	    System.out.println("******** Executing TaskletB **********");
	    Thread.sleep(5000);
	}else{
	    System.out.println("******** Skipping TaskletB **********");
	}

	return null;
    }

}
