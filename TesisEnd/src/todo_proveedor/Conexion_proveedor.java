package todo_proveedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JComboBox;
import funciones.Mensaje;

import administrador.Conexion;

public class Conexion_proveedor {

	Connection Conex;
	
	public Conexion_proveedor()
	{
		Conex=Conexion.conect;
	}
	public void llenar_combo(JComboBox<String> combo)
	{
		 try {
			   Statement stm= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select CODIGO from proveedores order by CODIGO desc;");
				
				while(rs.next())
				{
					combo.addItem(rs.getString(1));
				}
				rs.close();
				stm.close();
	
			} catch (Exception e) {
				new Mensaje().error("Error al llenar la lista de proveedores Registrados", "Error "+e);
			}
	}
	
	public String ultimo_id()
	{
		String retorno  = "";
		 try {
			   Statement stm= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select CODIGO from proveedores order by CODIGO;");
				
				while(rs.next())
				{
					retorno = rs.getString(1);
				}
				rs.close();
				stm.close();
	
			} catch (Exception e) {
				new Mensaje().error("Error al llenar la lista de proveedores Registrados", "Error "+e);
			}
		 retorno = retorno.split("-")[1];
		 Integer retorno_n = Integer.parseInt(retorno) + 1;
		 return "00" + String.valueOf(retorno_n);
	}
	
	
	
	public boolean Nuevo(Proveedor pro,LinkedList<String> telefonos)
	{
		 try {
			 Statement stm= Conex.createStatement();
				Statement stm2= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select CODIGO from proveedores where CODIGO='"+pro.getId()+"';");
				rs.next();
			if(rs.getRow()>=1)
			{
				new Mensaje().error("El codigo del Proveedor ya Esta Registrado", "El Proveedor Existe");
				rs.close();
				stm.close();
				stm2.close();
				return false;
			}
			else
			{
			  stm2.execute("insert into proveedores values('"+pro.getId()+"','"+pro.getNombre()+"','"+pro.getDireccion()+"','"+pro.getCorrero()+"','"+pro.getCodigo_postal()+"','"+pro.getFax()+"','"+pro.getNombre_vendedor()+"','"+pro.getRif()+"');");
			  for(int i=0;i<telefonos.size();i++){
			  stm2.execute("insert into telefonos values('"+pro.getId()+"','"+telefonos.get(i).toString()+"')");
			                                     }
			  stm2.close();
			}
			
			} catch (Exception e) {
				new Mensaje().error("Error al Insertar El proveedor", "Error "+e);
			}
		return true;
	}
	
	public LinkedList<Proveedor> buscar(String texto){
          LinkedList<Proveedor> lista=new LinkedList<>();
          
		try {
			Statement stm2= Conex.createStatement();
			Statement stm= Conex.createStatement();
			ResultSet rs=stm.executeQuery("select *from proveedores where CODIGO like '%"+texto+"%' or NOMBRE LIKE '%"+texto+"%' or DIRECCION LIKE '%"+texto+"%' or CORREO LIKE '%"+texto+"%' or NOMBRE_VEND LIKE '%"+texto+"%' or RIF LIKE '%"+texto+"%'");
			
			while(rs.next())
			{
				Proveedor c=new Proveedor();
				c.setId(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setDireccion(rs.getString(3));
				c.setCorrero(rs.getString(4));
				c.setCodigo_postal(rs.getString(5));
				c.setFax(rs.getString(6));
				c.setNombre_vendedor(rs.getString(7));
				c.setRif(rs.getString(8));
				
			    ResultSet rs2=stm2.executeQuery("select telefono from telefonos where id='"+c.getId()+"'");
			
				while(rs2.next())
				{
					c.setTelefono(rs2.getString(1));
				}
				rs2.close();
				lista.add(c);
			}
			
			rs.close();
		
		return lista;
		
		} catch (SQLException e) {
			e.printStackTrace();
			new Mensaje().error("Error Al Buscar El Proveedor", "Error "+e);
		}
		return null; 
	}
	
	
	public void eliminar(String codigo)
	{
		try{
		Statement stm= Conex.createStatement();
		stm.executeUpdate("delete from proveedores where CODIGO='"+codigo+"'");
		stm.executeUpdate("delete from telefonos where id='"+codigo+"'");
		}catch(Exception e)
		{
			new Mensaje().error("Error al Eliminar el Proveedor", "Error");
		}
	}
	
	public void actualizar(Proveedor pro,String codigo)
	{
		try {
			int canti=0;
			Statement stm= Conex.createStatement();
			ResultSet rs=stm.executeQuery("select CODIGO from proveedores where CODIGO='"+pro.getId()+"'");
			
			while(rs.next())
			{
				canti++;
			}
			
			if(pro.getId().equals(codigo))
			{
			stm.executeUpdate("update proveedores SET CODIGO='"+pro.getId()+"', NOMBRE='"+pro.getNombre()+"',  DIRECCION='"+pro.getDireccion()+"', CORREO='"+pro.getCorrero()+"', CODIGO_POSTAL='"+pro.getCodigo_postal()+"', FAX='"+pro.getFax()+"', NOMBRE_VEND='"+pro.getNombre_vendedor()+"' , RIF='"+pro.getRif()+"' WHERE CODIGO='"+codigo+"'");
			stm.executeUpdate("delete from telefonos where id='"+codigo+"'");
			
			 for(int i =0;i<pro.getTelefono_size();i++){stm.execute("insert into telefonos values('"+pro.getId()+"','"+pro.getTelefono(i)+"')");}
			 new Mensaje().listo("El Proveedor fue Actualizado..","Actualizado");
			 stm.close();
			}
			else
			{
				if(canti>=1)
				{
					new Mensaje().error("El Proveedor ya existe","Error");
				}
				else
				{
					stm.executeUpdate("update proveedores SET CODIGO='"+pro.getId()+"', NOMBRE='"+pro.getNombre()+"',  DIRECCION='"+pro.getDireccion()+"', CORREO='"+pro.getCorrero()+"', CODIGO_POSTAL='"+pro.getCodigo_postal()+"', FAX='"+pro.getFax()+"', NOMBRE_VEND='"+pro.getNombre_vendedor()+"' WHERE CODIGO='"+codigo+"'");
					stm.executeUpdate("delete from telefonos where id='"+codigo+"'");
					
					 for(int i =0;i<pro.getTelefono_size();i++){stm.execute("insert into telefonos values('"+pro.getId()+"','"+pro.getTelefono(i)+"')");}
					 new Mensaje().listo("El Proveedor fue Actualizado..","Actualizado");
					 stm.close();
				}
			}
		} catch (SQLException e){new Mensaje().error("Error Al Actualizar el Proveedor", "Error");}
	}
}