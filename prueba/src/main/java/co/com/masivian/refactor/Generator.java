package co.com.masivian.refactor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {

	/** Array de numeros primos **/
	private static int[] primes;

	/** Numero 2 de constante **/
	private static final int NUMBER_TWO = 2;
	
	/** Numero 1 de constante **/
	private static final int NUMBER_ONE = 1;
	
	/** Numero 0 de constante **/
	private static final int NUMBER_ZERO = 0;

	/**
	 * Genera los numeros primos
	 * @param cantidad de numeros primos a construir
	 * @return
	 */
	protected static int[] generate(int n) {
		primes = new int[n];
		verifyNumbersPrime();
		//verifyNumbersPrimeWitStream();
		return primes;
	}

	/**
	 * Verifica si el numero es primo recorriendo la cantidad que se espera
	 */
	private static void verifyNumbersPrime() {
		int primeIndex = 1;
		for (int j = NUMBER_TWO; j <= Integer.MAX_VALUE && primeIndex < primes.length; j++) {
			if(isPrime(j)) {
				primes[primeIndex++] = j;
			}
		}
	}
	
	/**
	 * Genera la lista de numeros primos con java 8 streams
	 */
	private static void verifyNumbersPrimeWitStream(){
		List<Integer> primeList = IntStream.range(2, Integer.MAX_VALUE)
				.filter(n -> isPrime(n))
				.limit(primes.length)
				.boxed()
				.collect(Collectors.toList());
		primes = primeList.stream().mapToInt(i->i).toArray();
	}

	/**
	 * Verifica si el numero ingresado es primo
	 * @param number a compara si es primo
	 * @return si el numero ingresado es primo
	 */
	private static boolean isPrime(int number) {

		if (number <= NUMBER_ONE) {
			return false; 
		}

		for (int i = NUMBER_TWO; i < number; i++) {
			if (number % i == NUMBER_ZERO) { 
				return false; 
			}
		}
		return true; 
	}

}
