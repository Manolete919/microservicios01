package com.conecel.claro;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Distritos")
@XmlAccessorType(XmlAccessType.FIELD)
public class DistrictCollection {
	 
	@XmlElement(name="district")
	private List<District> districts;

	public DistrictCollection() {
		districts = new ArrayList<>();
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public void addDistricts(District district) {
		districts.add(district);
	}
	
}
