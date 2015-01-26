package com.sonal.serialization.refrencecase;

import java.io.Serializable;

public class SerializeClassA implements Serializable {

	private NonSerialzableClass nonSerialzableClass;

	public NonSerialzableClass getNonSerialzableClass() {
		return nonSerialzableClass;
	}

	public void setNonSerialzableClass(NonSerialzableClass nonSerialzableClass) {
		this.nonSerialzableClass = nonSerialzableClass;
	}
	
	
}
