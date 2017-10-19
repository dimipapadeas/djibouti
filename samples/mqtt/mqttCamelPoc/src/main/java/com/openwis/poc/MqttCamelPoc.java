package com.openwis.poc;

import org.apache.camel.main.Main;

public class MqttCamelPoc {

	private Main main;

	private String message = "";

	public static void main(String[] args) throws Exception {

		if (args.length < 1) {
			throw new IllegalArgumentException("Must have either 'publisher' or 'subscriber' as argument");
		}

		MqttCamelPoc mqttCamel = new MqttCamelPoc();
		switch (args[0]) {
		case "publisher":
			if (args.length == 2) {
				mqttCamel.setMessage(args[1]);
			}
			mqttCamel.bootPublisher();
			break;
		case "subscriber":
			mqttCamel.bootConsumer();
			break;
		default:
			throw new IllegalArgumentException("Unknown command: " + args[0]);
		}
	}

	public void bootPublisher() throws Exception {
		// create a Main instance
		main = new Main();
		// bind MyBean into the registry
		main.bind("foo", new AsimpleBean());
		main.addRouteBuilder(new PubRouteBuilder());
		// add event listener
		PubEvents pubEvt = new PubEvents();
		pubEvt.setMessage(this.getMessage());
		main.addMainListener(pubEvt);
		// run until you terminate the JVM
		main.run();
		System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");

	}

	public void bootConsumer() throws Exception {
		// create a Main instance
		main = new Main();
		// bind MyBean into the registry
		main.bind("foo", new AsimpleBean());
		// add routes
		main.addRouteBuilder(new SubRouteBuilder());

		// add event listener
		main.addMainListener(new SubEvents());
		// run until you terminate the JVM
		System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
		main.run();
	}

	public static class AsimpleBean {
		public void callMe() {
			System.out.println("A simple bean to bind");
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
