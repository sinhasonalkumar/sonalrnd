package com.sonal.iot.mqtt.demo.subscriber;

import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class DemoSubscriber {
    public static void demoSubscribe() throws InterruptedException {
	String topicName = "testTopic";
	int qos = 2;
	String broker = "tcp://localhost:1993";
	String clientId = "someSensorSubs";
	MemoryPersistence persistence = new MemoryPersistence();

	try {
	    MqttClient someMQTTClient = new MqttClient(broker, clientId, persistence);

	    MqttConnectOptions connOpts = new MqttConnectOptions();
	    connOpts.setCleanSession(true);
	    
	    someMQTTClient.setCallback(new MqttCallback() {

		@Override
		public void messageArrived(String topicName, MqttMessage msg) throws Exception {
		    byte[] payload = msg.getPayload();
		    String message = new String(payload);
		    
		    System.out.println("Message Arrived On Topic :: " + topicName + " :: Message :: " + message);
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken dt) {
		    //
		}

		@Override
		public void connectionLost(Throwable t) {
		   System.out.println("Connection Lost :: Reason :: " + t.toString() );
		   t.printStackTrace();

		}
	    });

	    System.out.println("Connecting to broker: " + broker);
	    someMQTTClient.connect(connOpts);
	    System.out.println("Connected");

	    someMQTTClient.subscribe(topicName,qos);
	   
	} catch (MqttException me) {
	    System.out.println("reason " + me.getReasonCode());
	    System.out.println("msg " + me.getMessage());
	    System.out.println("loc " + me.getLocalizedMessage());
	    System.out.println("cause " + me.getCause());
	    System.out.println("excep " + me);
	    me.printStackTrace();
	}
    }
}
