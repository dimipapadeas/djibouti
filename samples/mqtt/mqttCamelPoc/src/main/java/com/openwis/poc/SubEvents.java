package com.openwis.poc;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

public class SubEvents extends MainListenerSupport {

	@Override
	public void afterStart(MainSupport main) {
		System.out.println("Subscriber with Camel is now started!");
		try {
			Endpoint endpoint = main.getCamelTemplate().getCamelContext().getEndpoint("direct:foo");
			PollingConsumer consumer = endpoint.createPollingConsumer();
			consumer.start();
		while (true){	
			Exchange exchange = consumer.receive();
			String msg = exchange.getIn().getBody().toString();
			System.out.println("Message received:       "+ msg);
			if (msg == null || msg.isEmpty() ) {
	            // no more messages in queue
	            break;
	        }
		}
		
		} catch (CamelExecutionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void beforeStop(MainSupport main) {
		System.out.println("Subscriber with Camel is now being stopped");
	}
}


