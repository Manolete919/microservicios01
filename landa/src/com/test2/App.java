package com.test2;

public class App {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run(new Excecutable() {

 			public int execute() {
				 
				return 7;
 				
			}
			
		});
		System.out.println("Si el metodo no recibe parametro");
		
  		
		
		r.run(()->  9 + 2 );
		
 
	}

}
