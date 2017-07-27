package com.sonal.manager.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobResponseVO {

	private String jobRequestId;

	private String status;


	public JobResponseVO(String jobRequestId, String status) {
		super();
		this.jobRequestId = jobRequestId;
		this.status = status;
	}
}
