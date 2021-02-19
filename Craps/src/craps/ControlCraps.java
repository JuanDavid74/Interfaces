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
 * Principal method where happen many things, is a method chord his name, Control.
 */
public class ControlCraps {

	/** The dado 2. 
	 *  Object of type dice
	 * */
	private Dado dado1, dado2;
	
	/** The estado,tiro, punto 
	 *  the status of the game, where is indicate if the user lose, win or continue. punto is equal the tiro, but this is remplazed
	 * */
	private int tiro, punto, estado;
	
	/** The lanzamiento.
	 *  boolen where is indicate if the user throw or not
	 *  */
	private boolean lanzamiento;
	
	/** The caras dados.
	 *  dices int array, is stock this points or result  
	 *  */
	private int[] carasDados; 
	
	/**
	 * Instantiates a new control craps.
	 * Public method, is a constructor, instantiates the objects, arrays, etc.
	 */
	public ControlCraps() {
		 dado1 = new Dado();
		 dado2 = new Dado();
		 lanzamiento = true;
		 carasDados = new int[2];
	}
	
	/**
	 * Calcular tiro.
	 * calculate de throw and save the information in the array
	 */
	public void calcularTiro() {
		carasDados[0] = dado1.getCaraVisible();
		carasDados[1] = dado2.getCaraVisible();
		tiro = carasDados[0]+carasDados[1];
	}

	/**
	 * Determinar juego.
	 * conditional where is analyzed the tiro, and lanzamiento.
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
			// if the user dont want continue, his result is analyzed and win or lose
			rondaPunto();
		}
	}
	
	/**
	 * Ronda punto.
	 * private method, determinated the resul of the user 
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
	 * if the user wants exit the game, the status will two
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true ;
	}

	/**
	 * Gets the tiro.
	 * sum the dices and his results
	 * @return the tiro
	 */
	public int getTiro() {
		return tiro;
	}

	/**
	 * Gets the punto.
	 * @return the punto
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado.
	 * Status of the game
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * Gets the caradado 1.
	 * in this position of the array, is visualized the result 
	 * @return the caradado 1
	 */
	public int getCaradado1(){
		return carasDados[0];
	}
	
	/**
	 * Gets the caradado 2.
	 *in this position of the array, is visualized the result 
	 * @return the caradado 2
	 */
	public int getCaradado2(){
		return carasDados[1];
	}
	
}
