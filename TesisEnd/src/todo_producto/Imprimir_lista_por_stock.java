package todo_producto;

import java.awt.Desktop;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import administrador.Inicio;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import funciones.Mensaje;

public class Imprimir_lista_por_stock

{
	LinkedList<String[]> lista=new LinkedList<String[]>();
	
	public Imprimir_lista_por_stock()
	{
		lista = new Conexion_productos().buscar_stock();
		if(lista!=null){
			try{
			   Conexion_jasperreport sourse= new Conexion_jasperreport();
			   sourse.addlista(lista);
                @SuppressWarnings("deprecation")
                JasperReport reporte = (JasperReport) JRLoader.loadObject("Plantillas" + Inicio.url_sistema + "Listado_Stock.jasper");  
                Map<String, Object> parametros=new HashMap<String,Object>();
                parametros.put("rif",Inicio.c.getRif());
                parametros.put("empresa",Inicio.c.getNombre_empresa());
                parametros.put("telefono1",Inicio.c.getTelefono1());
                parametros.put("telefono2",Inicio.c.getTelefono2());
                parametros.put("telefono3",Inicio.c.getTelefono3());
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, sourse);  
			    JRExporter exporter = new JRPdfExporter();  
			    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
			    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Reportes" + Inicio.url_sistema + "Listado por stock.pdf")); 
			    exporter.exportReport(); 

			    
			    
					File archivo=new File("Reportes" + Inicio.url_sistema + "Listado por stock.pdf");
					Desktop.getDesktop().open(archivo);
					
				}catch(Exception e){
					e.printStackTrace();
					new Mensaje().error("Error en la Impresion el Archivo esta Abierto", "Error");}
		}else{
			new Mensaje().error("No hay Productos en el Rango de Stock","Error");
		}	
	}
}