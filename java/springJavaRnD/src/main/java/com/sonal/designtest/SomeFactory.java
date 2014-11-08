package com.sonal.designtest;

import org.springframework.stereotype.Component;

@Component
public class SomeFactory implements IFactory {

	@Override
	public Object getSomeInstance() {
		return null;
	}
}
