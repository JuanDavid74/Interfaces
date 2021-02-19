//
package craps;
//
import java.util.Random;
// TODO: Auto-generated Javadoc

/**
 * The Class Dado.
 */
//
public class Dado {

 /** The cara visible. */
 private int caraVisible;

 /**
  * Gets the cara visible.
  *
  * @return the cara visible
  */
 public int getCaraVisible() {
	 Random aleatorio = new Random();
	 caraVisible = aleatorio.nextInt(6 )+1;
	 return caraVisible;
 }

 
}
