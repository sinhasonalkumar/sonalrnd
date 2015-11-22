package com.sonal.iot.mqtt.demo.publisher;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class DemoPublisher {
   

    public static void demoPublish() throws InterruptedException {
	String topicName = "testTopic";
	String content = "Hello World To MQTT-PAHO";
	int qos = 2;
	String broker = "tcp://localhost:1993";
	String clientId = "someSensorPub";
	MemoryPersistence persistence = new MemoryPersistence();

	try {
	    MqttClient someMQTTClient = new MqttClient(broker, clientId, persistence);

	    MqttConnectOptions connOpts = new MqttConnectOptions();
	    connOpts.setCleanSession(true);

	    
	    someMQTTClient.setCallback(new MqttCallback() {

		@Override
		public void messageArrived(String topicName, MqttMessage msg) throws Exception {
		    //System.out.println("Message Arrived On Topic :: " + topicName + " :: Message :: " + msg.getPayload());
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken dt) {
		    if(dt.isComplete()){
			System.out.println("Message Delivered :: MessaageId :: " + dt.getMessageId());
		    }else{
			System.out.println("Message Delivery  Exception :: " + dt.getException());
		    }
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

	    System.out.println("Publishing message: " + content);
	    MqttMessage mqttMessage = new MqttMessage(content.getBytes());
	    mqttMessage.setQos(qos);
	    //mqttMessage.setRetained(true);
	    
	    MqttTopic mqttTopic = someMQTTClient.getTopic(topicName);
	    
	   // someMQTTClient.publish(topic, message);
	    MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
	    
	    System.out.println("Message published");
	    
	    token.waitForCompletion();
	    
	   // Thread.sleep(5000);

	    someMQTTClient.disconnect();
	    System.out.println("Disconnected");
	    someMQTTClient.close();
	   
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
