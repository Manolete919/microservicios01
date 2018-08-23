package com.conecel.claro;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class JacksonTestRoute extends RouteBuilder{
   
    public void configure() throws Exception {
        from("jetty:http://localhost:8181/foo").to("direct:foo");

        from("direct:foo")
        .unmarshal().json(JsonLibrary.Jackson, Foo.class)
        .choice()
            .when().simple("${body.foo} == 'toto'")
                .log("sending to beanA")
                .to("bean:beanA")
            .otherwise()
                .log("sending to beanB")
                .to("bean:beanB")
        // close the choice() block :
        .end()
        // per the javadoc for marshall(), "the output will be added to the out body" :
        .marshal().json(JsonLibrary.Jackson);
    } 
}

 



