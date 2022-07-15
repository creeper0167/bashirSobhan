package com.bashir.demo.camelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.bashir.demo.kafkaProducers.KafkaProducerService;

@Service
public class CamelController {

	@Autowired
	private KafkaProducerService kafkaProducer;
	private long sum = 0; //storing sum of random numbers
	private int randomNumber; 
	
	public void sendRandomNumber() {
		randomNumber = (int) (0 + Math.random() * 100);
		kafkaProducer.sendMessage(Integer.toString(randomNumber));
	}
	
	//show the sum of numbers
	public void showResult() {
		System.out.println("Sum till now is: " + Long.toString(sum));
	}
	
	//listens for KAFKA_TOPIC write event to be trigger 
	@KafkaListener(topics="demo-topic")
	public void readM(@Payload String message) {
		sum += Integer.parseInt(message);
	}
}
