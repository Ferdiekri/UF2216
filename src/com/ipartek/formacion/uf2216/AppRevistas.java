package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Examen de la unidad UF2216
 * @author Eder Ibáñez Rojo
 *
 */
public class AppRevistas {

	static final int OPCION_INSERTAR = 1;
	static final int OPCION_LISTAR = 2;
	static final int OPCION_GUARDAR = 3;
	static final int OPCION_SALIR = 4;
	static final int MINIMO_TITULO = 3;
	static final int MAXIMO_TITULO = 150;
	static final int LONGITUD_ISBN = 10;
	static final int MINIMO_PAGINAS = 1;
	static final String FORMATO_FISICO = "Físico";
	static final String FORMATO_DIGITAL = "Digital";

	public static ArrayList<Revista> revistas = new ArrayList<Revista>();
	public static Revista revistaActual;
	public static Scanner sc = new Scanner(System.in);
	public static int opcion = 0;
	public static String teclado = null;
	public static boolean correcto = false;

	static DAORevistaArrayList dao;

	public static void main(String[] args) throws Exception {

		dao = DAORevistaArrayList.getInstance();

		do {

			dibujarMenu();
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case OPCION_INSERTAR:
				insertarRevista();
				break;
			case OPCION_LISTAR:
				listarRevistas();
				break;
			case OPCION_GUARDAR:
				guardarRevistas();
				break;
			case OPCION_SALIR:
				System.out.println("Hasta la próxima.");
				break;
			default:
				System.out.println("Lo siento, pero esa opción no es válida. Vuelve a intentarlo.");
				break;
			}

		} while (opcion != OPCION_SALIR);

		sc.close();
	}

	/**
	 * Función que pinta el menú.
	 */
	private static void dibujarMenu() {
		System.out.println("\n\n ****************************");
		System.out.println("*****  MENÚ DE REVISTAS  *****");
		System.out.println(" ****************************");
		System.out.println("** 1. Insertar revista. ");
		System.out.println("** 2. Listar revistas guardadas.");
		System.out.println("** 3. Guardar revistas en fichero.");
		System.out.println("** 4. Salir.");
		System.out.println("*****************************");
		System.out.print("\nElige una opción: ");

	} // dibujarMenu

	/**
	 * Función que inserta una nueva revista cogiendo los paarametros por techado.
	 * 
	 * @throws Exception
	 */
	private static void insertarRevista() throws Exception {
		System.out.println("\n\n **************************");
		System.out.println("*****  NUEVA REVISTAS  *****");
		System.out.println(" **************************\n");

		revistaActual = new Revista();

		// Llamamos a las funciones de pedir los campos por teclado.
		pedirNombre();
		pedirIsbn();
		pedirPaginas();
		pedirFormato();

		System.out.println("\nHas creado la siguiente revista:");
		System.out.println(revistaActual.toString());

		do {
			correcto = false;
			System.out.print("\n¿Quieres guardarla? (S:Sí / N:No) ");
			teclado = sc.nextLine();
			if (teclado.toUpperCase().charAt(0) == 'S') {
				correcto = true;
				dao.nuevaRevista(revistaActual);
				System.out.println("Revista guardada correctamente.");
			} else if (teclado.toUpperCase().charAt(0) == 'N') {
				System.out.println("De acuerdo. No la guardamos.");
				correcto = true;
			} else {
				System.out.println("Lo siento, pero no has pulsado una opción válida. Vuelve a intentarlo.");
			}
		} while (!correcto);

	} // insertarRevista

	/**
	 * Función que pide el nombre de la revista y comprueba que su longitud sea la
	 * correcta.
	 * 
	 * @throws Exception
	 * 
	 * @see MINIMO_TITULO
	 */
	private static void pedirNombre() throws Exception {

		do {
			correcto = false;
			System.out.print("Dime el nombre de la revista: ");
			teclado = sc.nextLine();
			if ((teclado.length() >= MINIMO_TITULO) && (teclado.length() <= MAXIMO_TITULO)) {
				correcto = true;
			} else {
				System.out.println(
						"Formato incorrecto. El título debe tener entre 3 y 150 caracteres. Vuleve a intentarlo.");
				pedirNombre();
			}
		} while (!correcto);

		revistaActual.setTitulo(teclado);

	}

	/**
	 * Función que pide el ISBN de la revista y comprueba que su longitud sea
	 * exactamente 10
	 * 
	 * @throws Exception
	 * @throws NumberFormatException
	 * @see LONGITUD_ISBN
	 */
	private static void pedirIsbn() throws NumberFormatException, Exception {

		do {
			correcto = false;

			try {
				System.out.print("Dame el ISBN (10 dígitos): ");
				teclado = sc.nextLine();
				if (teclado.length() == LONGITUD_ISBN) {
					correcto = true;
				} else {
					System.out.println("Formato incorrecto. El ISBN dene tener 10 dígitos.");
				}
			} catch (Exception e) {
				System.out.println("Formato de ISBN incorrecto. Vuelva a intentarlo.");
				pedirIsbn();
			}
		} while (!correcto);

		revistaActual.setIsbn(Long.parseLong(teclado));

	}

	/**
	 * Función que pide el número de páginas de la revista y comprueba que su
	 * longitud sea mayor que 1
	 * 
	 * @throws Exception
	 * @throws NumberFormatException
	 * 
	 * @see MINIMO_PAGINAS
	 */
	private static void pedirPaginas() throws NumberFormatException, Exception {

		do {
			correcto = false;
			System.out.print("¿Cuántas páginas tiene? ");
			try {
				teclado = sc.nextLine();
				if (Integer.parseInt(teclado) < MINIMO_PAGINAS) {
					System.out.println("Lo siento, pero por lo menos debe tener 1 página.");
				} else {
					correcto = true;
				}
			} catch (Exception e) {
				System.out.println("Número de páginas incorrecto. Vuelva a intentarlo.");
				pedirPaginas();
			}
		} while (!correcto);

		revistaActual.setPaginas(Integer.parseInt(teclado));

	}

	/**
	 * Función que pide el número de páginas de la revista y comprueba que su
	 * longitud sea mayor que 1
	 * 
	 * @see MINIMO_PAGINAS
	 */
	private static void pedirFormato() {

		boolean formatoBoolean = false;

		do {
			correcto = false;
			System.out.print("¿En qué formato está? (F:Físico / D:Digital): ");
			teclado = sc.nextLine();
			if (teclado.toUpperCase().charAt(0) == 'F') {
				formatoBoolean = true;
				correcto = true;
			} else if (teclado.toUpperCase().charAt(0) == 'D') {
				formatoBoolean = false;
				correcto = true;
			} else {
				System.out.println("Formato incorrecto. Por favor, vuelva a intentarlo.");
			}
		} while (!correcto);

		revistaActual.setFormato(formatoBoolean);

	}

	/**
	 * Función que lista todas las revistas guardadas y las muestra ordenadas por
	 * número de páginas.
	 */
	private static void listarRevistas() {
		System.out.println("\n\n ***************************");
		System.out.println("*****  LISTAR REVISTAS  *****");
		System.out.println(" ***************************\n");

		revistas = (ArrayList<Revista>) dao.getTodasRevistas();
		Collections.sort(dao.getTodasRevistas());

		System.out.println("ISBN \t\t  NOMBRE  \tPÁGINAS\tFORMATO");
		System.out.println("----------\t----------\t-------\t-------");

		for (Revista revista : dao.getTodasRevistas()) {
			System.out.print(revista.getIsbn() + "\t" + revista.getTitulo() + "\t" + revista.getPaginas() + "\t");
			if (revista.isFormato() == true) {
				System.out.println(FORMATO_FISICO);
			} else {
				System.out.println(FORMATO_DIGITAL);
			}
		}

	} // listarRevistas

	/**
	 * Función que vuelca todas las revistas a un fichero de texto.
	 * 
	 * @throws IOException
	 */
	private static void guardarRevistas() throws IOException {
		System.out.println("\n\n ***************************************");
		System.out.println("*****  GUARDAR REVISTAS EN FICHERO  *****");
		System.out.println(" ***************************************\n");

		String nombreFichero = "C:\\1713\\eclipse-workspace\\EderIbanezRojo\\RegistroRevistas.txt";

		System.out.println("Se va a guardar un fichero en la siguiente ruta:");
		System.out.println("**** EderIbanezRojo\\RegistroRevistas.txt ****");

		try (FileWriter fw = new FileWriter(nombreFichero);
				BufferedWriter bf = new BufferedWriter(fw);
				BufferedReader br = new BufferedReader(new FileReader(nombreFichero));) {

			bf.write("(ISBN ---- NOMBRE ---- PÁGINAS ---- FORMATO");
			bf.newLine();
			for (Revista revista : revistas) {
				bf.write(revista.toString());
				bf.newLine();
			}

			bf.close();

			System.out.println(".\n.\n.\nFichero guardado correctamente.");
		}

	} // guardarRevistas

}