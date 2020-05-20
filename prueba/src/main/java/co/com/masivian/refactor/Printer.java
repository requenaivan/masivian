package co.com.masivian.refactor;

import java.util.Date;

public class Printer {
	
	/** Cantidad de Numeros primos **/
	private static final int NUMBER_OF_PRIMES = 1000;

	/** Filas por pagina **/
	private static final int ROWS_PER_PAGE = 50;
	
	/** Columnas por pagina **/
	private static final int COLUMNS_PER_PAGE = 4;

	public static void main(String[] args) {
		long t0 = (new Date()).getTime();
		Generator generator = new Generator(NUMBER_OF_PRIMES);
		generator.run();
		PagePrinter pagePrinter = new PagePrinter(ROWS_PER_PAGE, COLUMNS_PER_PAGE, "The First " + NUMBER_OF_PRIMES + " Prime Numbers");
		pagePrinter.print(generator.getPrimes());
		long t1 = (new Date()).getTime();
		System.out.println(" Tiempo de ejecucion: " + (t1 - t0) + " miliseg.");

	}
}
