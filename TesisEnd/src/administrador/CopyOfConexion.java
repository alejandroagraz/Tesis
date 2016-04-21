package administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JComboBox;

import funciones.Cod_pw;
import funciones.Dco_pw;
import funciones.Mensaje;

public class CopyOfConexion {
	
	static LinkedList<String[]> lista_users;
	static  Confing conf=new Confing();
	static  Usuarios user=new Usuarios();
	public static Connection conect;
	
	public void conectar_access(){
		try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String strConect="jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=Data\\Administracion.mdb";
		conect = DriverManager.getConnection(strConect,"administrador","genius2811");
		} catch (Exception ex) {
		new  Mensaje().error(" "+ex,"Error al conectar a la base datos");
	}
		}

	public boolean entrar(String pasword,String user)
	{
		 String pass = "";
		
		try {
			Statement stm= conect.createStatement();
			ResultSet rs=stm.executeQuery("select CONTRASE�A from USUARIOS where USUARIO='"+user+"';");
		
			rs.next();
			pass=rs.getString(1);
			rs.close();
		} catch (SQLException e) {
			new Mensaje().error(" "+e, "Error");
		}
			if(pasword.equals(new Dco_pw().Decodificacionm(pass)))
			{
				return true;
			}
		return false;	
}
	
	public JComboBox<String> buscar_usuarios()
	{
		try {
			Statement stm= conect.createStatement();
			ResultSet rs=stm.executeQuery("select USUARIO from USUARIOS;");
		   JComboBox<String>lista =new JComboBox<>();
		
			while(rs.next())
			{
				lista.addItem(rs.getString(1));
				
			}
			if(lista.getItemCount()==0)
			{
				return null;
			}
		  return lista;
		} catch (SQLException e) {
		}
		return null;
	}
	
 	public static void cargar_privilegios(String usuario){
 	        lista_users=new LinkedList<>();
 	
 		try{
 			
 			Statement stm3= conect.createStatement();
			ResultSet rs3=stm3.executeQuery("select *from USUARIOS");
 			
			while(rs3.next())
			{
				String usuariov[];
				usuariov=new String[9];
				
				usuariov[1]=rs3.getString(1);
				usuariov[2]=new Dco_pw().Decodificacionm(rs3.getString(2));
				usuariov[3]=rs3.getString(3);
				
				usuariov[4]=rs3.getString(4);
				usuariov[5]=rs3.getString(5);
				usuariov[6]=rs3.getString(6);
				usuariov[7]=rs3.getString(7);
				usuariov[8]=rs3.getString(8);
		        lista_users.add(usuariov);
			}
			
 			
 			Statement stm= conect.createStatement();
			ResultSet rs=stm.executeQuery("select *from USUARIOS where USUARIO='"+usuario+"'");
			
			Statement stm1= conect.createStatement();
			ResultSet rs1=stm1.executeQuery("select *from CONFIGURACION");
			
			rs1.next();
			
			conf.setRif(rs1.getString(2));
			conf.setNombre_empresa(rs1.getString(3));
			conf.setIva(rs1.getString(4));
			conf.setCorrero(rs1.getString(5));
			conf.setTelefono1(rs1.getString(6));
			conf.setTelefono2(rs1.getString(7));
			conf.setTelefono3(rs1.getString(8));
			conf.setDireccion(rs1.getString(9));
			
			rs1.close();
			stm1.close();
 				
 					
			rs.next();
		   
			    user.setXusuario(rs.getString(1));
			    Inicio.inventario=rs.getBoolean(3);
				Inicio.facturas=rs.getBoolean(4);
				Inicio.facturacion=rs.getBoolean(5);
				Inicio.clientes=rs.getBoolean(6);
				Inicio.configuracion=rs.getBoolean(7);
				Inicio.proveedores=rs.getBoolean(8);
				
				rs.close();
				stm.close();
		} catch (SQLException e) {
			new Mensaje().error(" "+e, "Error");
			e.printStackTrace();
		}
 	}

 	public void close()
	{
	try {
		conect.close();
	    } catch (SQLException e)
	    {
	    	new Mensaje().error(""+e, "Error al cerrar la conexion");
	    }
	}
 	
 	
 	public void actualizar_users(String vector[],String nombre_ante)
 	{
 		
 		try {
			Statement stm= conect.createStatement();
			stm.executeUpdate("UPDATE USUARIOS SET USUARIO='"+vector[1]+"',CONTRASE�A='"+new Cod_pw().Codificacionm(vector[2])+"',INVENTARIO="+vector[3]+
					",FACTURAS="+vector[4]+
					",facturacion="+vector[5]+
					",clientes="+vector[6]+
					",CONFIGURACION="+vector[7]+
					",proveedores="+vector[8]+
					" where USUARIO='"+nombre_ante+"'");
			
		} catch (SQLException e) {
			new Mensaje().error("Error al Actualizar el usuario", "Error");
		}
 		
 	} 
 	
 	public void actualizar_datos(String nombre,String correo,String rif,String direccion,String telefono,String telefono2,String telefono3,String iva)
 	{	
 		try {
			Statement stm= conect.createStatement();
			stm.executeUpdate("UPDATE CONFIGURACION SET RIF='"+rif+"',EMPRESA='"+nombre+"',IVA='"+iva+"',CORREO='"+correo+"',TELEFONO='"+telefono+"',TELEFONO2='"+telefono2+"',TELEFONO3='"+telefono3+"',DIRECCION='"+direccion+"' where ID='01'");
			
              new Mensaje().listo("Actualizados y Guardados los Cambios", "Guardar");
		} catch (SQLException e) {
			new Mensaje().error("Error al Actualizar la configuracion", "Error");
		}
 		
 		
 		
 	}
 	
 	public void Nuevo_usuario(String vector[])
 	{
 		try {
			Statement stm= conect.createStatement();
			stm.executeUpdate("INSERT INTO USUARIOS VALUES('"+vector[1]+"','"+vector[2]+"',"+vector[3]+","+vector[4]+","+vector[5]+","+vector[6]+","+vector[7]+","+vector[8]+")");
		} catch (SQLException e) {new Mensaje().error("Error al Guardar el usuario", "Error");}
 		
 		
 	}
 	
 	
 	public void eliminar_user(String user)
 	{
 		try {
			Statement stm= conect.createStatement();
			stm.executeUpdate("delete from USUARIOS where USUARIO='"+user+"'");
		} catch (SQLException e) {new Mensaje().error("Error al Guardar el usuario", "Error");}
 	}
}