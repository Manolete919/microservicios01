package com.test5;

 
import java.util.function.Predicate;

public class OperadorPredicado {
	
	String operdor;	
	Predicate<String> p;
	String valorParametro;
	
	public OperadorPredicado(String operdor, Predicate<String> p, String valorParametro) {
		super();
		this.operdor = operdor;
		this.p = p;
		this.valorParametro = valorParametro;
	}
	public String getOperdor() {
		return operdor;
	}
	public void setOperdor(String operdor) {
		this.operdor = operdor;
	}
	public Predicate<String> getP() {
		return p;
	}
	public void setP(Predicate<String> p) {
		this.p = p;
	}
	public String getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}
 
	 
}
