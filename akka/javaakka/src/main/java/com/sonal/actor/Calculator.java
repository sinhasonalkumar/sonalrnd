package com.sonal.actor;

import com.sonal.vo.OperationInput;
import com.sonal.vo.OperationType;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Calculator extends UntypedActor {
    
    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
    
    @Override
    public void onReceive(Object message) throws Exception {

	if (message instanceof OperationInput) {
	    OperationInput operationInput = (OperationInput) message;
	    if (OperationType.SUM.equals(operationInput.getOperationType())) {
		logger.info("SUM :: " + (operationInput.getX() + operationInput.getY()));
	    } else {
		if (OperationType.SUBSTRACT.equals(operationInput.getOperationType())) {
		    logger.info("SUBSTRACT :: " + (operationInput.getX() - operationInput.getY()));
		} else {
		    if (OperationType.MULTIPLY.equals(operationInput.getOperationType())) {
			logger.info("MULTIPLY :: " + (operationInput.getX() * operationInput.getY()));
		    } else {
			if (OperationType.DIVIDE.equals(operationInput.getOperationType())) {
			    logger.info("DIVIDE :: " + (operationInput.getX() / operationInput.getY()));
			}
		    }
		}
	    }

	}
    }

}
