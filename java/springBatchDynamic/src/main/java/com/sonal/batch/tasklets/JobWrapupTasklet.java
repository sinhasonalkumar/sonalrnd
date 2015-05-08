package com.sonal.batch.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

public class JobWrapupTasklet implements IAppTasklet{

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	
	System.out.println("******** Clean Up the Steps and Completing Job ************");
	
	return RepeatStatus.FINISHED;
    }

    
}
