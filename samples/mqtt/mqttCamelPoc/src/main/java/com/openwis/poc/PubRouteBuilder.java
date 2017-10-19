package com.openwis.poc;

import org.apache.camel.builder.RouteBuilder;

public class PubRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {

		from("direct:foo").to("mqtt:cheese?publishTopicName=wis_data");

	}
}
