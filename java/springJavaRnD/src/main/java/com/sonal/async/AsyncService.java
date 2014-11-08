package com.sonal.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.sonal.service.ServiceClient;
import com.sonal.vo.StateVO;


@Service
public class AsyncService {

	@Autowired
	private ServiceClient serviceClient;
	
	
	public Future<StateVO> pullRecords(int noOfRecords) throws Throwable{
		System.out.println("pullRecords Request Start");
		StateVO record = serviceClient.invokeClientByAsync(noOfRecords);
		Future<StateVO> futureRecords= new AsyncResult<StateVO>(record) ;
		System.out.println("pullRecords Request End");
		return futureRecords; 
	}
	
	
	public List<StateVO> pullAllRecords(int noOfRecords) throws Throwable{
		List<StateVO> allRecords = new ArrayList<StateVO>();
		int chunkSize = 10;
		int lastRecordSize = noOfRecords%chunkSize;
		int noOfChunks = (noOfRecords/chunkSize);
		
		List<Future<StateVO>> futureObjects = new CopyOnWriteArrayList<Future<StateVO>>();
		
		for(int i=0; i< noOfChunks; i++){
			futureObjects.add(pullRecords(10));
		}
		
		futureObjects.add(pullRecords(lastRecordSize));
	
		
		while (!futureObjects.isEmpty()) {
			for (Future<StateVO> futureObject : futureObjects) {
				if(futureObject.isDone()){
					allRecords.add(futureObject.get());
					futureObjects.remove(futureObject);
					System.out.println("futureObject Ended" );
				}
			}
			
		}
		
		return allRecords;
	}
	
}
