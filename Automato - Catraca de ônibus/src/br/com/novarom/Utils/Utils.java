package br.com.novarom.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.novaroma.Entity.CardEntity;

public class Utils {
	
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(Msg.DATEFORMAT);
		return sdf.format(cal.getTime());
	}
	
	public static boolean validateNumber (String string) {
		return !string.matches("[0-9]*");
	}
	
}
