package com.sonal.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.async.AsyncService;
import com.sonal.async.NormalService;
import com.sonal.vo.StateVO;

@Service
public class BulkRecordPullerService {

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private NormalService normalService;

	public List<StateVO> pullBulkRecordsByAsyncService() throws Throwable {
		long stratTime = Calendar.getInstance().getTimeInMillis();
		List<StateVO> pulledAllRecords = asyncService.pullAllRecords(59);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("pullBulkRecordsByAsyncService Took :: " + (endTime - stratTime));
		return pulledAllRecords;
	}

	public List<StateVO> pullBulkRecordsByNormalService() throws Throwable{
		long stratTime = Calendar.getInstance().getTimeInMillis();
		List<StateVO> pulledAllRecords = normalService.pullAllRecords(59);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("pullBulkRecordsByNormalService Took :: " + (endTime - stratTime));
		return pulledAllRecords;
	}
}
