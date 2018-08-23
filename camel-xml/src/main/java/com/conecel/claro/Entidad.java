package com.conecel.claro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="raiz")
public class Entidad {
	
	int id;
	String name;
	
	public Entidad() {
		
	}
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
	

}
