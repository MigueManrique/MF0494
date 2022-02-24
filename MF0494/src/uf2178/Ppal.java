/**
 * 
 */
package uf2178;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Escribe aquí las sentencias del apartado 3
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime la tasa de alcolemia del conductor: ");
		float tasa = sc.nextFloat();
		Funciones.calculaSancion(tasa);
		
		int[] puntos = new int[6];
		int[] sanciones = new int[6];
		
		Funciones.pedir_vector(puntos);
		Funciones.pedir_vector(sanciones);
		
		Funciones.restaPuntos(puntos, sanciones);
		Funciones.mostrar_vector(puntos);
	}

}
