/*
 * Programacion Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps
 * February 19 / 2021
 */
// Field Craps 
package craps;

import java.util.Random;
// TODO: Auto-generated Javadoc

/**
 * The Class Dado.
 * this object is the dice, have one method 
 */
//
public class Dado {

 /** The cara visible. */
 private int caraVisible;

 /**
  * Gets the cara visible.
  * generate a random number int between 1 and 6  
  * @return the cara visible
  */
 public int getCaraVisible() {
	 Random aleatorio = new Random();
	 caraVisible = aleatorio.nextInt(6 )+1;
	 return caraVisible;
 }

 
}
