package com.bashir.demo.kafkaProducers;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaProducer;
	private String message;
	private final String topic_name = "demo-topic";
	
	public void sendMessage(String message) {
		this.message = message;
		String key_value = "key_" + this.message;
		kafkaProducer.send(
				new ProducerRecord<String, String>(topic_name, key_value , this.message)
				);
	}
	
	public String getTopicName() {
		return this.topic_name;
	}
}
