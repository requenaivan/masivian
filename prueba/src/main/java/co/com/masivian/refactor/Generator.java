package co.com.masivian.refactor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator implements Runnable{

	/** Array de numeros primos **/
	private int[] primes;

	/** Numero 2 de constante **/
	private static final int NUMBER_TWO = 2;
	
	/** Numero 1 de constante **/
	private static final int NUMBER_ONE = 1;
	
	/** Numero 0 de constante **/
	private static final int NUMBER_ZERO = 0;

	public Generator(int n) {
		this.primes = new int[n];
	}


	/**
	 * Verifica si el numero es primo recorriendo la cantidad que se espera
	 */
	private synchronized void verifyNumbersPrime() {
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
	private void verifyNumbersPrimeWitStream(){
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

	@Override
	public void run() {
		verifyNumbersPrime();
	}
	
	/**
	 * get de array de numeros primos
	 * @return
	 */
	public  int[] getPrimes() {
		return primes;
	}

}
