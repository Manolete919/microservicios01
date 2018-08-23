package com.conecel.claro;

import org.apache.camel.Exchange;

public class UserService {
	
    public void livesWhere(Exchange exchange) {
    	System.out.println("body: " + exchange.getIn().getBody());
       //String x = exchange.getIn().getBody().toString();
       //System.out.println("valor: " + x);
         
    }

}
