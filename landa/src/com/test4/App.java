package com.test4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		 
		//System.out.println(isPrime(2));
		/*System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(5));
		System.out.println(isPrime(6));
		System.out.println(isPrime(7));
		System.out.println(isPrime(8));
		System.out.println(isPrime(9));
		*/
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		
		Function<Integer,Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

		values.stream().filter(isGreaterThan.apply(3)).forEach(e -> System.out.println("hola" + e));
		
		Predicate<Integer> x = null;
		evaluarLista(values, y -> y % 2==0);
		int b = 6;
		evaluarLista2(7,b, p-> p>b);
		

	}

 

	private static void evaluarLista2(int i, int j, Predicate<Integer> p) {
		System.out.println("Entree");
 		
		if (p.test(i)) {
			
			System.out.println("hola: se coumplio");
			 
		}
	}



	private static void evaluarLista(List<Integer> values, Predicate<Integer> y) {
		 
		for(Integer x : values) {
			
			if (y.test(x)) {
				
				System.out.println("x: " + x);
			}
			
		}
		
		
	}

	private static boolean isPrime(int n) {
		
		/*for(int i = 2; i < n ; i ++) {
			if(n % i == 0) return false;
		}
		return n > 1; 
		*/
		//System.out.println("hola");
		return n > 1 && Runner.range(2, n).noneMatch(index -> {
			System.out.println("i:" + index + ":" + n);
			return n % index == 0;
		}); 
		
		
		/*Runner.range(2, n).noneMatch(new Implementacion() {

			@Override
			public boolean comparador(int indice) {
				
				for(int i = 0; i<= indice; i ++ ) {
					
					System.out.println("i:" + indice + ":" + n);

				}
				return false;
				 
				
			}
			
		}); */
		
		/*return n > 1 &&
				IntStream.range(2, n).noneMatch(index -> {
					System.out.println("i:" + index + ":" + n);
					return n % index == 0;
				});  */
		
		//return false;
		

		
		
		
	}

}
