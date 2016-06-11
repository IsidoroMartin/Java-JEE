package view;

import helper.FicherosHelper;

import java.io.File;


public class Main {
	public static void main(String[] args) {
		File f = new File("src/files/imagen.png");
		File f2 = new File("src/files/imagen2.png");
//		FicherosHelper.escribirFichero(new String[] {"Pepe","Juan","Carlos"}, f);
		System.out.println(FicherosHelper.copiarFichBytes(f,f2));
		
	}
}

// File f = new File("src/files/fich");
// File f2 = new File("src/files/fich1");
// FicherosHelper wrapper = new FicherosHelper(f);
// // wrapper.ls();
// FicherosHelper fh = new FicherosHelper(f);
// FicherosHelper fh2 = new FicherosHelper(f2);
// // fh.leerFichero();
// // fh.leerFichero2();
// // wrapper.ls();
// System.out.println(fh2.escribirFichero(new String[] { "Pepe", "Juan",
// "Carlos" }));