/*
 * Programacion Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps
 * February 19 / 2021
 */
package craps;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps.
 */
public class ControlCraps {

	/** The dado 2. */
	private Dado dado1, dado2;
	
	/** The estado. */
	private int tiro, punto, estado;
	
	/** The lanzamiento. */
	private boolean lanzamiento;
	
	/** The caras dados. */
	private int[] carasDados; 
	
	/**
	 * Instantiates a new control craps.
	 */
	public ControlCraps() {
		 dado1 = new Dado();
		 dado2 = new Dado();
		 lanzamiento = true;
		 carasDados = new int[2];
	}
	
	/**
	 * Calcular tiro.
	 */
	public void calcularTiro() {
		carasDados[0] = dado1.getCaraVisible();
		carasDados[1] = dado2.getCaraVisible();
		tiro = carasDados[0]+carasDados[1];
	}

	/**
	 * Determinar juego.
	 */
	public void determinarJuego() {
		if(lanzamiento == true) {
			//round of throw
			if(tiro == 7 || tiro == 11) {
				estado = 1; // win
			}
			if(tiro == 2 || tiro == 2  || tiro == 12 ) {
				estado = 2; // lose
			} else {
				estado = 3; // game continue
				punto = tiro;
				lanzamiento = false;
			}
				
		} else {
			rondaPunto();
		}
	}
	
	/**
	 * Ronda punto.
	 */
	private void rondaPunto() {
		if(tiro == punto) {
			estado = 1; // win
			lanzamiento = true;
		}
		if(tiro == 7) {
			estado = 2; // lose
		}
	}
	
	/**
	 * Sets the abandono.
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true ;
	}

	/**
	 * Gets the tiro.
	 *
	 * @return the tiro
	 */
	public int getTiro() {
		return tiro;
	}

	/**
	 * Gets the punto.
	 *
	 * @return the punto
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Gets the caras dados.
	 *
	 * @return the caras dados
	 */
	public int[] getCarasDados() {
		return carasDados;
	}
	
	/**
	 * Gets the caradado 1.
	 *
	 * @return the caradado 1
	 */
	public int getCaradado1(){
		return carasDados[0];
	}
	
	/**
	 * Gets the caradado 2.
	 *
	 * @return the caradado 2
	 */
	public int getCaradado2(){
		return carasDados[1];
	}
	
}
