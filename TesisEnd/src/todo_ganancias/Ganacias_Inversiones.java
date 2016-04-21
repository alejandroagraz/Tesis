package todo_ganancias;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import datechooser.beans.DateChooserDialog;
import funciones.Dialogo;
import funciones.Enfocar;
import funciones.Fondo;
import funciones.Mensaje;
import funciones.Pintar_boton;
import funciones.Pintar_label;
import funciones.Pintar_txt;
import funciones.formatoBigDecimal;

public class Ganacias_Inversiones implements ActionListener,KeyListener{

	JTabbedPane paneles;
	
	//---------------------------------
	Fondo ganancias_del_dia, ganancias_del_rango;
    JTextField fecha_dia, fecha_uno, fecha_dos;
    JLabel dial,mesl,anol,totall, rangol;
    String totalString="0.00";
    JButton buscar_dia, btn_fecha_dia, rango_buscar, btn_fecha_dos, btn_fecha_uno;
    //--------------------------------
    Fondo ganancias_del_mes;
    JTextField fecha_mes;
    JLabel mes_mesl,mes_anol,mes_totall;
    String mes_totalString="0.00";
    JButton mes_buscar, btn_fecha_mes;
    //----------------------------------
    
    Fondo ganancias_del_ano;
    JTextField ano_ano;
    JLabel ano_anol,ano_totall, rango_totall;
    String ano_totalString="0.00";
    String rango_totalString="0.00";
    JButton ano_buscar, btn_fecha_ano;
    //------------------------------------------
    
    Fondo ganancias_e_Inverciones_del_inventario;
    JLabel gananciasl,Invercionl,total_inventariol;
    String totalgananciaString="0.00";
    String totalInvercionesString="0.00";
    String TOTAL_Inventario="0.00";
    JButton actualizar;
    //---------------------------------------------------------------------
    
	Dialogo d=new Dialogo("Ganancias e Inversiones", 600,150);
	public Ganacias_Inversiones()
	{
        paneles=new JTabbedPane();
        paneles.setBounds(10,0,575,120);
    //--------------------------------PANEL DE GANANCIAS DEL DIA------------------------------------------
        
        ganancias_del_dia=new Fondo(0,0);
		ganancias_del_dia.setLayout(null);
		ganancias_del_dia.setBounds(10,30,400,150);
		buscar_dia=new JButton("Buscar");
		buscar_dia.setBounds(250, 30, 100,30);
		new Pintar_boton(buscar_dia);
		ganancias_del_dia.add(buscar_dia);
		
		dial=new JLabel("Dia:");
		new Pintar_label(dial);
		dial.setBounds(10,30,35,30);
		ganancias_del_dia.add(dial);
		
		fecha_dia=new JTextField();
		new Pintar_txt(fecha_dia);
		fecha_dia.setBounds(40,30,100,30);
		fecha_dia.disable();
		ganancias_del_dia.add(fecha_dia);
		
		btn_fecha_dia=new JButton("..");
		new Pintar_boton(btn_fecha_dia);
		btn_fecha_dia.setBounds(150,30,30,30);
		ganancias_del_dia.add(btn_fecha_dia);
		
	    totall=new JLabel("BsF "+totalString);
        new Pintar_label(totall);
        totall.setFont(new Font(null,1,16));
        totall.setBounds(400,35,200,20);
        ganancias_del_dia.add(totall);
	
		paneles.addTab("Ganancias del Dia",null,ganancias_del_dia,"Ganancias del Dia");
		
		
		
		//-----------------------------------ganancias mes-----------------------------------------------------------------------------------------------------------
		
		    ganancias_del_mes=new Fondo(0,0);
		    ganancias_del_mes.setLayout(null);
		    ganancias_del_mes.setBounds(10,30,400,150);
		    mes_buscar=new JButton("Buscar");
		    mes_buscar.setBounds(250, 30, 100,30);
			new Pintar_boton(mes_buscar);
			ganancias_del_mes.add(mes_buscar);
			
		
			mes_mesl=new JLabel("Mes:");
			new Pintar_label(mes_mesl);
			mes_mesl.setBounds(10,30,35,30);
			ganancias_del_mes.add(mes_mesl);
			
			
			fecha_mes=new JTextField();
			new Pintar_txt(fecha_mes);
			fecha_mes.setBounds(40,30,100,30);
			ganancias_del_mes.add(fecha_mes);
			fecha_mes.disable();
			
			btn_fecha_mes=new JButton("..");
			new Pintar_boton(btn_fecha_mes);
			btn_fecha_mes.setBounds(150,30,30,30);
			ganancias_del_mes.add(btn_fecha_mes);
			

			mes_totall=new JLabel("BsF "+mes_totalString);
	        new Pintar_label(mes_totall);
	        mes_totall.setFont(new Font(null,1,16));
	        mes_totall.setBounds(400,35,200,20);
	        ganancias_del_mes.add(mes_totall);
			paneles.addTab("Ganancias del Mes",null,ganancias_del_mes,"Ganancias del Mes");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			//-----------------------------------ganancias Ano-----------------------------------------------------------------------------------------------------------
			
		    ganancias_del_ano=new Fondo(0,0);
		    ganancias_del_ano.setLayout(null);
		    ganancias_del_ano.setBounds(10,30,400,150);
		    ano_buscar=new JButton("Buscar");
		    ano_buscar.setBounds(250, 30, 100,30);
			new Pintar_boton(ano_buscar);
			ganancias_del_ano.add(ano_buscar);
				
			ano_anol=new JLabel("Año:");
			new Pintar_label(ano_anol);
			ano_anol.setBounds(10,30,35,30);
			ganancias_del_ano.add(ano_anol);
			
			
			ano_totall=new JLabel("BsF "+ano_totalString);
	        new Pintar_label(ano_totall);
	        ano_totall.setFont(new Font(null,1,16));
	        ano_totall.setBounds(400,35,200,20);
	        ganancias_del_ano.add(ano_totall);
	        
	        ano_ano=new JTextField();
			new Pintar_txt(ano_ano);
			ano_ano.setBounds(40,30,100,30);
			ano_ano.disable();
			ganancias_del_ano.add(ano_ano);
			
			
			btn_fecha_ano=new JButton("..");
			new Pintar_boton(btn_fecha_ano);
			btn_fecha_ano.setBounds(150,30,30,30);
			ganancias_del_ano.add(btn_fecha_ano);
			
			paneles.addTab("Ganancias del Año",null,ganancias_del_ano,"Ganancias del Año");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			
//-----------------------------------ganancias rango fecha-----------------------------------------------------------------------------------------------------------
			
		    ganancias_del_rango=new Fondo(0,0);
		    ganancias_del_rango.setLayout(null);
		    ganancias_del_rango.setBounds(10,30,400,150);
		    rango_buscar=new JButton("Buscar");
		    rango_buscar.setBounds(320, 30, 100,30);
			new Pintar_boton(rango_buscar);
			ganancias_del_rango.add(rango_buscar);
				
			rangol=new JLabel("Rango:");
			new Pintar_label(rangol);
			rangol.setBounds(10,30,50,30);
			ganancias_del_rango.add(rangol);
			
			
			rango_totall=new JLabel("BsF "+rango_totalString);
	        new Pintar_label(rango_totall);
	        rango_totall.setFont(new Font(null,1,16));
	        rango_totall.setBounds(430,35,200,20);
	        ganancias_del_rango.add(rango_totall);
	        
	        fecha_uno=new JTextField();
			new Pintar_txt(fecha_uno);
			fecha_uno.setBounds(60,30,100,30);
			fecha_uno.disable();
			ganancias_del_rango.add(fecha_uno);

			fecha_dos=new JTextField();
			new Pintar_txt(fecha_dos);
			fecha_dos.setBounds(190,30,100,30);
			fecha_dos.disable();
			ganancias_del_rango.add(fecha_dos);

			
			btn_fecha_uno=new JButton("..");
			new Pintar_boton(btn_fecha_uno);
			btn_fecha_uno.setBounds(160,30,30,30);
			ganancias_del_rango.add(btn_fecha_uno);
			
			btn_fecha_dos=new JButton("..");
			new Pintar_boton(btn_fecha_dos);
			btn_fecha_dos.setBounds(290,30,30,30);
			ganancias_del_rango.add(btn_fecha_dos);
			
			paneles.addTab("Ganancias por Rango",null,ganancias_del_rango,"Ganancias por Rango");
		//----------------------------------------------------------------------------------------------------------------------------------
		
			
			
			        ganancias_e_Inverciones_del_inventario=new Fondo(0,0);
			        ganancias_e_Inverciones_del_inventario.setLayout(null);
			        ganancias_e_Inverciones_del_inventario.setBounds(10,30,400,150);
			    
			        actualizar=new JButton("Buscar");
			        actualizar.setBounds(450, 22, 100,30);
				new Pintar_boton(actualizar);
				ganancias_e_Inverciones_del_inventario.add(actualizar);
					
				
				
			    gananciasl=new JLabel("Ganancia  BsF "+totalgananciaString);
				new Pintar_label(gananciasl);
				gananciasl.setFont(new Font(null,1,16));
				gananciasl.setBounds(10,5,300,30);
				ganancias_e_Inverciones_del_inventario.add(gananciasl);
				
				
				    total_inventariol=new JLabel("Total  BsF "+TOTAL_Inventario);
					new Pintar_label(total_inventariol);
					total_inventariol.setFont(new Font(null,1,16));
					total_inventariol.setBounds(250,20,300,30);
					ganancias_e_Inverciones_del_inventario.add(total_inventariol);
				
				
				Invercionl=new JLabel("Invercion  BsF "+totalInvercionesString);
		        new Pintar_label(Invercionl);
		        Invercionl.setFont(new Font(null,1,16));
		        Invercionl.setBounds(10,35,300,20);
		        ganancias_e_Inverciones_del_inventario.add(Invercionl);
		        
		        
				paneles.addTab("Ganancias e Inversiones en el Inventario ",null,ganancias_e_Inverciones_del_inventario,"Ganancias e Inversiones en el Inventario ");
			
		d.add(paneles);
		buscar_dia.addActionListener(this);
		btn_fecha_dia.addActionListener(this);
		btn_fecha_mes.addActionListener(this);
		btn_fecha_dos.addActionListener(this);
		btn_fecha_uno.addActionListener(this);
		btn_fecha_ano.addActionListener(this);
		ano_buscar.addActionListener(this);
		rango_buscar.addActionListener(this);
		ano_buscar.addKeyListener(this);
		buscar_dia.addKeyListener(this);
		mes_buscar.addActionListener(this);
		mes_buscar.addKeyListener(this);
		actualizar.addActionListener(this);
		actualizar.addKeyListener(this);
		ano_ano.addKeyListener(this);
		new Enfocar(fecha_dia);
		d.setVisible(true);
		
	}
	@Override
	public void keyPressed(KeyEvent g) {
							if(g.getSource().equals(ano_ano))
							{
							if(g.getKeyCode()==Event.ENTER){new Enfocar(ano_buscar);}
							}
							else
		if(g.getSource().equals(mes_buscar))
		{
		if(g.getKeyCode()==Event.ENTER){BigDecimal total_dia=new BigDecimal("0");
		   String fecha=fecha_mes.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    mes_totall.setText("BsF "+total_dia);}
		}
		else
			if(g.getSource().equals(buscar_dia))
			{
			if(g.getKeyCode()==Event.ENTER)
			{
				 BigDecimal total_dia=new BigDecimal("0");
				   String fecha=fecha_dia.getText();
				    total_dia=new Buscador().Buscar_dia(fecha);
				   totall.setText("BsF "+total_dia);
			}
			}
			else
				if(g.getSource().equals(ano_buscar))
				{
				if(g.getKeyCode()==Event.ENTER)
				{
					BigDecimal total_dia=new BigDecimal("0");
					   String fecha="/"+ano_ano.getText();
					    total_dia=new Buscador().Buscar_mes(fecha);
					    ano_totall.setText("BsF "+total_dia);
				}
				}
	}
	@Override
	public void keyReleased(KeyEvent g) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent g) {
		
		if(g.getSource().equals(ano_ano))
		{
			if(ano_ano.getText().length()==4){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		else
		if(g.getSource().equals(fecha_dia))
		{
			if(fecha_dia.getText().length()==2){g.consume();}
			else{
			char x=g.getKeyChar();
			if(x<'0' || x>'9'){g.consume();}
			}	
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		
		 if(a.getSource().equals(actualizar))
			{
			   
			   
			    String xx[]=new Buscador().ganancias_Invercion();
			  
			   BigDecimal total_inverciones=new BigDecimal( xx[0]);
			   totalInvercionesString = formatoBigDecimal.bigDecimalToString(total_inverciones);
			   Invercionl.setText("Invercion  BsF "+totalInvercionesString);
			   
			   BigDecimal total_ganancias=new BigDecimal(xx[1]);
			   totalgananciaString = formatoBigDecimal.bigDecimalToString(total_ganancias);
			   gananciasl.setText("Ganancia  BsF "+totalgananciaString);
			   
			   BigDecimal totalx=new BigDecimal("0");
			   totalx=total_ganancias.add(total_inverciones).setScale(2,RoundingMode.HALF_EVEN);
			   TOTAL_Inventario = formatoBigDecimal.bigDecimalToString(totalx);
			   total_inventariol.setText("Total  BsF "+TOTAL_Inventario);
			}
		 else
	   if(a.getSource().equals(buscar_dia))
		{
		   BigDecimal total_dia=new BigDecimal("0");
		   String fecha=fecha_dia.getText();
		    total_dia=new Buscador().Buscar_dia(fecha);
		   totall.setText("BsF "+formatoBigDecimal.bigDecimalToString(total_dia));
		    
		}
	   else
		   if(a.getSource().equals(mes_buscar))
			{
			   BigDecimal total_dia=new BigDecimal("0");
			   String fecha=fecha_mes.getText();
			    total_dia=new Buscador().Buscar_mes(fecha);
			    mes_totall.setText("BsF "+formatoBigDecimal.bigDecimalToString(total_dia));
			    
			}
		   else
	   if(a.getSource().equals(ano_buscar))
		{
		   BigDecimal total_dia=new BigDecimal("0");
		   String fecha="/"+ano_ano.getText();
		    total_dia=new Buscador().Buscar_mes(fecha);
		    ano_totall.setText("BsF "+formatoBigDecimal.bigDecimalToString(total_dia));
		}
	   else if(a.getSource().equals(rango_buscar))
			{
			   BigDecimal total_dia=new BigDecimal("0");
			   String fecha1=fecha_uno.getText();
			   String fecha2=fecha_dos.getText();
			   if(fecha_uno.getText().equals("") || fecha_dos.equals("")){
				   new Mensaje().error("Seleccione Rango de Fechas", "Error");   
			   }else{
				   total_dia=new Buscador().Buscar_rango(fecha1, fecha2);
				    rango_totall.setText("BsF "+formatoBigDecimal.bigDecimalToString(total_dia));   
			   		}
			    
			}
	   else if(a.getSource().equals(btn_fecha_dia))
		{
			 DateChooserDialog dt = new DateChooserDialog(); 
				Dimension dim=new Dimension(350,300);
				dt.setCalendarPreferredSize(dim);
				dt.showDialog(null);
				String d = date_format(dt.getSelection().toString(), "");
				fecha_dia.setText(d);
		}
	   else if(a.getSource().equals(btn_fecha_mes))
		{
			 DateChooserDialog dt = new DateChooserDialog(); 
				Dimension dim=new Dimension(350,300);
				dt.setCalendarPreferredSize(dim);
				dt.showDialog(null);
				String d = date_format(dt.getSelection().toString(), "mes");
				fecha_mes.setText(d);
		}
	   else if(a.getSource().equals(btn_fecha_uno))
		{
			 DateChooserDialog dt = new DateChooserDialog(); 
				Dimension dim=new Dimension(350,300);
				dt.setCalendarPreferredSize(dim);
				dt.showDialog(null);
				String d = date_format(dt.getSelection().toString(), "");
				fecha_uno.setText(d);
		}
	   else if(a.getSource().equals(btn_fecha_dos))
		{
			 DateChooserDialog dt = new DateChooserDialog(); 
				Dimension dim=new Dimension(350,300);
				dt.setCalendarPreferredSize(dim);
				dt.showDialog(null);
				String d = date_format(dt.getSelection().toString(), "");
				fecha_dos.setText(d);
		}
	   else if(a.getSource().equals(btn_fecha_ano))
		{
			 DateChooserDialog dt = new DateChooserDialog(); 
				Dimension dim=new Dimension(350,300);
				dt.setCalendarPreferredSize(dim);
				dt.showDialog(null);
				String d = date_format(dt.getSelection().toString(),"ano");
				ano_ano.setText(d);
		}

		
	}
	
	public String date_format(String date, String retur_data){
		String cadena[]; 
		cadena = date.split("/");
		cadena[0] = cadena[0].replace("[", "");
		if(cadena[0].length()<=1){cadena[0] = "0" + cadena[0];}
		cadena[2] = cadena[2].replace("]", "");
		if(retur_data.equals("ano")){
			return "20"+cadena[2];
		}else if(retur_data.equals("mes")){
			return cadena[1]+"/20"+cadena[2];
		}else{
			return cadena[0]+"/"+cadena[1]+"/20"+cadena[2];	
		}
	}
	
}
