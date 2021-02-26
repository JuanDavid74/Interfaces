/*
 * Programacion Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps
 * February 19 / 2021
 */
package craps;

import java.awt.EventQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalCraps.
 */
public class PrincipalCraps {

	/**
	 * The main method.
	 * Principal function where the game can be started.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// new object for start the game
		/*
		 * VistaConsola consola = new VistaConsola(); consola.playGame();
		 */
		EventQueue.invokeLater(new Runnable() {
			@Override
			
			public void run() {
				// All generate ...
				//VistaGUICraps myWindow = new VistaGUICraps();
				VistaGUIGridBagLayout myVista = new VistaGUIGridBagLayout();
			}
		});
	}
	
}
