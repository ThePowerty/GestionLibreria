package com.williams.GestionLibreria;

import java.util.Scanner;

import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;
import com.williams.GestionLibreria.services.LibreriaService;
import com.williams.GestionLibreria.services.LibroService;
import com.williams.GestionLibreria.services.impl.LibreriaServiceImpl;
import com.williams.GestionLibreria.services.impl.LibroServiceImpl;

public class CLI {

	/**
	 * INTERFAZ DE LINA DE COMANDO
	 * 
	 * Interfaz con un menu para seleccionar acciones para gestionar librerias
	 * 
	 */

	static Scanner sc = new Scanner(System.in);
	static int selector = -1;
	static LibroService libroService = new LibroServiceImpl();
	static LibreriaService libreriaService = new LibreriaServiceImpl();

	public static void main(String[] args) {

		while (selector != 0) {
			try {
				menu();
				System.out.print("\tOpcion: ");
				selector = Integer.parseInt(sc.nextLine());

				switch (selector) {
				case 1:
					crearLibro();
					break;
				case 2:
					asignarLibreria();
					break;
				case 3:
					listarLibros();
					break;
				case 4:
					buscarLibro();
					break;
				case 5:
					actualizarLibro();
					break;
				case 6:
					borrarLibro();
					break;
				case 0:
					System.out.println("\tAdios!");
					break;
				default:
					System.out.println("\tNumero no reconocido");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void menu() {
		System.out.println();
		System.out.println("\t************** M E N U ***************");
		System.out.println("\t*                                    *");
		System.out.println("\t* Seleccione una opcion:             *");
		System.out.println("\t*                                    *");
		System.out.println("\t*  1. Crear libro                    *");
		System.out.println("\t*  2. Asignar libreria               *");
		System.out.println("\t*  3. Listar libros                  *");
		System.out.println("\t*  4. Buscar libro                   *");
		System.out.println("\t*  5. Actualizar libro               *");
		System.out.println("\t*  6. Borrar libro                   *");
		System.out.println("\t*  0. Salir                          *");
		System.out.println("\t*                                    *");
		System.out.println("\t**************************************");
		System.out.println();
	}

	public static String crearLibro() {
		Libro libro = new Libro();
		String titulo = "";
		try {
			System.out.println("\tIntroduzca ISBN del libro: ");
			libro.setIsbn(sc.nextLine());
			do {
				System.out.println("\tIntroduzca el titulo del libro: ");
				titulo = sc.nextLine();
				if (titulo.length() > 30) {
					System.out.println("\tTitulo demasiado largo");
				}
			} while (titulo == "" && titulo.length() > 30);
			libro.setTitulo(titulo);
			libro.setGenero(selecGenero());
			return libroService.create(libro);
		} catch (Exception e) {
			e.printStackTrace();
			return ("\t..::ERROR, libro no creado::..");
		}
	}

	public static Genero selecGenero() {
		int opcion = -1;
		Genero genero = null;
		while (opcion != 0) {
			System.out.println();
			System.out.println("\tSeleccione una Genero:");
			System.out.println("\t  1. ACCION");
			System.out.println("\t  2. THRILLER");
			System.out.println("\t  3. ROMANCE");
			System.out.print("\tOpcion: ");
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				genero = Genero.ACCION;
				opcion = 0;
				break;
			case 2:
				genero = Genero.THRILLER;
				opcion = 0;
				break;
			case 3:
				genero = Genero.ROMANCE;
				opcion = 0;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
		return genero;
	}

	public static String asignarLibreria() {
		try {
			listarLibros();
			System.out.print("\tSeleccione el id del libro al que quiera asignar libreria: ");
			Long id_libro = Long.parseLong(sc.nextLine());
			System.out.println("\n" + libreriaService.findAll());
			System.out.print("\tSeleccione el id de la libreria: ");
			Long id_libreria = Long.parseLong(sc.nextLine());

			return libroService.addLibrary(id_libro, id_libreria);
		} catch (Exception e) {
			return "\t..::ERROR, libreria no asignada::..";
		}

	}

	public static String listarLibros() {
		return libroService.findAll();
	}

	public static String buscarLibro() {
		int opcion = -1;
		String libro = "";
		while (opcion != 0) {
			System.out.println();
			System.out.println("\tBuscar por: ");
			System.out.println("\t  1. id");
			System.out.println("\t  2. genero");
			System.out.print("\tOpcion: ");
			opcion = Integer.valueOf(sc.nextLine());
			switch (opcion) {
			case 1:
				System.out.println("Seleccione id: ");
				Long id = Long.parseLong(sc.nextLine());
				libro = (libroService.findById(id));
				opcion = 0;
				break;
			case 2:
				libro = (libroService.findByGenre(selecGenero()));
				opcion = 0;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}

		return libro;
	}

	public static String actualizarLibro() {
		listarLibros();
		System.out.print("\tSeleccione id del libro a actualizar: ");
		Long id = Long.parseLong(sc.nextLine());
		System.out.print("\tIntroduzca el nuevo isbn: ");
		String isbn = "";
		do {
			isbn = sc.nextLine();
			if (isbn == "") {
				System.out.println("\t Introduzca un isbn");
			}
		} while (isbn=="");
		return libroService.update(id, null);
	}

	public static String borrarLibro() {
		listarLibros();
		System.out.print("\tSeleccione id del libro a borrar: ");
		Long id = Long.parseLong(sc.nextLine());
		return libroService.delete(id);
	}

}
