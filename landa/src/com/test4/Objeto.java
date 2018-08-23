package com.test4;

public class Objeto {
	
	int minimo;
	int numero;

	public Objeto(int minimo,int numero) {
		this.minimo = minimo;
		this.numero = numero;
	}
	
	
	public  boolean noneMatch(Implementacion ix){
		
 		
		for(int indice = minimo; indice <= (numero - minimo)+1; indice ++ ) {
			
			 if(ix.comparador(indice)) {
				 return false;
			 }

		}
		  
		return true;
		  
		
	}
}
