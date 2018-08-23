package com.conecel.claro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class CamelConfig {

  
	 

	   @Bean
	    public ConnectionFactory rabbitConnectionFactory(){
	        ConnectionFactory connectionFactory = new ConnectionFactory();
	        connectionFactory.setHost("192.168.99.100");
	        connectionFactory.setUsername("guest");
	        connectionFactory.setPassword("guest");
	        connectionFactory.setVirtualHost("/");
	      
	        connectionFactory.setPort(5672);
	        connectionFactory.setAutomaticRecoveryEnabled(true);
 
	        
	        // more config options here etc
	        return connectionFactory;
	    }  
}