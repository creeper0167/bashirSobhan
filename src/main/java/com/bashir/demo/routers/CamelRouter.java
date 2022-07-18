package com.bashir.demo.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.bashir.demo.camelProcessor.MyProcess;

@Component
public class CamelRouter extends RouteBuilder{
	@Override
	public void configure() {
		//Producer
		from("timer:myTimer?period=10000").transform()
			.simple("${random(1,101)}")
			.to("kafka:demo-topic?brokers=localhost:9092");
//		
//		//Consumer
		from("timer:Tim?period=60000").pollEnrich("kafka:demo-topic?brokers=localhost:9092&seekTo=beginning")
		.process(new MyProcess()).log("body is: ${body}");
		
		
	}
}
