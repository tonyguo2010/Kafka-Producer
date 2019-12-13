package com.seakie;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;

public class KafkaStreamsSample extends Thread {

	private KafkaStreams streams = null;
	
	@Override
	public void run() {
		// change it to your topic name
		String topicName = "test";
		String targetTopic = "dest";
		// change it to your Kafka server IP and Port
		String remoteHost = "192.168.0.33:9092";

		Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "pass-through");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, remoteHost);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
 
        StreamsBuilder builder = new StreamsBuilder();
        builder.stream(topicName).to(targetTopic);
 
        streams = new KafkaStreams(builder.build(), props);
        streams.cleanUp();
        streams.start();
	}
	
	public void finish() {
		streams.close();
	}
}
