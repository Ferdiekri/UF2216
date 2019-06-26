package com.ipartek.formacion.uf2216;

public class Revista implements Comparable<Revista> {

	static final int MINIMO_TITULO = 3;
	static final int MAXIMO_TITULO = 150;
	static final int LONGITUD_ISBN = 10;
	static final int MINIMO_PAGINAS = 1;

	private String titulo; // tama�o m�nimo 3 letras, m�ximo 150
	private long isbn; // n�mero de longitud 10
	private int paginas; // m�nimo 1
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
	 * Comprueba que el t�tulo est� entre los rangos MINIMO_TITULO y MAXIMO_TITULO.
	 * 
	 * @param titulo (String) - Par�metro recogido por teclado.
	 * @throws Exception
	 * @see MINIMO_TITULO
	 * @see MAXIMO_TITULO
	 */
	public void setTitulo(String titulo) throws Exception {
		if ((titulo != null) && (titulo.length() >= MINIMO_TITULO) && (titulo.length() <= MAXIMO_TITULO)) {
			this.titulo = titulo;
		} else {
			throw new Exception("El t�tulo debe tener entre " + MINIMO_TITULO + " y " + MAXIMO_TITULO + " caracteres.");
		}

	}

	public long getIsbn() {
		return isbn;
	}

	/**
	 * Comprueba que el ISBN sea de longitud LONGITUD_ISBN.
	 * 
	 * @param isbn (int) - Par�metro recibido por teclado
	 * @throws Exception
	 * @see LONGITUD_ISBN
	 */
	public void setIsbn(long isbn) throws Exception {
		if (Long.toString(isbn).length() != LONGITUD_ISBN) {
			throw new Exception("La longitud del ISBN debe ser de " + LONGITUD_ISBN + " d�gitos.");
		} else {
			this.isbn = isbn;
		}

	}

	public int getPaginas() {
		return paginas;
	}

	/**
	 * Comprueba que la revista tenga al menos MINIMO_PAGINAS p�gina.
	 * 
	 * @param paginas (int) - Par�metro recibidompor teclado.
	 * @throws Exception
	 * @see MINIMO_PAGINAS
	 */
	public void setPaginas(int paginas) throws Exception {
		if (paginas < MINIMO_PAGINAS) {
			throw new Exception("La longitud del n�mero de p�ginas debe ser superior a " + MINIMO_PAGINAS + ".");
		} else {
			this.paginas = paginas;
		}

	}

	public boolean isFormato() {
		return formato;
	}

	/**
	 * 
	 * @param formato (boolean) - Par�metro recibido por teclado.
	 */
	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		String formatoTexto = "Digital";
		if (formato == true) {
			formatoTexto = "F�sico";
		}
		return "** ISBN: " + isbn + " - " + titulo + ", " + paginas + " paginas. Formato " + formatoTexto;
	}

	@Override
	public int compareTo(Revista r) {
		return r.getPaginas() - this.getPaginas();
	}

}
