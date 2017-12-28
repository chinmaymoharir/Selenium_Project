import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	public static Object[][] getTableArray(String Filepath, String SheetName) throws Exception {
		 String[][] tabArray = null;
		 try {
			 FileInputStream ExcelFile = new FileInputStream(Filepath);
				
				//Access the required test data
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
				
				int startRow = 1;
				int startCol = 1;
				int ci, cj;
				//get total number of rows in sheet
				int totalRows = ExcelWSheet.getLastRowNum();
				int totalCol = 2;
				
				tabArray = new String [totalRows][totalCol];
				ci=0;
				for(int i=startRow;i<=totalRows;i++) {
					cj=0;
					for(int j=startCol;j<=totalCol;j++) {
						tabArray[ci][cj]=getCellData(i,j);
						System.out.println(tabArray[ci][cj]);
					}
				}
		 }
		 catch (FileNotFoundException e) {
			System.out.println("Could not read the excel file");
		}
		 catch (IOException e) {
			 System.out.println("Could not read the excel file");
		}
		return(tabArray);
	}

	private static String getCellData(int RowNum, int ColNum) throws Exception{
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int datatype = Cell.getCellType();
			if (datatype == 3) {
				return "";
			}
				else {
					String CellData = Cell.getStringCellValue();
					return CellData;
				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw(e);
		}

	}
}
