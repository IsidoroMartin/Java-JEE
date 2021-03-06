import helper.FicherosHelper;


/**
 * 
 * 
 * @author Vale
 * 
 * 
 * La siguiente clase contiene un peque�o ejemplo del empleo de Expresiones regulares en Java
 * La expresiones regulares son un mecanismo potente que nos permite prototipar palabras, de forma abreviada.
 * Descrita una expresi�n regular, la clase String, provee de m�todos que ayuda a operar f�cilmente con las cadenas
 * que coinciden con la expresi�n regular.
 * 
 * Siendo cadena un String, puedo aplicar:
 * 
 *cadena.matches("regex")	Devuelve TRUE si cadena, es descrita totalmente por la expresi�n regular pasada
 *cadena.split("regex")	Me devuelve un array de subcadenas de cadena, usando la expresi�n regular como separador. "regex" no est� inclu�da en el resultado
 *cadena.replaceFirst("regex"), "replacement") Sustituye la primera aparici�n de la expresi�n regular en cadena, con el replacement dado
 *cadena.replaceAll("regex"), "replacement") Sustituye todas las apariciones de la expresi�n regular, con el replacement dado
 */
public class ExpRegs {
	public static void main(String[] args) {
		String linea = "asfadfbjp349iu'***hola@madrid.org///0sdg99sdg";
		String expQuitarContenidoAsteriscos = ".+[\\*]{3}";
		String expQuitarContenidoBarras= "[/]{3}.+";
		String[] ficheroSinAsteriscosArray  = linea.split(expQuitarContenidoAsteriscos);
		linea = ficheroSinAsteriscosArray[1];
		String[] a = linea.split(expQuitarContenidoBarras);
		System.out.println(a[0]);	
	}

}