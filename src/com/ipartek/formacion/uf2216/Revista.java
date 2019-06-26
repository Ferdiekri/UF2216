package com.ipartek.formacion.uf2216;

public class Revista implements Comparable<Revista> {

	static final int MINIMO_TITULO = 3;
	static final int MAXIMO_TITULO = 150;
	static final int LONGITUD_ISBN = 10;
	static final int MINIMO_PAGINAS = 1;

	private String titulo; // tamaño mínimo 3 letras, máximo 150
	private long isbn; // número de longitud 10
	private int paginas; // mínimo 1
	private boolean formato;// true == digital false == papel

	public Revista() throws Exception {
		super();
		this.setTitulo("Revista sin nombre");
		this.setIsbn(1234567890);
		this.setPaginas(1);
		this.setFormato(true);
	}

	public Revista(String titulo, long isbn, int paginas, boolean formato) throws Exception {
		this();
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setPaginas(paginas);
		this.setFormato(formato);
	}

	public String getTitulo() {
		return titulo;
	}

	/**
	 * Comprueba que el título está entre los rangos MINIMO_TITULO y MAXIMO_TITULO.
	 * 
	 * @param titulo (String) - Parámetro recogido por teclado.
	 * @throws Exception
	 * @see MINIMO_TITULO
	 * @see MAXIMO_TITULO
	 */
	public void setTitulo(String titulo) throws Exception {
		if ((titulo != null) && (titulo.length() >= MINIMO_TITULO) && (titulo.length() <= MAXIMO_TITULO)) {
			this.titulo = titulo;
		} else {
			throw new Exception("El título debe tener entre " + MINIMO_TITULO + " y " + MAXIMO_TITULO + " caracteres.");
		}

	}

	public long getIsbn() {
		return isbn;
	}

	/**
	 * Comprueba que el ISBN sea de longitud LONGITUD_ISBN.
	 * 
	 * @param isbn (int) - Parámetro recibido por teclado
	 * @throws Exception
	 * @see LONGITUD_ISBN
	 */
	public void setIsbn(long isbn) throws Exception {
		if (Long.toString(isbn).length() != LONGITUD_ISBN) {
			throw new Exception("La longitud del ISBN debe ser de " + LONGITUD_ISBN + " dígitos.");
		} else {
			this.isbn = isbn;
		}

	}

	public int getPaginas() {
		return paginas;
	}

	/**
	 * Comprueba que la revista tenga al menos MINIMO_PAGINAS página.
	 * 
	 * @param paginas (int) - Parámetro recibidompor teclado.
	 * @throws Exception
	 * @see MINIMO_PAGINAS
	 */
	public void setPaginas(int paginas) throws Exception {
		if (paginas < MINIMO_PAGINAS) {
			throw new Exception("La longitud del número de páginas debe ser superior a " + MINIMO_PAGINAS + ".");
		} else {
			this.paginas = paginas;
		}

	}

	public boolean isFormato() {
		return formato;
	}

	/**
	 * 
	 * @param formato (boolean) - Parámetro recibido por teclado.
	 */
	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		String formatoTexto = "Digital";
		if (formato == true) {
			formatoTexto = "Físico";
		}
		return "** ISBN: " + isbn + " - " + titulo + ", " + paginas + " paginas. Formato " + formatoTexto;
	}

	@Override
	public int compareTo(Revista r) {
		return r.getPaginas() - this.getPaginas();
	}

}
