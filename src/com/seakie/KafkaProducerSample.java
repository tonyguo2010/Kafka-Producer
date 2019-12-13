package com.seakie;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerSample {

	public static void work() {
		// change it to your topic name
		String topicName = "test";
		// change it to your Kafka server IP and Port
		String remoteHost = "192.168.0.33:9092";
		Properties props = new Properties();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, remoteHost);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		for (int i = 0; i < 5; i++) {
			producer.send(new ProducerRecord<String, String>(topicName, "No " + i, "" + i));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Message sent");
		producer.close();
	}

}
