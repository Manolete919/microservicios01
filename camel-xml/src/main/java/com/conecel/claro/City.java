package com.conecel.claro;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator=",", crlf="WINDOWS")
public class City {
	
	@DataField(pos = 1)
	private int id;
	@DataField(pos = 2)
	private String name;
	@DataField(pos = 3)
	private String district;
	@DataField(pos = 4)
	private int inhabitans;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getInhabitans() {
		return inhabitans;
	}
	public void setInhabitans(int inhabitans) {
		this.inhabitans = inhabitans;
	}
	
	

}
