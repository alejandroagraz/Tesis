package funciones;
import javax.swing.JDialog; // importa libreria javax.swing.JDialog; 

@SuppressWarnings("serial")
public class Dialogo extends JDialog{ // la clase Dialogo extiende a JDialog

	public Dialogo(String titulo, int x,int y) // incio funcion Dialogo a la que se le pasa como parametro la variable
	// String titulo, int x,int y	
	{	
	setLayout(null); // llama metodo setLayout 
	setModal(true); // llama metodo setModal
	setTitle(titulo); // llama metodo setTitle
	setSize(x,y); // llama metodo setSize
	setLocationRelativeTo(this); // llama metodo setLocationRelativeTo
	setResizable(true); // llama metodo setResizable
	} // fin funcion Dialogo
} // fin clase Dialogo