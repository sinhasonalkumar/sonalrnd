package com.sonal.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User implements Serializable {

	private String userId;
	private String userName;
}
