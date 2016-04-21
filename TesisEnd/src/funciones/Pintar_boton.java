package funciones;

import java.awt.Color; // importa libreria java.awt.Color

import java.awt.Cursor; // importa libreria java.awt.Cursor

import java.awt.Font; // importa libreria java.awt.Font

import javax.swing.JButton; // importa libreria java.siwng.JButton

public class Pintar_boton { // inicio clase Pintar_boton

	public Pintar_boton(JButton boton) // inicio funcion pintar_boton le pasa por parametro boton
	{
		boton.setForeground(Color.blue); // metodo que cambia el color del texto 
		boton.setCursor(new Cursor(12)); // metodo que asigna el tipo de cursor 
		boton.setFont(new Font(null, 1, 15)); // metodo que define el tipo de fuente
	} // fin funcion Pintar_boton	
} // fin clase Pintar_boton
