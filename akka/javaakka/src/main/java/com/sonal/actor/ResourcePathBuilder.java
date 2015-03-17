package com.sonal.actor;

import com.sonal.vo.Resource;
import com.sonal.vo.ResourcePath;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ResourcePathBuilder extends UntypedActor{

    private LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
    
    @Override
    public void onReceive(Object message) throws Exception {
	
	if (message instanceof Resource) {
	    Resource resource = (Resource) message;
	    ResourcePath resourcePath = ResourcePath.getInstance("/path/abc/xyz/"+ resource.getId());
	    getSender().tell(resourcePath, ActorRef.noSender());
	}else{
	    if (message instanceof ResourcePath) {
		ResourcePath resourcePath = (ResourcePath) message;
		logger.info(resourcePath.getPath());
	    }else{
		unhandled(message);
	    }
	}
	
    }

    
}
