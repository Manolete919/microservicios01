package com.conecel.claro.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.conecel.claro.City;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Distrito")
public class District {
	
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="inhabitants")
	private int inhabitants;
	

	private District() {

	}
 

	public District(String name) {
		this();
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getInhabitants() {
		return inhabitants;
	}



	public void setInhabitants(int inhabitants) {
		this.inhabitants = inhabitants;
	}
	
	public void addCityInhabitants(City city) {
		this.inhabitants += city.getInhabitans();
	}
	 
	
}
