package com.sonal.serialization.serialversionid;

import java.io.Serializable;

public class ExampleDTO implements Serializable {

	
	//if class have serialVersionUID defined then modification to class does not affect the de-serialization for the older object serialized before class modification. But we do not our custom serial servionId then default serial version id changes on class modification hence older objects will not be de-seralized after class modification
	// private static final long serialVersionUID = 1708316962382160675L;
	private static final long serialVersionUID = 1708316962382160675L;

	private int id;

	private String userName;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
