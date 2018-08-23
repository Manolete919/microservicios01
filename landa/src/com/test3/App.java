package com.test3;

public class App {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run(new Excecutable() {

 			public int execute(int a) {
				 
				return 7 + a;
 				
			}
			
		});
		System.out.println("Si el metodo no recibe parametro");
		
  		
		//r.run(()->{System.out.println("HOLA LANDA");System.out.println("HOLA LANDA"); return 9;});
		
		r.run((a)->  9 + a );
		
 
	}

}
