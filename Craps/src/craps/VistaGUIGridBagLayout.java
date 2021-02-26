/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Craps VistaGUI
 */

package craps;

// all the importations that we need
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

// importation of the class "Titulos" for create defaults titles
import mycomponents.Titulos;


public class VistaGUIGridBagLayout extends JFrame {

	//atributes
	
	private JPanel zonaJuego, zonaResultados; 
	private JLabel dado1, dado2, tiro, punto;
	private JTextField valorTiro, valorPunto;
	private JButton salir,lanzar ;
	private ImageIcon imagen;
	private JTextArea mensajes;
	private Titulos titulo, resultados;
	private ControlCraps controlCraps;
	private Escucha escucha;
	private JFrame vistaGridBagLayout;
	
	
	//methods
	public VistaGUIGridBagLayout(){
		initGUI();
		
		this.setUndecorated(true);
		this.setBackground(new Color(127,255,212,100));
		// set default window configuration
		//this.setTitle("Game Craps"); // tittle of the window
		this.pack(); // define the  default size 
		//this.setSize(390,280); // size of the window
		this.setLocationRelativeTo(null); // location of the window (center)
		this.setVisible(true); // visible window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window if the 		user exit 
		this.setResizable(false);
		
	}
	
	/*
	 * include all graphics and his desing
	 * this function doesn return anything
	 * */ 
	private void initGUI() {
		
		// set up container - layout
		// container and his layout
		this.getContentPane().setLayout(new GridBagLayout());
		// for every graphic component that is added  
		GridBagConstraints contraints = new GridBagConstraints();
		
		//create listener objects, control and others
		
		escucha = new Escucha(); // object escucha for the actions
		controlCraps = new ControlCraps(); //actions for the dudes
		vistaGridBagLayout = this;
		
		//set up GUIcomponents 
		
		
		titulo = new Titulos("Game Craps",30, new Color(127,255,212));
		titulo.addMouseListener(escucha); // in indicated the object where we can move
		titulo.addMouseMotionListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR)); // cursor type 
		// It is used to modify the characteristics where the "titulo" appears
		contraints.gridx=0; // busy column
		contraints.gridy=0; // busy row
		contraints.gridwidth = 2; // width 
		contraints.fill = GridBagConstraints.HORIZONTAL; // orientation
		add(titulo,contraints); // titulo is added into container with the contrains characteristics
	
		//game zone
		zonaJuego = new JPanel();
		imagen = new ImageIcon("src/Images/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);
		lanzar = new JButton("throw");
		lanzar.addActionListener(escucha);
		zonaJuego.add(dado1);
		zonaJuego.add(dado2);
		zonaJuego.add(lanzar);
		zonaJuego.setPreferredSize(new Dimension(310,180));
		zonaJuego.setBorder(new TitledBorder(" Game zone "));
		Border border = BorderFactory.createLineBorder(new Color(255,127,170), 5);
		
		zonaJuego.setBorder(border);
		contraints.gridx=0; // busy column
		contraints.gridy=1; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 3; // height 
		contraints.fill = GridBagConstraints.NONE; // orientation
		
		add(zonaJuego,contraints);
		
		//exit
		salir = new JButton("Exit");
		salir.addActionListener(escucha);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // add a image in the cursor
		contraints.gridx= 0; // busy column
		contraints.gridy= 4; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height 
		contraints.fill = GridBagConstraints.NONE; // orientation
		contraints.anchor = GridBagConstraints.LAST_LINE_END; // position in this coords
		
		add(salir,contraints);
		
		//results title 
		resultados = new Titulos(" Results ",24,new Color(255,127,170));
		contraints.gridx= 1; // busy column
		contraints.gridy= 1; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height 
		contraints.fill = GridBagConstraints.HORIZONTAL; // orientation
		contraints.anchor = GridBagConstraints.CENTER; // position in this coords
		
		add(resultados,contraints);
		
		//resultszone
		zonaResultados = new JPanel();
		zonaResultados.setLayout(new GridLayout(2,2));
		tiro = new JLabel("Throw");
		punto = new JLabel("Point");
		valorTiro = new JTextField();
		valorTiro.setEditable(false);
		valorPunto = new JTextField();
		valorPunto.setEditable(false);
		zonaResultados.add(tiro);
		zonaResultados.add(valorTiro);
		zonaResultados.add(punto);
		zonaResultados.add(valorPunto);
		zonaResultados.setBackground(new Color(127,255,212));	
		
		contraints.gridx= 1; // busy column
		contraints.gridy= 2; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height 
		contraints.fill = GridBagConstraints.NONE; // orientation
		contraints.anchor = GridBagConstraints.CENTER; // position in this coords
		add(zonaResultados,contraints);
		
		mensajes = new JTextArea(10,20);
		mensajes.setText("Throw the dices fot start the game \n");
		mensajes.setEditable(false);
		// scrollpane in Text area "mensajes"
		JScrollPane scroll = new JScrollPane(mensajes);
		contraints.gridx= 1; // busy column
		contraints.gridy= 3; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 2; // height 
		contraints.fill = GridBagConstraints.VERTICAL; // orientation
		contraints.anchor = GridBagConstraints.CENTER; // position in this coords
		add(scroll,contraints);
	}
	
	/*
	 * this method implements all the actions, and characteristics that make the objects like labels, buttons, titles, textarea, textfield.
	 * include all the interactions with the mouse or window
	 * some of this functions are: change the TextField, exit the program, move the window, make diferents mesagges. 
	 * */
	
	private class Escucha implements ActionListener, MouseListener, MouseMotionListener {
		
		private int x,y;

		@Override
		/*
		 * controls of the buttons and its messages in the TextField, show the diferents points in TextArea
		 * Events
		 * */
		public void actionPerformed(ActionEvent event) {
			// TODO Esbozo de método generado automáticamente
			if(event.getSource() == salir) {
				System.exit(0);// exit the program
			}else {
				controlCraps.calcularTiro();
				// graphic visualitation of the dices
				imagen = new ImageIcon("src/Images/"+controlCraps.getCaradado1()+
																		".png");
				dado1.setIcon(imagen);
				imagen = new ImageIcon("src/Images/"+controlCraps.getCaradado2()+
																		".png");
				dado2.setIcon(imagen);
				
				controlCraps.determinarJuego();
				valorTiro.setText(String.valueOf(controlCraps.getTiro()));
				
				
				switch(controlCraps.getEstado()) {
				case 1: //win
					
					// add line to line (no delete previous messages)
					mensajes.append("You win! \n");
					
					break;	
				case 2: // lose
					mensajes.append("You lose! \n");
					 
					break;
				case 3: // point
					valorPunto.setText(String.valueOf(controlCraps.getPunto()));
					String mensaje = "You set point : "+controlCraps.getPunto()+
							"\n You must get the point value to win"+ "\n" +
							" if you get 7 you lose. \n";  
					mensajes.append(mensaje);
					
					break;
				}
			}
		}

		@Override
		/*
		 * controls of the actions mouse, like Clicked, Pressed, Entered, Dragged, etc.
		 * Events of mouse
		 * */
		// when mouse click a thing
		public void mouseClicked(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
			
		}

		@Override
		// press inside of the environment
		public void mousePressed(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
			x = eventMouse.getX();
			y = eventMouse.getY();
		}

		@Override
		//release
		public void mouseReleased(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
			
		}

		@Override
		// cuando el mause entra al componente grafico
		// when the mouse enter in the graphic component
		public void mouseEntered(MouseEvent eventMouse) {
		// TODO Esbozo de método generado automáticamente
			
		}

		@Override
		//when the mouse leave in the graphic component 
		public void mouseExited(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
			
		}

		@Override
		public void mouseDragged(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
					// position of the window, number of the units thats move in x 
			setLocation(vistaGridBagLayout.getLocation().x +eventMouse.getX()- x ,
					// position of the window, number of the units thats move in y 
					vistaGridBagLayout.getLocation().y+eventMouse.getY()- y );
		}

		@Override
		public void mouseMoved(MouseEvent eventMouse) {
			// TODO Esbozo de método generado automáticamente
			
		}
		
		
	}
	
}
