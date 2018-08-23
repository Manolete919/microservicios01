package com.test;

public class App {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run(new Excecutable() {

 			public void execute() {
				 
				System.out.println("HOLA");
 				
			}
			
		});
		System.out.println("Si el metodo no recibe parametro");
		
		r.run(()->System.out.println("HOLA LANDA"));
		
		r.run(()->{System.out.println("HOLA LANDA");System.out.println("HOLA LANDA");});
		
 
	}

}
