package administrador; 

public class Usuarios { //inicio  clase usuario

	 private String  xusuario;
	private String xclave;
	private String xclaveconfg;
	
public String getXclaveconfg() {
		return xclaveconfg;
	}

	public void setXclaveconfg(String xclaveconfg) {
		this.xclaveconfg = xclaveconfg;
	}

public	Usuarios() // inicio funcion Usuario
{
	this.xclave=""; 
	this.xusuario="";
} // fin funcion Usuario

public String getXusuario() { // inicio metodo get Xusuario
	return xusuario; // retorna xusuario
} // fin metodo get Xusuario

public void setXusuario(String xusuario) { // inicio metodo set usuario
	this.xusuario = xusuario;
} // fin metodo set usuario

public String getXclave() { // inicio metodo get Xclave
	return xclave; // retorna xclave 
} // fin metodo get Xclave

public void setXclave(String xclave) { // inicio metodo set Xclave
	this.xclave = xclave;
} // fin metodo set Xclave

} // fin clase usuario
