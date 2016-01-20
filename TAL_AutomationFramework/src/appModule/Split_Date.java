package appModule;

import java.text.DecimalFormat;
import java.text.ParseException;


public class Split_Date {
	
	public static String Date(String anyDate, int type) throws ParseException{
			
		String cellValue = "";
		
		String[] datesplit = anyDate.split("/");
				
			switch (type) {          
		       case 1:        	
		       	double dayValue = Integer.parseInt(datesplit[0]);
		           DecimalFormat dfDay = new DecimalFormat("#");
		           dfDay.setMaximumFractionDigits(2);
		           cellValue = dfDay.format(dayValue);
		           break;
		       case 2:
		       	cellValue = String.valueOf(datesplit[1]);
		           break;
		       case 3:
		       	double yearValue = Integer.parseInt(datesplit[2]);
		           DecimalFormat dfYear = new DecimalFormat("#");
		           dfYear.setMaximumFractionDigits(4);
		           cellValue = dfYear.format(yearValue);
		           break; 
				}
    
		return cellValue;
		
	}
		
}

