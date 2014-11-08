package com.sonal.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.service.ServiceClient;
import com.sonal.vo.StateVO;

@Service
public class NormalService {

	@Autowired
	private ServiceClient serviceClient;
	
	public List<StateVO> pullAllRecords(int noOfRecords) throws Throwable{
		List<StateVO> allRecords = new ArrayList<StateVO>();
		int chunkSize = 10;
		int lastRecordSize = noOfRecords%chunkSize;
		int noOfChunks = (noOfRecords/chunkSize);
		
		for(int i=0; i< noOfChunks; i++){
			allRecords.add(serviceClient.invokeClient(10));
		}
		allRecords.add(serviceClient.invokeClient(10));
		return allRecords;
	}
}
