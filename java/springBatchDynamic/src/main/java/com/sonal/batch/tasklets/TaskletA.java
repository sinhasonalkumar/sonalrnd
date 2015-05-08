package com.sonal.batch.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component("taskletA")
public class TaskletA implements IAppTasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

	System.out.println("******** Executing TaskletA **********");
	
	Thread.sleep(5000);

	return null;
    }

}
