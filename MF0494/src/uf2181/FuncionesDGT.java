/**
 * 
 */
package uf2181;

/**
 * @author David
 *
 */
public class FuncionesDGT {

	/**
	 * Metodo que recibe un vector de enteros como parametro y calcula la media de sus datos.
	 * @param puntos int[] con las puntuaciones
	 * @return Devuelve la media.
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	/**
	 * Metodo que recibe una cadena y un boolean como parametros y calcula la taxima maxima permitida
	 * @param tipoConductor String, solo puede recibir dos valores "General" o "Novel"
	 * @param aire boolean que determina si los calculos se realizaran para aire = true o sangre = false
	 * @return devuelve la tasa maximaPermitida
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
