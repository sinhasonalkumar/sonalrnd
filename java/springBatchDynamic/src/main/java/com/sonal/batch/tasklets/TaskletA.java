package com.sonal.batch.tasklets;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonal.batch.tasklets.condition.TaskletCondition;

@Component("taskletA")
public class TaskletA implements IAppTasklet {

    @Autowired
    private TaskletCondition taskletCondition;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

	Map<String, Boolean> executableTaskletMap = taskletCondition.getExecutableTaskletMap();
	if (executableTaskletMap.get("taskletA")) {
	    System.out.println("******** Executing TaskletA **********");
	    Thread.sleep(5000);
	}else{
	    System.out.println("******** Skipping TaskletA **********");
	}

	return null;
    }

}
