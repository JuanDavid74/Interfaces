
/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps VistaGUI
 */

package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class VistaGUICraps extends JFrame {

	//attributes
	
	private JLabel dado1, dado2;
	private JButton lanzar, exit;
	private ImageIcon imagen;  // allow uploading images
	private Escucha escucha;
	private ControlCraps controlCraps;
	
	//methods
	public VistaGUICraps() {
		
		// window container and layout
		Container contenedor =  this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		// creat listener object
		escucha = new Escucha();
		controlCraps = new ControlCraps();
		
		// add the grafics components
		imagen = new ImageIcon("src/Images/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);
		
		lanzar = new JButton("Throw");
		lanzar.addActionListener(escucha);
		exit = new JButton(" Exit ");
		exit.addActionListener(escucha);
		
		contenedor.add(dado1);
		contenedor.add(dado2);
		contenedor.add(lanzar);
		contenedor.add(exit);
		 
		this.setTitle("Juego Craps"); // define the title
		this.setSize(350,220); // window size
		this.setLocationRelativeTo(null); //the interface be displayed in the middle of the screen 
		this.setResizable(false); //the user can't modify window size 
		 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // make visible the window(true)
		
	}

	// inner class
	// implements the actions, images, and window, this class is dependet of lanzar
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Esbozo de método generado automáticamente
			if(event.getSource() == lanzar){
		        //System.exit(0);
				visualizarCaras();
				controlCraps.determinarJuego();
				String tiro = "The throw was: "+controlCraps.getTiro()+"\n";
		        Icon icon; 
				
				switch(controlCraps.getEstado()) {
				case 1: 
					icon = new ImageIcon("src/Images/ganaste.png");
					JOptionPane.showMessageDialog(lanzar, tiro + " You win! ","Result",
												  JOptionPane.DEFAULT_OPTION , icon);
					break;	//button	// mesagge // tittle result	 // default icon  // image 
				case 2: 
					icon = new ImageIcon("src/Images/perdiste.png");
					JOptionPane.showMessageDialog(lanzar, tiro + " You lose! ","Result",
												  JOptionPane.DEFAULT_OPTION , icon);
					 
					break;
				case 3: String punto = "You set point : "+controlCraps.getPunto()+
						" You must get the point value to win"+ "\n" +
						" if you get 7 you lose";   
						icon = new ImageIcon("src/Images/punto.png");
						JOptionPane.showMessageDialog(lanzar, tiro + punto ,"Result",
											  JOptionPane.DEFAULT_OPTION , icon);
					
					break;
				}
			} else {
				System.exit(0);
			}
		
		}
			
	}
	
	private void visualizarCaras() {
		controlCraps.calcularTiro();
		imagen = new ImageIcon("src/Images/"+controlCraps.getCaradado1()+".png");
		dado1.setIcon(imagen);
		imagen = new ImageIcon("src/Images/"+controlCraps.getCaradado2()+".png");
		dado2.setIcon(imagen);
	}
}
