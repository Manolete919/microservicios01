package com.conecel.claro;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.BindyType;
//import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
 
import org.springframework.stereotype.Component;

import com.conecel.claro.entidades.District;
import com.conecel.claro.entidades.DistrictCollection;

import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Component
public class MyRoute extends RouteBuilder {

    //@Override
    public void configure2() throws Exception {
    	System.out.println("hola");
    	
    	int portNum = 9092;
    	
    	//https://www.youtube.com/watch?v=aMCIw88AZeA
    	
    	/*this.restConfiguration().component("restlet")
    	.host("localhost").port(portNum);
    	
    	this.rest("/api/people")
    	         .get().route().setBody(constant("Rod"));  */
    	

    	//no se necesita el bean factory
    	//from("rabbitmq://192.168.99.100/test-direct?queue=learningqueue&autoDelete=false&connectionFactory=#rabbitConnectionFactory").to("stream:out") ;
    	//from("rabbitmq:test-direct?queue=learningqueue&autoDelete=false&connectionFactory=#rabbitConnectionFactory").to("stream:out") ;
    	//Se necesita el bean del factory
    	//from("rabbitmq:test-direct?queue=learningqueue&autoDelete=false").to("stream:out") ;
    	
    	
    	/*rest("/say")
        	.get("/hello").to("direct:hello")
        	.get("/bye").consumes("application/json").to("direct:bye")
        	.post("/bye").to("mock:update");

	    from("direct:hello")
	        .transform().constant("Hello World");
	    from("direct:bye")
	        .transform().constant("Bye World"); */
	    
	    
	    
	 // configure to use restlet on localhost with the given port
	 // and enable auto binding mode
    	
    	
	// restConfiguration().component("restlet").host("localhost").port(portNum).bindingMode(RestBindingMode.auto);

	 // use the rest DSL to define the rest services
	 /*rest("/users/")
	     .post().type(UserPojo.class)
	         .to("direct:newUser");
	 
	 from("direct:newUser").to("stream:out"); */
	 //https://www.programcreek.com/java-api-examples/index.php?api=org.apache.camel.model.rest.RestBindingMode
	 
	restConfiguration().component("restlet").host("localhost").port(portNum).bindingMode(RestBindingMode.json).skipBindingOnErrorCode(false);

	// use the rest DSL to define the rest services
	rest("/users/")
	    .post("lives")  .type(UserPojo.class).outType(CountryPojo.class)
	        .route()
	            .choice()
	                .when().simple("${body.name} == 'Manuel'")
	                    .bean(new UserErrorService(), "idToLowError")
	                .otherwise()
	                    .bean(new UserService(), "livesWhere");
	    

 
    }
    
    
   
    public void configure3() throws Exception {
    	System.out.println("funcionooo");
    	
    	
    	/*from("jetty://http://localhost:8888/greeting")  
    	.log("Received a request")  
    	.setBody(simple("Hello, world!")); */
    	
    	//https://stackoverflow.com/questions/40756027/apache-camel-json-marshalling-to-pojo-java-bean
    	
        from("jetty:http://localhost:8888/foo").to("direct:foo");
        System.out.println("it worked");
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
        
        
        
        
        
        
        /*errorHandler(deadLetterChannel("jms:queue:dead")
        		  .useOriginalMessage()
        		  .maximumRedeliveries(5)
        		  .redeliverDelay(5000)); */

		/*errorHandler(defaultErrorHandler()
		  .allowRedeliveryWhileStopping(false)
		  .maximumRedeliveries(20)
		  .redeliveryDelay(1000)
		  .retryAttemptedLogLevel(LoggingLevel.INFO)); */
        
        
        
    }



	//@Override
	public void configure4() throws Exception {
		

		

		from("file:C:/inbox").process(exchange->{
			String a = exchange.getIn().getBody(String.class);
	        System.out.println("hello " + a);
		}).split().tokenize("\n")
		.to("rabbitmq:tasks?autoDelete=false&routingKey=camel&queue=task_queue");
		
		//.to("rabbitmq:192.168.99.100:5672/tasks?username=guest&password=guest&autoDelete=false&routingKey=camel&queue=task_queue");
		
		//from("direct:foo").setBody(simple("hola"));
		
		
		
 		
	}



	//@Override
	public void configure() throws JAXBException {

	 
		
		this.aggregator();
		
	}
	
	private void aggregator() throws JAXBException {
		
		// XML Data Format
		
		 

         
		 
		 
		 	
		/*JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(); 
		jaxbDataFormat.setContextPath("com.conecel.claro.entidades"); */ 
 
 
				
		  
		 
		 	 /*JaxbDataFormat xmlDataFormat = new JaxbDataFormat(false);
		  xmlDataFormat.setContextPath("com.conecel.claro");  */
		
		/*JaxbDataFormat df = new JaxbDataFormat();
        df.setContextPath("com.conecel.claro");
        df.setNamespacePrefixRef("myPrefix"); */
		
		/*JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(DistrictCollection.class);
		 
		xmlDataFormat.setContext(con);

		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
        JAXBContext con = JAXBContext.newInstance(DistrictCollection.class);*/  
        
       /* JAXBContext jaxbContext;
        JaxbDataFormat jaxbDataFormat = null;
		try {
			jaxbContext = JAXBContext.newInstance(DistrictCollection.class);
			jaxbDataFormat = new JaxbDataFormat(jaxbContext);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//https://stackoverflow.com/questions/27658622/jaxb-unmarshalling-not-working-properly
 
		
			
			from("file:data/in?fileName=cities.csv&noop=true").unmarshal().bindy(BindyType.Csv, City.class)
			//agrupar por el distrito, y contar el total de habitantes
			//split del cuerpo que contiene la lista
			.split().body()
			//agrega el header con el valor de cada district 
			.setHeader("district",simple("${body.district}"))
			//ahora vamos a agrupar por cada valor de district que se encuentra en el header
			//solicitará la estrategia que se utilizar por cad elemento
			.aggregate(header("district"),new DistrictAggregationStrategy())
			.setHeader("visited",simple("si"))
			//especificar como se debe completar
			.completionTimeout(1000)
			.log(" Habitantes ${body.inhabitants} ")
			//cada exchange que entre al route tendra la misma constante, se agruparan todas
			//.aggregate(header("visited"),new DistrictsAggregationStrategy())
			.completionTimeout(1000)
			.aggregate(header("visited"),  new TestStrategy())
			.completionTimeout(1000) 
			.unmarshal(new JaxbDataFormat(JAXBContext.newInstance(District.class,DistrictCollection.class)))
			
			/*.log(" Visitados ${header.visited} ").process(e-> {
				DistrictCollection bistrictCollection = e.getIn().getBody(DistrictCollection.class);
				System.out.println("size: " + bistrictCollection.getDistricts().size());
				
			}); */
			//serializar el resultado
			//.unmarshal(jaxbDataFormat).log("Finalizado");
			.to("file:data/out?fileName=districts.xml&fileExist=Override");
		 
		 
		
	}



	public void resp() {
		
 		errorHandler(deadLetterChannel("rabbitmq:work.exchange2?autoDelete=false&routingKey=camel&queue=task_queue2").useOriginalMessage().maximumRedeliveries(2).redeliverDelay(5000));

		from("rabbitmq:tasks?autoDelete=false&routingKey=camel&queue=task_queue").process(exchange -> {
			
			String a = exchange.getIn().getBody(String.class);
	        System.out.println("message " + a);
			System.out.println("lanzada la exception");
			throw new Exception();
			
		}).to("stream:out");  
		  
		
		/*from("file:C:/inbox").process(exchange->{
			String a = exchange.getIn().getBody(String.class);
	        System.out.println("mensaje original " + a);
		}).split().tokenize("\n")
		.to("rabbitmq:tasks2?autoDelete=false&routingKey=camel2&queue=task_queue2"); */
		 
		/* 
		from("rabbitmq:tasks?autoDelete=false&routingKey=camel&queue=task_queue").process(exchange -> {
			
			String a = exchange.getIn().getBody(String.class);
	        System.out.println("message " + a);
	        
	        exchange.getIn().setBody("mensaje alterado");
		
		}).to("rabbitmq:tasks2?autoDelete=false").process(exchange -> {
			
			String a = exchange.getIn().getBody(String.class);
	        System.out.println("message received " + a);
		
		}).end();
		
		
		*/
		/*
		this.from("restlet:http://localhost:8181/users/{id}/basic").process(e->{
			
			String id = e.getIn()
					.getHeader("id",String.class);
			e.getOut().setBody("Manolete"+id);
		});
		
		this.from("direct:start")
		.to("restlet:http://localhost:8181/users/919/basic");
		*/
		
		//java// will use original body 
	}
    
    
    
}