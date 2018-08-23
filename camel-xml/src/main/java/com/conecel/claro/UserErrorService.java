package com.conecel.claro;

import org.apache.camel.Exchange;

public class UserErrorService {
    public void idToLowError(Exchange exchange) {
    	System.out.println("entroo por el error");
        exchange.getIn().setBody("id value is too low");
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "text/plain");
        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
    }
}