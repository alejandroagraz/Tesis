package todo_producto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import funciones.Mensaje;
import Todo_recepciones.Recepciones;
import administrador.Conexion;

public class Conexion_productos {

Connection Conex;
	


	public Conexion_productos()
	{
		Conex=Conexion.conect;
	}
	
	
	public LinkedList<String[]> buscar_UBI(String text_buscar)
	{
		
		LinkedList<String[]> lista=new LinkedList<String[]>();
		try{
	
			 Statement stm= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select *from productos WHERE DEPARTAMENTO='"+text_buscar.toUpperCase()+"'");
				int cont =0;
				while(rs.next())
				{
					 cont++;
				    String[] vector=new String[7];	
				
				    vector[0]=rs.getString(1);
				 
				    vector[1]=rs.getString(2);
					vector[2]=rs.getString(3);
					vector[3]=rs.getString(4);
					vector[4]=rs.getString(5);
					vector[5]=rs.getString(8);
					vector[6]=rs.getString(9);
					  
					lista.add(vector);
					
				}
				rs.close();
				stm.close();
				if(cont == 0){return null;}
				return lista;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			new Mensaje().error("Error al bascar en la base de datos listado por Departamento", e.toString());
		}
		return null;
	}
	
	
	public LinkedList<String[]> buscar_stock()
	{
		
		LinkedList<String[]> lista=new LinkedList<String[]>();
		try{
	
			 Statement stm= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select *from productos WHERE CANTIDAD <= stock_min");
				int cont =0;
				while(rs.next())
				{
					 cont++;
				    String[] vector=new String[7];	
				
				    vector[0]=rs.getString(1);
				 
				    vector[1]=rs.getString(2);
					vector[2]=rs.getString(3);
					vector[3]=rs.getString(4);
					vector[4]=rs.getString(5);
					vector[5]=rs.getString(8);
					vector[6]=rs.getString(9);
					  
					lista.add(vector);
					
				}
				rs.close();
				stm.close();
				if(cont == 0){return null;}
				return lista;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			new Mensaje().error("Error al bascar en la base de datos listado por Departamento", e.toString());
		}
		return null;
	}
	
	public boolean Nuevo(Producto pro)
	{
		 try {
			 
			    String hora,hoy;
			    Date fechaactual= new Date();
				SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyy");
				hoy=formato.format(fechaactual);

				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				hora=sdf.format(new Date(System.currentTimeMillis())); 		 
			 
			    Statement stm= Conex.createStatement();
				Statement stm2= Conex.createStatement();
				
				
				ResultSet rs=stm.executeQuery("select CODIGO from productos where CODIGO='"+pro.getCodigo()+"';");
				rs.next();
			if(rs.getRow()>=1)
			{
				new Mensaje().error("El codigo del Producto ya Esta Registrado", "El Producto Existe");
				rs.close();
				stm.close();
				stm2.close();
				return false;
			}
			else
			{
				Recepciones R=new Recepciones();
				R.setCOD_PRO(pro.getCod_proveedor());
				R.setCOD_PROD(pro.getCodigo());
				
				
				
				R.setCANTIDAD(pro.getCantidad());
				
				BigDecimal n1=new BigDecimal(pro.getCosto_compra()).setScale(2, RoundingMode.HALF_EVEN);
				
				R.setCOSTO(""+n1);
				R.setFECHA(hoy);
				R.setHORA(hora);
				
				stm.execute("insert into recepciones (COD_PRO,COD_PROD,FECHA,HORA,COSTO,CANTIDAD) values('"+R.getCOD_PRO()+"','"+R.getCOD_PROD()+"','"+R.getFECHA()+"','"+R.getHORA()+"','"+R.getCOSTO()+"','"+R.getCANTIDAD()+"')");
				
				
				
				
				
			  stm2.execute("insert into productos values('"+pro.getCodigo()+"','"+pro.getNombre()+"','"+pro.getMarca()+"','"+pro.getModelo()+"','"+pro.getDescripcion()+"','"+pro.getCosto_compra()+"','"+pro.getCosto_venta()+"','"+pro.getDepartamento()+"','"+pro.getCantidad()+"','"+pro.getCod_proveedor()+"','"+pro.getFecha()+"','"+pro.getStock_min()+"','"+pro.getStock_max()+"');");
			  
			  stm2.close();
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				new Mensaje().error("Error al Insertar El producto \n Inserte Valores Validos", "Error "+e);
				return false;
			}
		return true;
		
	}
	
	
	
	public void llenar_combo(JComboBox<String> combo)
	{
		 try {
			   Statement stm= Conex.createStatement();
				ResultSet rs=stm.executeQuery("select CODIGO,NOMBRE from proveedores;");
				
				while(rs.next())
				{
					combo.addItem(rs.getString(1)+" ===> "+rs.getString(2));
				}
				rs.close();
				stm.close();
	
			} catch (Exception e) {
				new Mensaje().error("Error al Llenar la lista proveedores", "Error "+e);
			}
	}
	
	
	public void eliminar(String codigo)
	{
		try{
		Statement stm= Conex.createStatement();
		stm.executeUpdate("delete from productos where CODIGO='"+codigo+"'");
		}catch(Exception e)
		{
			new Mensaje().error("Error al Eliminar el Producto", "Error");
		}
		
	}
	
	public void alerta_stock()
	{
		try{
		String list_pro = "Los siguientes productos estan igual o por debajo del stock minimo.\n\n";
		Statement stm= Conex.createStatement();
		ResultSet rs=stm.executeQuery("SELECT * FROM productos WHERE stock_min >= CANTIDAD");
		boolean alert = false;
		while(rs.next())
		{	
			alert = true;
			list_pro += rs.getString(2) + " Cod:" + rs.getString(1) + " Existencia: " + rs.getString(9) + "\n";	
		}
		if(alert){JOptionPane.showMessageDialog(null, list_pro);}
		rs.close();
		stm.close();
		
		}catch(Exception e)
		{
			new Mensaje().error("Error al Eliminar el Producto", "Error");
		}
		
	}
	
	public void actualizar(Producto pro,String codigo)
	{
		try {
			int canti=0;
			Statement stm= Conex.createStatement();
			ResultSet rs=stm.executeQuery("Select CODIGO from productos WHERE CODIGO='"+pro.getCodigo()+"'");
			
			while(rs.next())
			{
				canti++;
			}
			
			if(codigo.equals(pro.getCodigo()))
			{
				stm.executeUpdate("update productos SET CODIGO='"+pro.getCodigo()+"', NOMBRE='"+pro.getNombre()+"',  MARCA='"+pro.getMarca()+"', MODELO='"+pro.getModelo()+"', DESCRIPCION='"+pro.getDescripcion()+"', COSTO_COMPRA='"+pro.getCosto_compra()+"', COSTO_VENTA='"+pro.getCosto_venta()+"', UBICACION='"+pro.getDepartamento()+"', CANTIDAD='"+pro.getCantidad()+"', COD_PROVEEDOR='"+pro.getCod_proveedor()+"' WHERE CODIGO='"+codigo+"'");
				new Mensaje().listo("El Producto Fue Actualiizado..", "Actualizado");
				stm.close();
			}
			else
			{
				if(canti>=1)
				{
					new Mensaje().error("Este Codigo Ya Existe","Ecriba Otro Codigo");rs.close();	
				}
				 else{
					 stm.executeUpdate("update productos SET CODIGO='"+pro.getCodigo()+"', NOMBRE='"+pro.getNombre()+"',  MARCA='"+pro.getMarca()+"', MODELO='"+pro.getModelo()+"', DESCRIPCION='"+pro.getDescripcion()+"', COSTO_COMPRA='"+pro.getCosto_compra()+"', COSTO_VENTA='"+pro.getCosto_venta()+"', UBICACION='"+pro.getDepartamento()+"', CANTIDAD='"+pro.getCantidad()+"', COD_PROVEEDOR='"+pro.getCod_proveedor()+"' WHERE CODIGO='"+codigo+"'");
					 new Mensaje().listo("El Producto Fue Actualiizado..", "Actualizado");	
					 stm.close();
				     }
			}
			
			} catch (SQLException e)
		{
			e.printStackTrace();
		    new Mensaje().error("Error Al Actualizar el Producto", "Error");	
		}
		
	}
	
	public boolean actualizar_cant(String codigo,String cant)
	{
		try {
			   Statement stm= Conex.createStatement();
				stm.executeUpdate("update productos SET CANTIDAD='"+cant+"' WHERE CODIGO='"+codigo+"'");
				
				new Mensaje().listo("El Producto Fue Actualiizado..", "Actualizado");
				stm.close();
				return true;
				
			} catch (SQLException e){
			e.printStackTrace();
		    new Mensaje().error("Error Al Agregar la entrada del Producto", "Error");return false;}
		
	}	
}