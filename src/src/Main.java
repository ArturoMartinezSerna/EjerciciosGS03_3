package src;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = Validaciones.pideEntero(0, 8, "Por favor, introduzca opción");
			ejecutaOpcion(opcion);
		} while(opcion != 0);
		
		
	}

	private static void ejecutaOpcion(int opcion) {
		switch(opcion) {
		case 1: ejercicio1();
		break;
		case 2: ejercicio2();
		break;
		case 3: ejercicio3();
		break;
		case 4: ejercicio4();
		break;
		case 5: ejercicio5();
		break;
		case 6: ejercicio6();
		break;
		case 7: ejercicio7();
		break;
		case 8: ejercicio8();
		}
	}
	
	private static void mostrarMenu() {
		System.out.println("1: Comprobar si un número es Positivo, Negativo o Cero");
		System.out.println("2: Comprobar si un número es múltiplo de otro");
		System.out.println("3: Determinar si un carácter es una vocal");
		System.out.println("4: Determinar si un carácter es una letra minúscula");
		System.out.println("5: Sumar progresión geométrica x⁰ + x¹ + ... + x^n");
		System.out.println("6: Cambiar un número de base");
		System.out.println("7: Calcular el valor del día de la semana según la letra inicial, y determina el número de días de un mes");
		System.out.println("8: Traductor números romanos - números arábigos (Máximo 10 números romanos)");
		System.out.println("0: Salir\n");
	}
	
	
	private static void ejercicio1() {
		Scanner in = new Scanner(System.in);
		int num;
		char signo;
		
		num = Validaciones.pideEntero("Por favor, introduzca un número entero:");
		signo = calculaSigno(num);
		if(signo == 'C')
			System.out.println("El número es igual a cero.");
		else if(signo == 'P')
			System.out.println("El número es positivo.");
		else
			System.out.println("El número es negativo.");
	}
		/*
		 *  1. Escribir un método que tenga un parámetro de tipo entero y que devuelva la letra P si el
		 *	   número es positivo, la letra N si es negativo y la letra C si es cero.
		 */
		private static char calculaSigno(int numero) {
			if(numero > 0)
				return 'P';
			else if(numero == 0)
				return 'C';
			else
				return 'N';
		}
	
	private static void ejercicio2() {
		int numero = Validaciones.pideEntero("Por favor, introduzca un número");
		int multiplo = Validaciones.pideEntero("Por favor, introduzca un número del que saber si es múltiplo del número anterior");
		
		if(esMultiplo(numero, multiplo))
			System.out.println("El número " + multiplo + " es múltiplo de " + numero);
		else
			System.out.println("El número " + multiplo + " no es múltiplo de " + numero);
	}
		/*	
		 * 2. Escribir un método que reciba dos parámetros enteros, devolverá true si el segundo es
		 *	  múltiplo del primer parámetro y false en caso contrario.
		 */
		private static boolean esMultiplo(int numero, int multiplo) {
			
			return multiplo % numero == 0;
		}
	
	private static void ejercicio3() {
		char caracter = Validaciones.pideCaracter("Por favor, introduzca un carácter para saber si es una vocal:");
		if(vocal(caracter))
			System.out.println("El carácter introducido fue una vocal.");
		else
			System.out.println("El carácter introducido no fue una vocal.");
	}
		/*
		 * 3. Escribir un método lógico llamado vocal que determine si un carácter es una vocal.
		 */
		private static boolean vocal(char caracter) {
			if( caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' || 
				caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U')
				return true;
			else
				return false;
		}
		
	private static void ejercicio4() {
		char caracter = Validaciones.pideCaracter("Por favor, introduzca un carácter para averiguar si es una letra minúscula");
		if(esMinuscula(caracter))
			System.out.println("El carácter es una letra minúscula");
		else
			System.out.println("El carácter no es una letra minúscula");
	}
			/*
			 * 4. Escribir un método lógico que determine si un carácter es una letra minúscula.
			 */
			private static boolean esMinuscula(char caracter) {
				return(caracter >= 'a' && caracter <= 'z');
			}
	
	private static void ejercicio5() {
		int base = Validaciones.pideEntero("Introduzca la base \"x\" de la progresión:");
		int exponente = Validaciones.pideEntero("Introduzca el exponente \"n\" de la progresión:");
		int resultado = sumaProgresion(base, exponente);
		
		System.out.println("El resultado de la progresión geométrica de base " + base + " y exponente " + exponente + " es: " + resultado);
		
	}
		/*
		 * 5. Escribir un programa que lea dos números x y n. Y un método que calcule la suma de la
		 *	  progresión geométrica:
		 *	      1 + x + x^2 + x^3 + ... + x^n
		 */
		private static int sumaProgresion(int base, int exponente) {
			int resultado = 0;
			for(int i = 0; i <= exponente; i++) {
				resultado += eleva(base, i);
			}
			return resultado;
		}
		
			private static int eleva(int base, int exponente) {
				int resultado = 1;
				
				for(int i = 0; i < exponente; i++)
					resultado *= base;
				return resultado;
			}
	
	/*
	 * 6. Escribir un programa que lea dos enteros positivos n y b, y llame al método cambiar_base
	 *	  para calcular y visualizar la representación del número n en la base b. (NOTA: el número n
	 * 	  dado por el usuario siempre está en base decimal. La base puede ser cualquiera entre 2 y 9, y la
	 *	  base hexadecimal, 16.)
	 */
	private static void ejercicio6() {
		int numero = Validaciones.pideEntero(1, 16, "Introduzca el número en base 10:");
		int base = Validaciones.pideEntero("Introduzca la nueva base del número:");
		
		String numeroNuevaBase = cambiaBase(numero, base);
		
		System.out.println("El número " + numero + " en base " + base + " es: " + cambiaBase(numero, base));
	}
	
		private static String cambiaBase(int numero, int base) {
			String numeroNuevaBase = "";
			int restoDivision;
			
			while(numero > 0) {
				restoDivision = numero % base;
				numeroNuevaBase = transformaRestoBase(restoDivision) + numeroNuevaBase;
				numero /= base;
			}
			return numeroNuevaBase;
		}
		
			private static char transformaRestoBase(int resto) {
				switch(resto) {
				case 0: return '0';
				case 1: return '1';
				case 2: return '2';
				case 3: return '3';
				case 4: return '4';
				case 5: return '5';
				case 6: return '6';
				case 7: return '7';
				case 8: return '8';
				case 9: return '9';
				case 10: return 'A';
				case 11: return 'B';
				case 12: return 'C';
				case 13: return 'D';
				case 14: return 'E';
				case 15: return 'F';
				}
				return (char)(-1);
			}
	
	/*
	 * 7. Escribir un programa que tenga dos métodos que realicen las siguientes tareas:
	 *	  a) Devolver el valor del día de la semana en respuesta a la entrada de la letra inicial
	 *		 (mayúscula o minúscula) de dicho día.
	 *	  b) Determinar el número de días de un mes.
	 */
	private static void ejercicio7() {
		char inicialDia = Validaciones.pideCaracter("Por favor, introduzca la letra inicial del día de la semana:");
		int mes;
		
		System.out.println("El día correspondiente a " + inicialDia + " es: " + diaSemana(inicialDia));
		
		mes = Validaciones.pideEntero(1, 12, "Introduzca el mes del año del que calcular su número de días:");
		System.out.println("El número de días del mes " + mes + " es: " + getDiasMes(mes));
		
	}
	
		/**
		 * Calcula un String del día de la semana a partir de su inicial
		 * @param inicial la inicial del día de la semana
		 * @return un String con el día de la semana
		 */
		private static String diaSemana(char inicial) {
			
			if(inicial >= 'A' && inicial <= 'Z')
				inicial -= ('A' - 'a');
			
			switch(inicial) {
			case 'l': return "Lunes";
			case 'm': return "Martes";
			case 'x': return "Miércoles";
			case 'j': return "Jueves";
			case 'v': return "Viernes";
			case 's': return "Sábado";
			case 'd': return "Domingo";
			}
			return null;
		}
		
		/**
		 * Devuelve el número de días que tiene un mes
		 * @param mes de 1 a 12, el número de mes
		 * @return el número de días del mes
		 */
		private static int getDiasMes(int mes) {
			final boolean ES_FEBRERO = (mes == 2);
			final boolean ES_MES31 = (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
					 || mes == 10 || mes == 12);
			if(ES_FEBRERO)
				return 28;
			else if(ES_MES31)
				return 31;
			else
				return 30;
		}
	
	/*
	 *	8. Escribir un programa que lea una cadena de hasta diez caracteres que representa a un número
	 *	en numeración romana e imprima su equivalente en numeración arábiga. Los caracteres
	 *	romanos y sus equivalentes son:
	 *	M	1000	L	50
	 *	D	500		X	10
	 *	C	100		V	5
	 *		  I	  1
	 *	Comprueba tu programa para los siguientes datos:
	 *	LXXXVI (86), CCCXIX (319), MCCLIV (1254).
	 *
	 * TODO:Por desgracia, no funciona para MCMCCC, pero aún así está bastante bien
	 */
	public static void ejercicio8() {
		String numeroRomano;
		boolean numeroInvalido;
		int[] valoresLetras;
		int total;
		int caracterActual;
		
		do {
			total = 0;
			caracterActual = 0;
			numeroInvalido = false;
			System.out.println("Por favor, introduzca un número romano:");
			numeroRomano = Validaciones.pideStringMayusculas(10);

			try {
				Utilidad.tieneSumasIncorrectas(numeroRomano);
				valoresLetras = Utilidad.transformaNumeroRomanoInt(numeroRomano);
				
				if(valoresLetras.length > 1) {
					total += valoresLetras[valoresLetras.length - 1];
					caracterActual = valoresLetras[valoresLetras.length - 1];
					for(int i = valoresLetras.length - 2; i >= 0; i--) {
						if(caracterActual > valoresLetras[i]) {
							caracterActual = Utilidad.calculaRestaRomana(caracterActual, valoresLetras[i]);
							total -= valoresLetras[i];
						}
						else {
							caracterActual = valoresLetras[i];
							total += valoresLetras[i];
						}
					}
				}
				else if(valoresLetras.length == 1)
					total += valoresLetras[0];
			}catch(Exception e) {
				System.err.println(e.getMessage());
				numeroInvalido = true;
			}
		} while(numeroInvalido);
		
		System.out.println("El número romano " + numeroRomano + " tiene como valor: " + total);
	}
	
}
