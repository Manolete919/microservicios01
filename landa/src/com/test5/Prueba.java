package com.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Prueba {

	public static void main(String[] args) {
		
		String valorAComparar = "hola";
		String valorParametro = "hola";
		
		List<OperadorPredicado> operadorPredicados = new ArrayList<>();
		
		Predicate<String> p =  x ->  x.equalsIgnoreCase(valorAComparar);				
		OperadorPredicado e = new OperadorPredicado("==",p,valorParametro);
		operadorPredicados.add(e);
		p =  x ->  !x.equalsIgnoreCase(valorAComparar);				
		e = new OperadorPredicado("!=",p,valorParametro);
		operadorPredicados.add(e);
														
		boolean res = evaluar(operadorPredicados,"!=");
		System.out.println("es diferente: " + res);
		
		res = evaluar(operadorPredicados,"==");
		System.out.println("es igual: " + res);
 
	}

	private static boolean evaluar(List<com.test5.OperadorPredicado> operadorPredicados, String evaluationOperator) {
		for(OperadorPredicado  op : operadorPredicados) {
			
			if (op.getOperdor().equalsIgnoreCase(evaluationOperator) && op.getP().test(op.getValorParametro()) ) {								 
					
				return true;				 								
			
			}	

		}

		return false;
	}

 
 

 
}
