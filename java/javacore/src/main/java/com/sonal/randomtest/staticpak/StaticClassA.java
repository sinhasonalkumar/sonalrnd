package com.sonal.randomtest.staticpak;

public class StaticClassA {

	//No enclosing instance of type StaticClassA is available due to some intermediate constructor invocation
	/*public static class ClassStaticClassInner extends TestClassB {

	}
*/
	
	public static class ClassStaticClassInner {

	}
	
	public class TestClassA extends ClassStaticClassInner {

	}

	public class TestClassB {

	}
}
