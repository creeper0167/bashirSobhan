package com.bashir.demo.camelProcessor;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.bashir.demo.Numbers;

import org.apache.camel.Processor;

@Component
public class MyProcess implements Processor{
	
	private Numbers n = new Numbers();
	
	@Override
	public void process(Exchange exchange) throws Exception{
		int a = exchange.getIn().getBody(Integer.class);
		n.add(a);
		exchange.getIn().setBody(n.getSum());
	}
	
	

}
