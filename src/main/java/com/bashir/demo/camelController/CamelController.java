package com.bashir.demo.camelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashir.demo.kafkaProducers.KafkaProducerService;

@Service
public class CamelController {

	@Autowired
	private KafkaProducerService kafkaProducer;
	private int randomNumber;
	
	public void sendRandomNumber() {
		randomNumber = (int) (0 + Math.random() * 100);
		kafkaProducer.sendMessage(Integer.toString(randomNumber));
	}
	
}
