package com.sonal.executor;

import scala.concurrent.Await;
import scala.concurrent.Future;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;

import com.sonal.actor.Calculator;
import com.sonal.actor.ResourcePathBuilder;
import com.sonal.actor.ResourcePathprinter;
import com.sonal.vo.OperationInput;
import com.sonal.vo.OperationType;
import com.sonal.vo.Resource;
import com.sonal.vo.ResourcePath;

public class JavaAkkaMain {

    public static void main(String[] args) {

	ActorSystem javaAkkaActorSystem = ActorSystem.create("javaAkkaActorSystem");

	// calculatorActorDemo(javaAkkaActorSystem);

	// getResponseFromActorBlockingWayDemo(javaAkkaActorSystem);

	getResponseFromActorNonBlockingWayDemo_Way1(javaAkkaActorSystem);

	// getResponseFromActorNonBlockingWayDemo_Way2(javaAkkaActorSystem);

	javaAkkaActorSystem.shutdown();

    }

    
    // Way to Get Response from Request in Non Blocking Way.
    private static void getResponseFromActorNonBlockingWayDemo_Way1(ActorSystem javaAkkaActorSystem) {

	Props resourcePathBuilderProp = Props.create(ResourcePathBuilder.class);
	ActorRef resourcePathBuilderActorRef = javaAkkaActorSystem.actorOf(resourcePathBuilderProp, "resourcePathBuilderProp");

	// resourcePathprinterActorRef is responsible for taking action on the response of resourcePathBuilderActorRef
	Props resourcePathprinterProp = Props.create(ResourcePathprinter.class);
	ActorRef resourcePathprinterActorRef = javaAkkaActorSystem.actorOf(resourcePathprinterProp, "resourcePathprinterProp");

	Resource resource = Resource.getInstance("1", "SomeResource");

	resourcePathBuilderActorRef.tell(resource, resourcePathprinterActorRef);

    }

    // Way to Get Response from Request in non Blocking Way.
    private static void getResponseFromActorNonBlockingWayDemo_Way2(ActorSystem javaAkkaActorSystem) {

	Props resourcePathBuilderProp = Props.create(ResourcePathBuilder.class);

	ActorRef resourcePathBuilderActorRef = javaAkkaActorSystem.actorOf(resourcePathBuilderProp, "resourcePathBuilderProp");

	Resource resource = Resource.getInstance("1", "SomeResource");

	resourcePathBuilderActorRef.tell(resource, resourcePathBuilderActorRef);

    }

    // Way to Get Response from Request in Blocking Way
    private static void getResponseFromActorBlockingWayDemo(ActorSystem javaAkkaActorSystem) {

	Props resourcePathBuilderProp = Props.create(ResourcePathBuilder.class);

	ActorRef resourcePathBuilderActorRef = javaAkkaActorSystem.actorOf(resourcePathBuilderProp, "resourcePathBuilderProp");

	Resource resource = Resource.getInstance("1", "SomeResource");

	Timeout timeout = Timeout.intToTimeout(5);
	// This Blocking Code.
	Future<Object> future = Patterns.ask(resourcePathBuilderActorRef, resource, timeout);
	try {
	    ResourcePath result = (ResourcePath) Await.result(future, timeout.duration());
	    System.out.println(result.getPath());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private static void calculatorActorDemo(ActorSystem javaAkkaActorSystem) {
	Props calculatorPrope = Props.create(Calculator.class);
	ActorRef calculatorActorRef = javaAkkaActorSystem.actorOf(calculatorPrope, "calculatorPrope");

	OperationInput divideInput = OperationInput.getInstance(10, 2, OperationType.DIVIDE);

	calculatorActorRef.tell(divideInput, ActorRef.noSender());

	OperationInput multiplyInput = OperationInput.getInstance(10, 2, OperationType.MULTIPLY);

	calculatorActorRef.tell(multiplyInput, ActorRef.noSender());

	OperationInput addInput = OperationInput.getInstance(10, 2, OperationType.SUM);

	calculatorActorRef.tell(addInput, ActorRef.noSender());

	OperationInput subInput = OperationInput.getInstance(10, 2, OperationType.SUBSTRACT);

	calculatorActorRef.tell(subInput, ActorRef.noSender());
    }
}
