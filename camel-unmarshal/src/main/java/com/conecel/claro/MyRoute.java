package com.conecel.claro;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.BindyType;
//import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
 
import org.springframework.stereotype.Component;



import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
 
     //prueba1();
     
     //prueba2();
		
      prueba3();
		 
		 
		 	
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
		/*ClassLoader cl = ObjectFactory.class.getClassLoader();
        JAXBContext jc = JAXBContext.newInstance(DistrictCollection.class.getPackage().getName(), cl);
        JaxbDataFormat jaxb = new JaxbDataFormat(jc);
        jaxb.setPartClass(DistrictCollection.class.getName());
		
		
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
			.completionTimeout(1000).convertBodyTo(DistrictCollection.class)
			.unmarshal(jaxb).log("Done"); 
			
			/*.log(" Visitados ${header.visited} ").process(e-> {
				DistrictCollection bistrictCollection = e.getIn().getBody(DistrictCollection.class);
				System.out.println("size: " + bistrictCollection.getDistricts().size());
				
			}); */
			//serializar el resultado
			//.unmarshal(jaxbDataFormat).log("Finalizado");
			//.to("file:data/out?fileName=districts.xml&fileExist=Override");
		 
		
	}
	
	private void prueba3() throws JAXBException {

		from("file:data/in?fileName=cities.csv&noop=true").
		unmarshal().
		bindy(BindyType.Csv, City.class).split()
		.body().setHeader("district",simple("${body.district}"))
		.aggregate(header("district"),new DistrictAggregationStrategy())
		//agrego para luego filtrar
		.setHeader("visited",simple("si"))
		.completionTimeout(1000)
		.aggregate(header("visited"),  new TestStrategy())
		.completionTimeout(1000)
		.unmarshal(new JaxbDataFormat(JAXBContext.newInstance(District.class,DistrictCollection.class)) )
		.to("file:data/out?fileName=districts.xml&fileExist=Override")
		.log("finalizado");
		
    
		
	}
	
	
	private void prueba2() throws JAXBException {

		from("file:data/in?fileName=cities.csv&noop=true").
		unmarshal().
		bindy(BindyType.Csv, City.class).split()
		.body().setHeader("district",simple("${body.district}"))
		.aggregate(header("district"),new DistrictAggregationStrategy()).completionTimeout(1000)
		.unmarshal(new JaxbDataFormat(JAXBContext.newInstance(District.class)) ).to("file:data/out?fileName=districts.xml&fileExist=Override").log("finalizado");
		
    
		
	}
	
	
	
	private void prueba1() throws JAXBException {

		from("file:data/in?fileName=cities.csv&noop=true").
		unmarshal().
		bindy(BindyType.Csv, City.class).split()
		.body().unmarshal(new JaxbDataFormat(JAXBContext.newInstance(City.class)) ).log("${body}");
		
    
		
	}
 
	
	
    
    
    
}