package ExcelReader;
/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelDataDrivenCodeToReadTestData {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	 
	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		 String[][] tabArray = null;
		 try {
			 FileInputStream ExcelFile = new FileInputStream(Path);
				
				//Access the required test data
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
				
				
		 } catch (Exception e) {
			throw(e);
		}
		 
}
	 //This method is used to read test data from excel
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			
		} catch (Exception e) {
			return "";
		}
		}
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception{
		try {
			Row=ExcelWSheet.getRow(RowNum);
			//Cell=Row.getCell(ColNum, Row.RETURN_B)
			Cell=Row.getCell(ColNum);
			if(Cell==null) {
				Cell=Row.createCell(ColNum);
				Cell.setCellValue(Result);
			}else {
				Cell.setCellValue(Result);
			}
			//constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw(e);
		}
	}
}
*/