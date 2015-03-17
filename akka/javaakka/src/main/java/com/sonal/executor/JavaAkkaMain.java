package com.sonal.executor;

import com.sonal.actor.Calculator;
import com.sonal.vo.OperationInput;
import com.sonal.vo.OperationType;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class JavaAkkaMain {

    public static void main(String[] args) {

	ActorSystem javaAkkaActorSystem = ActorSystem.create("javaAkkaActorSystem");

	Props calculatorPrope = Props.create(Calculator.class);
	ActorRef calculatorActor = javaAkkaActorSystem.actorOf(calculatorPrope, "calculatorPrope");

	OperationInput divideInput = OperationInput.getInstance(10, 2, OperationType.DIVIDE);

	calculatorActor.tell(divideInput, ActorRef.noSender());

	OperationInput multiplyInput = OperationInput.getInstance(10, 2, OperationType.MULTIPLY);

	calculatorActor.tell(multiplyInput, ActorRef.noSender());

	OperationInput addInput = OperationInput.getInstance(10, 2, OperationType.SUM);

	calculatorActor.tell(addInput, ActorRef.noSender());

	OperationInput subInput = OperationInput.getInstance(10, 2, OperationType.SUBSTRACT);

	calculatorActor.tell(subInput, ActorRef.noSender());

    }
}
