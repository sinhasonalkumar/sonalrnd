package com.sonal.manager.rest.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames=true)
public class JobResponseVO {

	private String jobRequestId;

	private String status;


	public JobResponseVO(String jobRequestId, String status) {
		super();
		this.jobRequestId = jobRequestId;
		this.status = status;
	}
}
