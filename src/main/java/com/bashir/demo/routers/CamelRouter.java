package com.bashir.demo.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.bashir.demo.camelController.CamelController;

@Component
public class CamelRouter extends RouteBuilder{
	@Override
	public void configure() {
		
		//Producer
		from("timer:producerTimer?period=50000")
		.bean(CamelController.class, "sendRandomNumber")
		.log("producer timer trriger");
		
		//Consumer
	}
}
