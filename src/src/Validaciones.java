package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {

	public static int pideEntero(int min, int max, String peticion) {
		int opcion;
		boolean primeraVuelta = true;
		
		do {
			if(!primeraVuelta)
				System.err.println("Por favor, introduzca un número entre " + min + " y " + max);
			opcion = pideEntero(peticion);
			primeraVuelta = false;
		}while(opcion < min || opcion > max);
		
		return opcion;
	}
	
	public static int pideEntero(String peticion) {
		Scanner in = new Scanner(System.in);
		int opcion = -1;
		boolean introduccionIncorrecta;
		
		introduccionIncorrecta = true;
		
		do {
			try {
				System.out.println(peticion);
				opcion = in.nextInt();
				introduccionIncorrecta = false;
			}catch(InputMismatchException e) {
				System.err.println("Por favor, introduzca un número entero");
				in.nextLine();
			}
		}while(introduccionIncorrecta);

		return opcion;
	}

	public static char pideCaracter(String mensaje) {
		String introduccion;
		Scanner in = new Scanner(System.in);
		boolean esPrimeraVuelta = true;
		
		do {
			if(!esPrimeraVuelta)
				System.err.println("Por favor, introduzca un solo carácter");
			System.out.println(mensaje);
			introduccion = in.nextLine();
			esPrimeraVuelta = false;
		} while(introduccion.length() != 1);
		
		return introduccion.charAt(0);
	}
	
	public static String pideStringMayusculas(int limiteCaracteres) {
		String string;
		Scanner in = new Scanner(System.in);
		do {
			string = in.nextLine();
			if(string.length() > limiteCaracteres)
				System.err.println("Por favor, introduzca menos de " + limiteCaracteres);
		}while(string.length() > limiteCaracteres);
		
		return string.toUpperCase();
	}
	
}
