package src;

public class Utilidad {
	
	
	public static boolean tieneSumasIncorrectas(String numeroRomano) throws Exception{
		int contadorLetraActual = 0;
		char letraActual;
		
		letraActual = numeroRomano.charAt(0);
		contadorLetraActual++;
		for(int i = 1; i < numeroRomano.length(); i++) {
			if(letraActual == numeroRomano.charAt(i)) {
				if(letraActual == 'V' || letraActual == 'L' || letraActual == 'D')
					throw new Exception("Un número romano no puede sumar dos Vs, Ls o Ds seguidas");
				contadorLetraActual++;
				if(contadorLetraActual >= 4)
					throw new Exception("Un número romano no puede sumar más de 3 números iguales");
			}
			else {
				letraActual = numeroRomano.charAt(i);
				contadorLetraActual = 1;
			}
		}
		return false;
	}
	
	public static int[] transformaNumeroRomanoInt(String numeroRomano) throws Exception{
		
		int[] numeros = new int[numeroRomano.length()];
		
		for(int i = 0; i < numeroRomano.length(); i++) {
			numeros[i] = transformaRomana(numeroRomano.charAt(i));
		}
		return numeros;
	}
	
	public static int transformaRomana(char numeroRomano) throws Exception{
		switch(numeroRomano) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: throw new Exception("El número introducido contiene caracteres no romanos");
		}
	}
	
	public static int calculaRestaRomana(int caracterActual, int caracterResta) throws Exception{
		final String MENSAJE_ERROR = "Al carácter " + caracterActual + " no se le puede restar " + caracterResta;
		int caracterEsperado;
		
		caracterEsperado = calculaCaracterResta(caracterActual);
		
		if(caracterEsperado != caracterResta)
			throw new Exception(MENSAJE_ERROR);
		
		return caracterActual - caracterResta;
	}
	
	private static int calculaCaracterResta(int caracterActual) throws Exception{
		switch(caracterActual) {
		case 5: return 1;
		case 10: return 1;
		case 50: return 10;
		case 100: return 10;
		case 500: return 100;
		case 1000: return 100;
		default: throw new Exception("No se pueden restar dos números en números romanos");
		}
	}
}
