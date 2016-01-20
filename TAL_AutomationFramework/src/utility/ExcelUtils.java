package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{
			
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
						
			String CellData = getCellValue(Cell);
						
			
			return CellData;

			}catch (Exception e){

			return"";

			}

}


	
	//This method is to write in the Excel cell, Row num and Col num are the parameters

	@SuppressWarnings("static-access")
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

		Row  = ExcelWSheet.getRow(RowNum);

		Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

		if (Cell == null) {

			Cell = Row.createCell(ColNum);

			Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

		// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}

	}

	
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
    	int i;
        try {
    	   int rowCount = ExcelWSheet.getLastRowNum();
            for ( i=0 ; i<rowCount; i++){
    	       if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
    	           break;
    	          }
    	       }
            return i;
        }catch (Exception e){
//    	    Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
            throw(e);
    	   }
        }
	
	
	public static String getCellValue(XSSFCell cell) throws ParseException {
        String cellValue = "";
        //System.out.println("Cell type is:" +cell.getDateCellValue());
        switch (cell.getCellType()) {  
        
            case XSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString();
                //System.out.println("String Cell value is: " +cellValue);
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
            	if (DateUtil.isCellDateFormatted(cell)) {
            		double numericValue = cell.getNumericCellValue();
                    Date beforeformatdate = HSSFDateUtil.getJavaDate(numericValue);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                    cellValue = dateFormat.format(beforeformatdate).toUpperCase();
                    //System.out.println("After Formatting Date Value is:-" +cellValue);
                } else {
	               double numericValue = cell.getNumericCellValue();
	               //System.out.println("Double Number Numeric Value:-" +numericValue);
	               DecimalFormat df = new DecimalFormat("#");
	               df.setMaximumFractionDigits(8);
	               cellValue = df.format(numericValue);
	               //System.out.println("Double Number Cell Value:-" +cellValue);
                }
                break;
           
        }
        
        return cellValue;
    }
	
	
	/*
	public static Date getCellDateValue(XSSFCell cell) {
        Date dateTime = null;
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            double numericValue = cell.getNumericCellValue();
            dateTime = HSSFDateUtil.getJavaDate(numericValue);
        }
        
        return dateTime;
    }*/
	
	
	
	
	
}
