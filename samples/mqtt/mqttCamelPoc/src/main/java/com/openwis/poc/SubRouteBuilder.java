package com.openwis.poc;

import org.apache.camel.builder.RouteBuilder;

public class SubRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		
		// consume Endpoint
		from("mqtt:bar?subscribeTopicName=wis_data").transform(body().convertToString()).to("direct:foo");
	
	}
}
