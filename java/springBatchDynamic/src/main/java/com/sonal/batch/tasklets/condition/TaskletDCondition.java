package com.sonal.batch.tasklets.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TaskletDCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
	// TODO Auto-generated method stub
	TaskletCondition taskletCondition = conditionContext.getBeanFactory().getBean(TaskletCondition.class);
	return false;
    }

    
}
