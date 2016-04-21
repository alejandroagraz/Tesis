package administrador;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import calculadora.Calculadora;
import calendario.Calendario;
import Todo_recepciones.Buscar_recepciones;
import funciones.Mensaje;
import funciones.Panel;
import todo_Facturas.Buscar_facturas;
import todo_Facturas.Facturacion;
import todo_clientes.Buscar_cliente;
import todo_clientes.Nuevo_cliente;
import todo_ganancias.Ganacias_Inversiones;
import todo_producto.Buscar_Producto;
import todo_producto.Entradas;
import todo_producto.Imprimir_lista_por_stock;
import todo_producto.Imprimir_lista_por_ubi;
import todo_producto.Nuevo_Producto;
import todo_proveedor.Buscar_proveedor;
import todo_proveedor.Nuevo_Proveedor;

public class Interfas_Principal extends JFrame implements ActionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	Panel panelt=new Panel();
	String iva="";
	String hoy;
	JLabel hora;
	Timer timpo;
	ImageIcon icono_consultas;
    Image incono,fondo;
    ImageIcon icono_clientes;
    ImageIcon icono_cuentas;
    ImageIcon icono_config;
    ImageIcon icono_salir;
    ImageIcon icono_inventario;
    ImageIcon icono_proveedores;
    ImageIcon icono_facturas;
    ImageIcon icono_select;
    ImageIcon icono_herramientas;
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	SimpleDateFormat dma = new SimpleDateFormat("dd:mm:yyyy");
	JMenu archivo,inventario,proveedores,clientes,facturas,configuracion,cuentas,consultas,herramientas;
	JMenuBar barrademenu;
	JMenuItem Listado_por_pro,Listado_por_ubi,Listado_por_stock,
	calendario,Entradas,calculadora,facturacion,opciones,nuevo_producto,
	buscar_editar_p,salir,buscar_f,nuevo_cliente,
	buscar_editar_c,nuevo_proveedor,buscar_proveedor,
	ganancias_Inversiones,cerrar_session;
    Confing c;
	Usuarios user;
	boolean fact,config;
	public Interfas_Principal(String usuario,String titulov,String rifv,String ivav,boolean inventariob,boolean facturacionb,boolean clientesb,boolean facturasb,boolean proveedoresb,boolean configuracionb)
	{		
		
		
		fact=facturacionb;
		config=facturacionb;
		c=Conexion.conf;
		user=Conexion.user;
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
		
		setResizable(false);
	    icono_consultas=new ImageIcon("Images" + Inicio.url_sistema + "consultas.png");
		fondo=new ImageIcon("Images" + Inicio.url_sistema + "fondo.jpg").getImage();
		incono=new ImageIcon("Images" + Inicio.url_sistema + "logo.gif").getImage();
		icono_clientes=new ImageIcon("Images" + Inicio.url_sistema + "clientes.png");
		icono_cuentas=new ImageIcon("Images" + Inicio.url_sistema + "cuentas.png");
		icono_config=new ImageIcon("Images" + Inicio.url_sistema + "configuracion.png");
		icono_salir=new ImageIcon("Images" + Inicio.url_sistema + "salir.png");
		icono_inventario=new ImageIcon("Images" + Inicio.url_sistema + "inventario.png");
		icono_proveedores=new ImageIcon("Images" + Inicio.url_sistema + "proveedores.png");
		icono_facturas=new ImageIcon("Images" + Inicio.url_sistema + "facturacion.jpg");
		icono_select=new ImageIcon("Images" + Inicio.url_sistema + "select.png");
		icono_herramientas=new ImageIcon("Images" + Inicio.url_sistema + "herramientas.png");
		setIconImage(incono);
		
		panelt.setbacgroundimage(fondo);
		
	
	barrademenu=new JMenuBar();
    barrademenu.setCursor(new Cursor(12));
	Date fechaactual= new Date();
	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyy");
	hoy=formato.format(fechaactual);
	hora=new JLabel();
	hora.setText(sdf.format(new Date(System.currentTimeMillis()))+"         "+hoy); 
	hora.setFont(new Font("Dialog", Font.PLAIN, 24));
	hora.setBounds(720,0,300,20);
	timpo = new Timer(1, this);
	timpo.setRepeats(true);
	timpo.start();
		
		archivo=new JMenu(Inicio.users.getXusuario()+"    ");
		consultas=new JMenu("Consultas    ");
        consultas.setIcon(icono_consultas);
		herramientas=new JMenu("Herramientas    ");
        herramientas.setIcon(icono_herramientas);
		inventario=new JMenu("Inventario    ");
		inventario.setIcon(icono_inventario    );
		proveedores=new JMenu("Proveedores    ");
		proveedores.setIcon(icono_proveedores);
		clientes=new JMenu("Clientes    ");
		clientes.setIcon(icono_clientes);
		facturas=new JMenu("Control Notas de Entrega");
		facturas.setIcon(icono_facturas);
        cuentas=new JMenu("Cuentas    ");
        cuentas.setIcon(icono_cuentas);
		configuracion=new JMenu("Configuracion    ");
		configuracion.setIcon(icono_config);
		opciones=new JMenuItem("Opciones",KeyEvent.VK_F11);
	    opciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11 ,ActionEvent.CTRL_MASK));
		opciones.setIcon(icono_select);
		configuracion.add(opciones);
		//------------------------------------
		
		calculadora=new JMenuItem("Calculadora",KeyEvent.VK_F12);
		calculadora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12 ,ActionEvent.CTRL_MASK));
		calculadora.setIcon(icono_select);
		
		//<-------------------------------------->Menu de Opciones de Consultas<--------------------------------->
		
		Listado_por_ubi=new JMenuItem("Listado por Departamento ");
		Listado_por_ubi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U ,ActionEvent.CTRL_MASK));
		Listado_por_ubi.setIcon(icono_select);
		
		Listado_por_stock=new JMenuItem("Listado por Stock");
		Listado_por_stock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S ,ActionEvent.CTRL_MASK));
		Listado_por_stock.setIcon(icono_select);
		
		Listado_por_pro=new JMenuItem("Listado por Proveedor ");
		Listado_por_pro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P ,ActionEvent.CTRL_MASK));
		Listado_por_pro.setIcon(icono_select);
		
		
		//<-------------------------------------->Menu de Opciones de Consultas<--------------------------------->
		
		
		calendario=new JMenuItem("Calendario",KeyEvent.VK_C);
		calendario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C ,ActionEvent.CTRL_MASK));
		calendario.setIcon(icono_select);
		
		Entradas=new JMenuItem("Entradas",KeyEvent.VK_E);
		Entradas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E ,ActionEvent.CTRL_MASK));
		Entradas.setIcon(icono_select);
		
		
		facturacion=new JMenuItem("Registrar Nota de Entrega",KeyEvent.VK_F10);
		facturacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10 ,ActionEvent.CTRL_MASK));
		facturacion.setIcon(icono_select);
		nuevo_proveedor=new JMenuItem("Nuevo Proveedor",KeyEvent.VK_F4);
		nuevo_proveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4 ,ActionEvent.CTRL_MASK));
		nuevo_proveedor.setIcon(icono_select);
		buscar_proveedor=new JMenuItem("Buscar y Editar",KeyEvent.VK_F5);
		buscar_proveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5 ,ActionEvent.CTRL_MASK));
		buscar_proveedor.setIcon(icono_select);
		nuevo_producto=new JMenuItem("Nuevo Producto",KeyEvent.VK_F2);
		nuevo_producto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2 ,ActionEvent.CTRL_MASK));
		nuevo_producto.setIcon(icono_select);
		nuevo_cliente=new JMenuItem("Nuevo Cliente",KeyEvent.VK_F6);
		nuevo_cliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6 ,ActionEvent.CTRL_MASK));
		nuevo_cliente.setIcon(icono_select);
		buscar_editar_c=new JMenuItem("Buscar y Editar",KeyEvent.VK_F7);
		buscar_editar_c.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7 ,ActionEvent.CTRL_MASK));
		buscar_editar_c.setIcon(icono_select);
		buscar_editar_p=new JMenuItem("Gestion de Inventario",KeyEvent.VK_F3);
		buscar_editar_p.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3 ,ActionEvent.CTRL_MASK));
		buscar_editar_p.setIcon(icono_select);
		//buscar_recepciones=new JMenuItem("Buscar recepciones",KeyEvent.VK_F9);
		//buscar_recepciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9 ,ActionEvent.CTRL_MASK));
		//buscar_recepciones.setIcon(icono_select);
		ganancias_Inversiones=new JMenuItem("Ganancias e Inversiones",KeyEvent.VK_F1);
		ganancias_Inversiones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1 ,ActionEvent.CTRL_MASK));
		ganancias_Inversiones.setIcon(icono_select);
		salir=new JMenuItem("Salir  Esc");
		
        salir.setIcon(icono_salir);
        
        cerrar_session=new JMenuItem("Cerrar Sesion");
		
        cerrar_session.setIcon(icono_salir);
      
		buscar_f=new JMenuItem("Buscar",KeyEvent.VK_F8);
		buscar_f.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8 ,ActionEvent.CTRL_MASK));
		buscar_f.setIcon(icono_select);
				//------------------------------------------

		//------------------------------------->CONSULTAS<------------------------------------------------->
		consultas.add(Listado_por_ubi);
		consultas.add(Listado_por_stock);
		//------------------------------------->CONSULTAS<------------------------------------------------->
		
		
		proveedores.add(nuevo_proveedor);
		proveedores.add(buscar_proveedor);
		inventario.add(nuevo_producto);
		inventario.add(buscar_editar_p);
		inventario.add(Entradas);
        herramientas.add(calculadora);
        herramientas.add(calendario);
		cuentas.add(ganancias_Inversiones);
		clientes.add(nuevo_cliente);
		clientes.add(buscar_editar_c);
		//--------------------------------------------------

		clientes.add(nuevo_cliente);
		clientes.add(buscar_editar_c);

		barrademenu.add(archivo);
		archivo.add(cerrar_session);
		archivo.add(salir);
        ivav=iva;
        
		if(inventariob){
			barrademenu.add(consultas);
			barrademenu.add(cuentas);
			barrademenu.add(inventario);}
		if(proveedoresb){barrademenu.add(proveedores);}
		
		
		if(clientesb){barrademenu.add(clientes);}
		
		if(facturasb){
			facturas.add(buscar_f);
			//facturas.add(buscar_recepciones);
			barrademenu.add(facturas);}
		if(facturacionb)
		{
			facturas.add(facturacion);
			barrademenu.add(facturas);}
		
		if(configuracionb){barrademenu.add(configuracion);}
		
		barrademenu.add(herramientas);
		
		addKeyListener(this);
		facturacion.addActionListener(this);
		salir.addActionListener(this);
		cerrar_session.addActionListener(this);
		opciones.addActionListener(this);
		calculadora.addActionListener(this);
		calendario.addActionListener(this);
		nuevo_cliente.addActionListener(this);
		buscar_editar_p.addActionListener(this);
		buscar_editar_c.addActionListener(this);
		buscar_f.addActionListener(this);
		//buscar_recepciones.addActionListener(this);
		buscar_proveedor.addActionListener(this);
		nuevo_producto.addActionListener(this);
		nuevo_proveedor.addActionListener(this);
		ganancias_Inversiones.addActionListener(this);
		Entradas.addActionListener(this);
		Listado_por_ubi.addActionListener(this);
		Listado_por_stock.addActionListener(this);
		setTitle(titulov);
		
		
		setDefaultCloseOperation(0);

	add(barrademenu,BorderLayout.NORTH);
	add(panelt);
		//add(hora,BorderLayout.NORTH);
		setVisible(true);
	}
	
	
    
public void actionPerformed(ActionEvent a) {
	
	if(a.getSource().equals(calendario))
	{
		new Calendario();
	}
	else
	if(a.getSource().equals(calculadora))
	{
		new Calculadora();
	}
	else
	if(a.getSource().equals(ganancias_Inversiones))
	{
		new Ganacias_Inversiones();
	}
	//else
	
		//if(a.getSource().equals(buscar_recepciones))
		//{
		//	new Buscar_recepciones();
		//}
		else
		if(a.getSource().equals(opciones))
		{
			new Loguin_confg();
		}
		else	
	if(a.getSource().equals(Entradas))
	{
		Entradas dialog = new Entradas();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	else if(a.getSource().equals(Listado_por_stock))
	{
		new Imprimir_lista_por_stock();
	}
	else if(a.getSource().equals(Listado_por_ubi))
	{
		JComboBox<String> dato_select =new JComboBox<String>();
		dato_select.addItem("--");
		dato_select.addItem("Topografia");
		dato_select.addItem("Constructora");
		dato_select.addItem("Agricultura");
		new Mensaje().select("Introduzca Departamento", "Listado por Departamento", "Departamento", dato_select);
		if(Mensaje.resp_select)
		{
			new Imprimir_lista_por_ubi(Mensaje.dato);
		}
	}

		else
     if (a.getSource().equals(timpo)) {
	hora.setText(sdf.format(new Date(System.currentTimeMillis()))+"         "+hoy);}
    else
	if(a.getSource().equals(salir)){ new Mensaje().pregunta("Desea Salir del Sistema","Salir");
	if(Mensaje.resp)
	{new Conexion().close(); System.exit(0);}
	}
	else if(a.getSource().equals(cerrar_session)){ new Mensaje().pregunta("Desea Cerrar Sesion.?","Salir");
	if(Mensaje.resp)
	{
	new Conexion().close();
	this.dispose();
	Inicio.main(null);
	}
	}
	
	else
	if(a.getSource().equals(nuevo_proveedor)){new Nuevo_Proveedor();}
	else
	if(a.getSource().equals(nuevo_producto)){new Nuevo_Producto();}
	else
	if(a.getSource().equals(nuevo_cliente)){new Nuevo_cliente("",false);}
	else
	if(a.getSource().equals(buscar_editar_c)){new Buscar_cliente();}
	else
	if(a.getSource().equals(buscar_f)){new Buscar_facturas();}
	else
	if(a.getSource().equals(buscar_editar_p)){new Buscar_Producto();}
	else
	if(a.getSource().equals(buscar_proveedor)){new Buscar_proveedor();}
	else
		if(a.getSource().equals(facturacion)){new Facturacion(user.getXusuario(),c.getNombre_empresa(),c.getRif(),c.getIva());}
}


public void keyPressed(KeyEvent x) {
	if(x.getKeyCode()==KeyEvent.VK_ESCAPE)
	{
		new Mensaje().pregunta("Desea Salir del Sistema","Salir");
		if(Mensaje.resp)
		{new Conexion().close(); System.exit(0);}
		
	}
}

@Override
public void keyReleased(KeyEvent x) {}
public void keyTyped(KeyEvent arg0) {}
}