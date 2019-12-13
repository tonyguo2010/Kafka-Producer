package com.seakie;

public class Main {

	public static void main(String[] args) {
		KafkaStreamsSample streamsThread = new KafkaStreamsSample();
		streamsThread.start();
		
		KafkaConsumerSample consumerThread = new KafkaConsumerSample();
		consumerThread.start();
		
		KafkaProducerSample.work();
	}
}
