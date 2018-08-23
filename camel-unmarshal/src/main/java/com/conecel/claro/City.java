package com.conecel.claro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator=",", crlf="WINDOWS")
@XmlRootElement(name="Ciudad")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	
	@DataField(pos = 1)
	@XmlElement(name="id")
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
