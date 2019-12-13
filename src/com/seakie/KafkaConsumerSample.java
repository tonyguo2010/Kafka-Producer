package com.seakie;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerSample extends Thread {

	@Override
	public void run() {
		// change it to your topic name
		String topicName = "test";
		// change it to your Kafka server IP and Port
		String remoteHost = "192.168.0.33:9092";
		Properties props = new Properties();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, remoteHost);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id_not_exist");
		Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		consumer.subscribe(Arrays.asList(topicName));

		// exit the thread in 30 seconds
		for (int i = 0; i < 30; i++) {
			try {
				Thread.sleep(1000);

				ConsumerRecords<String, String> records = consumer.poll(1000);

				for (ConsumerRecord<String, String> record : records) {
					System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(),
							record.value());
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
