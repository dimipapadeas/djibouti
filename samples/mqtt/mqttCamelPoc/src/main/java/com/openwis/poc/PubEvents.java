package com.openwis.poc;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

public class PubEvents extends MainListenerSupport {

	private String message = "No message given";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void afterStart(MainSupport main) {
		System.out.println("MainExample with Camel is now started!");
		try {
		
 			main.getCamelTemplate().sendBody("direct:foo", getMessage());
			
		} catch (CamelExecutionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void beforeStop(MainSupport main) {
		System.out.println("MainExample with Camel is now being stopped");
	}
}


