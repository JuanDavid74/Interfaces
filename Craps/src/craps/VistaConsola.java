package craps;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola.
 */
public class VistaConsola {
	
	/** The control craps. */
	private ControlCraps controlCraps;
	
	/** The pregunta. */
	private String pregunta ;
	
	/** The entrada. */
	private Scanner entrada ;
	
	/** The entra. */
	private Scanner entra ;
	
	/**
	 * Instantiates a new vista consola.
	 */
	public VistaConsola() {
		
		controlCraps = new ControlCraps();
		entrada = new Scanner(System.in);
		entra = new Scanner(System.in);
	}
	
	/**
	 * Play game.
	 */
	public void playGame() {
		System.out.println("Do you want to roll the dices? write y/n ");
		pregunta = entra.nextLine();

		if(pregunta.equalsIgnoreCase("y")) {
			 // start to play
			controlCraps.calcularTiro();
			System.out.printf("Dice 1 = %d Dice 2 = %d Threw = %d \n",controlCraps.getCaradado1(),
																	  controlCraps.getCaradado2(),
																	  controlCraps.getTiro());
			controlCraps.determinarJuego();

			switch(controlCraps.getEstado()) {
				case 1: System.out.println(" !You win! ");
						break;
				case 2: System.out.println("You lose");
						break;
				case 3: System.out.printf(" !You get points = %d , throw again !! \n", 
															controlCraps.getPunto());
						while(controlCraps.getEstado() == 3) {
							System.out.println("Do you want throw? write y/s");
							pregunta = entrada.nextLine();
							
							if(pregunta.equals("y")) {
								controlCraps.calcularTiro();
								System.out.printf("Dice 1 = %d Dice 2 = %d Threw = %d \n",
															controlCraps.getCarasDados()[0],
														    controlCraps.getCarasDados()[0],
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
			
			seguirJuego();
		}else {
			System.out.println("Ok, good bye!" );
		}
	}
	
	/**
	 * Seguir juego.
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









