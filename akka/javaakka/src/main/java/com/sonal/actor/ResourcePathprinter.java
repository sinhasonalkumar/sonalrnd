package com.sonal.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import com.sonal.vo.ResourcePath;

public class ResourcePathprinter extends UntypedActor {

    LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
    
    @Override
    public void onReceive(Object message) throws Exception {
	if (message instanceof ResourcePath) {
	    ResourcePath resoucePath = (ResourcePath) message;
	    //ActorSystem javaAkkaActorSystem = getContext().system();
	    logger.info(resoucePath.getPath());
	}
    }

}
