import java.util.Calendar;

public class TipoPalabra {
/**
 * Metodo que comprueba desde el inicio hasta el final que los caracteres son iguales, en caso contrario devuelve false
 * @param cad String cadena a comparar
 * @return boolean 
 */
	private static boolean comprobarsSiPalindroma(String cad) {

		boolean bd = true;

		int i = 0;
		int j = cad.length() - 1;

		while ((i <= j) && (bd)) {
			bd = cad.charAt(i) == cad.charAt(j);
			i++;
			j--;
		}

		return bd;
	}
	/**
	 * Metodo que da la vuelta a la cadena y compara si es igual. 
	 * @param cad a String comparar
	 * @return boolean
	 */

	private static boolean comprobarsSiPalindroma2(String cad) {

		boolean palindromo = false;
		String cadReverse = "";
		int longitud = cad.length() - 1;
		for (int i = longitud; i >= 0; i--) {
			cadReverse += cad.charAt(i);
		}
		if (cadReverse.equals(cad)) {
			palindromo = true;
		}
		return palindromo;
	}
	
/**
 * Caso base y caso recursivo
 */
	/**
	 * Método que comprueba si una palabra es palindroma
	 * Comprueba si el primer caracter es igual o no,
	 * si es igual vuelve a llamar al metodo restando el primer y el ultimo caracter acotando por los lados 
	 * y devolviendo el resultado;
	 * En caso de que encuentre uno diferente no entra en el if y devuelve false
	 * @param cad
	 * @return
	 */
	private static boolean comprobarsSiPalindromaRecursive(String cad) {
	
	if((cad.length()==0) || (cad.length()==1)) return true;
		if (cad.charAt(0)==cad.charAt(cad.length()-1)){
			return comprobarsSiPalindromaRecursive(cad.substring(1, cad.length()-1));
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(comprobarsSiPalindromaRecursive("poop"));
//		if (comprobarsSiPalindroma2("poop")) {
//			System.out.println("VERDADERO");
//		}
//		else {
//			System.out.println("FALSO");
//		}
	}
}
