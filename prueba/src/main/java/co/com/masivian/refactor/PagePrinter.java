package co.com.masivian.refactor;

public class PagePrinter {
	
	/** filas por pagina **/
	private int rowsPerPage;
	
	/** columnas por pagina **/
	private int columnsPerPage;
	
	/** numeros por pagina **/
	private int numbersPerPage;
	
	/** encabezado de la pagina **/
	private String header;
	
	public PagePrinter(int rowsPerPage, int columnsPerPage, String header) {
		this.rowsPerPage = rowsPerPage;
		this.columnsPerPage = columnsPerPage;
		this.header = header;
		numbersPerPage = rowsPerPage * columnsPerPage;
	}

	/**
	 * Imprime la data generada
	 * @param data
	 */
	public void print(int data[]) {
		int pageNumber = 1;
		for (int firstIndex = 0;firstIndex < data.length; firstIndex += numbersPerPage) {
			int lastIndex= Math.min(firstIndex + numbersPerPage - 1, data.length - 1);
			printHeader(header, pageNumber);
			printPage(firstIndex, lastIndex, data);
			System.out.println("\f");
			pageNumber++;
		}
	}
	
	/**
	 * Imprime la pagina
	 * @param firstIndexOnPage
	 * @param lastIndexOnPage
	 * @param data
	 */
	private void printPage(int firstIndexOnPage, int lastIndexOnPage, int[] data) {
		int firstIndexOfLastRow = firstIndexOnPage + rowsPerPage - 1;
		for (int firstIndexInRow = firstIndexOnPage; firstIndexInRow <= firstIndexOfLastRow; firstIndexInRow++) {
			printRow(firstIndexInRow, lastIndexOnPage, data);
			System.out.println("");
		}
	}

	/**
	 * Imprime la fila
	 * @param firstIndexInRow
	 * @param lastIndexOnPage
	 * @param data
	 */
	private void printRow(int firstIndexInRow, int lastIndexOnPage, int[] data) {
		for (int column = 0; column < columnsPerPage; column++) {
			int index = firstIndexInRow + column * rowsPerPage;
			if (index <= lastIndexOnPage) {
				System.out.format("%10d", data[index]);
			}
		}
	}

	/**
	 * Imprime el encabezado de la pagina
	 * @param header
	 * @param pageNumber
	 */
	private void printHeader(String header, int pageNumber) {
		System.out.println(header + " --- Page " + pageNumber);
		System.out.println("");
	}

}
