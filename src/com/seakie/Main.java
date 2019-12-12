package com.seakie;

public class Main {

	public static void main(String[] args) {
		KafkaConsumerSample consumerThread = new KafkaConsumerSample();
		consumerThread.start();
		
		KafkaProducerSample.work();
	}
}
