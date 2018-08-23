package com.conecel.claro;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

 

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource({"classpath:spring/camel-context.xml"})
public class CamelXmlApplicationTests {

 
	
	@Test
	public void contextLoads() throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.99.100");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection;
		try {
			connection = factory.newConnection();

			Channel channel = connection.createChannel();
		 
			channel.exchangeDeclare("KipcastDirect", "direct", 
				   true, 	/* durable */
				   true, 	/* autodelete */
				   null); 	/* */
		 
			byte[] messageBodyBytes = "Hello, world!".getBytes();
		 
			AMQP.BasicProperties.Builder basic = new AMQP.BasicProperties.Builder();
			AMQP.BasicProperties minBasic = basic.build();
		 
			minBasic = basic.priority(0).deliveryMode(1).build();
		 
			channel.basicPublish("KipcastDirect", "KipcastRouting", minBasic, messageBodyBytes);
			System.out.println(" [x] Sent ");
		 
			channel.close();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
