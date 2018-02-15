package com.sonal.classpathdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassPathDemo {

    static {
	InputStream resourceAsStream1 = ClassPathDemo.class.getResourceAsStream("/app.properties");
	Properties properties1 = new Properties();
	
	InputStream resourceAsStream2 = ClassPathDemo.class.getResourceAsStream("/custom/custom.properties");
	Properties properties2 = new Properties();
	
	InputStream resourceAsStream3 = ClassPathDemo.class.getResourceAsStream("current.properties");
	Properties properties3 = new Properties();
	try {
	    properties1.load(resourceAsStream1);
	    String value1 = properties1.getProperty("app.name");
	    
	    properties2.load(resourceAsStream2);
	    String value2 = properties2.getProperty("app.name");
	    
	    properties3.load(resourceAsStream3);
	    String value3 = properties3.getProperty("app.name");
	    
	    System.out.println(value1);
	    System.out.println(value2);
	    System.out.println(value3);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    
    public static void main(String[] args) {
	System.out.println("running");
    }
}
