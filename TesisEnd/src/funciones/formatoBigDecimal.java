package funciones;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class formatoBigDecimal {
	
	public static BigDecimal stringToBigDecimal(String num)
	{
	BigDecimal money = BigDecimal.ZERO;
	if(!num.isEmpty())
	{
	String formatoValido = num.replace(".", "").replace(",", ".");
	money = new BigDecimal(formatoValido);
	}
	return money;
	}
	public static String bigDecimalToString(BigDecimal big)
	{
	double datoDoubleD = 0;
	//se verifica que sean correctos los argumentos recibidos
	if(big != null)
	datoDoubleD = big.doubleValue();
	
	NumberFormat formatter = new DecimalFormat("#,#00.00");
	return formatter.format(datoDoubleD);
	}//metodo
}