package com.conecel.claro;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.conecel.claro.entidades.District;
import com.conecel.claro.entidades.DistrictCollection;

public class TestStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		/*if(oldExchange == null) {
			newExchange.getIn().setBody("valor");
			return newExchange;
		}
		
		return oldExchange; */
		
        District district = newExchange.getIn().getBody(District.class);
		
		if(oldExchange == null) {
			DistrictCollection  districtCollection = new DistrictCollection();
			districtCollection.addDistricts(district);
			//dado que es null
			newExchange.getIn().setBody(districtCollection);
			return newExchange;
		}else {
			DistrictCollection  districtCollection = oldExchange.getIn().getBody(DistrictCollection.class);
			districtCollection.addDistricts(district);
			oldExchange.getIn().setBody(districtCollection);
			return oldExchange;
		} 
		
	}

}
