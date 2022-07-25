package administradorUsers.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import administradorUsers.enums.EntityEnum;
import administradorUsers.enums.MethodsEnum;



public class UtilsLogs {

	private static String pattern = "######.###";
	private static DecimalFormat decimalFormatBD = new DecimalFormat(pattern);
	private static SimpleDateFormat formatHoraSql = new SimpleDateFormat("HH:mm:ss");

	public static Logger getLogger(String className) {
		Logger logger = Logger.getLogger(className);
		logger.setLevel(Level.FINE);
		return logger;
	}
	
	public static String getInfo(MethodsEnum metodo , EntityEnum entity ,  Object obj ) {
		String out = "";
		
		try {
			out = " :: METHODO :: "+ metodo.getValueName() +" ::ENTIDAD:: "+entity.name() +" ::INPUT:: "+ UtilGson.SerializeObjet( obj);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return out;
	}


}
