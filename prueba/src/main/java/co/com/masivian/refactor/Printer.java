package co.com.masivian.refactor;

public class Printer {
	
	/** Cantidad de Numeros primos **/
	private static final int NUMBER_OF_PRIMES = 1000;

	/** Filas por pagina **/
	private static final int ROWS_PER_PAGE = 50;
	
	/** Columnas por pagina **/
	private static final int COLUMNS_PER_PAGE = 4;

	public static void main(String[] args) {
		int[] primes = Generator.generate(NUMBER_OF_PRIMES);
		PagePrinter pagePrinter = new PagePrinter(ROWS_PER_PAGE, COLUMNS_PER_PAGE, "The First " + NUMBER_OF_PRIMES + " Prime Numbers");
		pagePrinter.print(primes);
	}
}
