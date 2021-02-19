/*
 * Programacion Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps
 * February 19 / 2021
 */
package craps;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola.
 * Class VistaConsola
 */
public class VistaConsola {
	
	/** The control craps.
	 * Object of type ControlCraps
	 *  */
	private ControlCraps controlCraps;
	
	/** The pregunta.
	 * String pregunta is used for get the user's answer
	 *  */
	private String pregunta ;
	
	/** The entrada.
	 * Object of type Scanner used for read information
	 *  */
	private Scanner entrada ;
	
	/**
	 * Instantiates a new vista consola.
	 * this public method is the contructor, when someone start the game
	 */
	public VistaConsola() {
		
		controlCraps = new ControlCraps();
		entrada = new Scanner(System.in);
	}
	
	/**
	 * Play game.
	 * Function PlayGame where is realize many operations, like ask if the user wants play, gets a message in the cases. 
	 */
	public void playGame() {
		System.out.println("Do you want to roll the dices? write y/n ");
		pregunta = entrada.nextLine();

		if(pregunta.equalsIgnoreCase("y")) {
			 // start to play
			controlCraps.calcularTiro();
			System.out.printf("Dice 1 = %d Dice 2 = %d Threw = %d \n",controlCraps.getCaradado1(),
																	  controlCraps.getCaradado2(),
																	  controlCraps.getTiro());
			controlCraps.determinarJuego();

			// Caso switch where realize diferents things
			switch(controlCraps.getEstado()) {
				// Victory message 
				case 1: System.out.println(" !You win! ");
						break;
				// Loses message
				case 2: System.out.println("You lose");
						break;
				case 3: System.out.printf(" !You get points = %d , throw again !! \n", 
															controlCraps.getPunto());
						// while the user want continue playing, this control function is run.
						while(controlCraps.getEstado() == 3) {
							System.out.println("Do you want throw? write y/s");
							pregunta = entrada.nextLine();
							
							if(pregunta.equals("y")) {
								controlCraps.calcularTiro();
								System.out.printf("Dice 1 = %d Dice 2 = %d Threw = %d \n",
															controlCraps.getCaradado1(),
														    controlCraps.getCaradado2(),
														    controlCraps.getTiro());
								
								controlCraps.determinarJuego();
							}else {
								System.out.println("You lose for leave the game");
								controlCraps.setAbandono();
							}
						}
						
						if(controlCraps.getEstado() == 1){
							System.out.println(" !You win! ");
						}else {
							System.out.println("! You lose !");
						}
						break;
			}
			/*
			 * function seguirJuego is run
			 */
			seguirJuego();
		}else {
			System.out.println("Ok, good bye!" );
		}
	}
	
	/**
	 * Seguir juego.
	 * Function if the user want continue playing.
	 */
	private void seguirJuego() {
		System.out.println("Do you want to play another round? write y/n " );
		pregunta = entrada.nextLine();
		if(pregunta.equals("y")) {
			playGame();
		}else{
		System.out.println(" !Good bye! ");		
		
		}
	}
}









