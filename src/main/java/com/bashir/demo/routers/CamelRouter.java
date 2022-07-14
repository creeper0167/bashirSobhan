package com.bashir.demo.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder{
	@Override
	public void configure() {
		from("timer:producerTimer?period=50000").bean("CamelController?method=sendMessage").log("producer timer trriger");
	}
}
