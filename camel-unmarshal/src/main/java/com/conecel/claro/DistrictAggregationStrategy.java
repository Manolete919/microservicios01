package com.conecel.claro;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class DistrictAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		//System.out.println("entrar");
		//todo un siempre recupero desde newExchange la ciudad
		//City actual a hacer sumada
		City city = newExchange.getIn().getBody(City.class);
		//la primera vez es null
		if(oldExchange == null) {
			//Hare la agregacion en el newExchange
			District district = new District(city.getDistrict());
			district.addCityInhabitants(city);
			newExchange.getIn().setBody(district);
			return newExchange;
		}else {
			//recuperar el distrito que setenamos anteriormente
			District district = oldExchange.getIn().getBody(District.class);
			district.addCityInhabitants(city);
			
			//donde agrega District?
			oldExchange.getIn().setBody(district);
			
			return oldExchange;
			
		}
		
	 
	}

}
