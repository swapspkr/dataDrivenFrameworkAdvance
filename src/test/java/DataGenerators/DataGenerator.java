package DataGenerators;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {

	static XSSFWorkbook excelWorkbook;
	static XSSFSheet excelSheet;
	static XSSFRow row = null;
	static XSSFCell cell = null;
	
	@DataProvider()
	public static Object[][] readExcel(String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

		excelWorkbook = new XSSFWorkbook(file);
		// Read sheet inside the workbook by its name
		excelSheet = excelWorkbook.getSheet(sheetName); //Your sheet name
		// Find number of rows in excel file

		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
		int colCount = excelSheet.getRow(0).getLastCellNum();

		
		Object data[][] = new Object[rowCount-1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) 
		{
			for (int cNum = 0; cNum < colCount; cNum++) 
			{
				//System.out.print(getCellData(sheetName, cNum,rNum) + " "); // Your sheet name
				data[rNum - 2][cNum] = getCellData(sheetName, cNum, rNum); //Your sheet name
			}
			System.out.println();
		}
		return data;
	}

	public static String getCellData(String sheetName, int colnum, int rownum) {
		try {

			if (rownum <= 0)
				return "";

			excelSheet = excelWorkbook.getSheet(sheetName);

			XSSFRow row = excelSheet.getRow(rownum - 1);

			cell = row.getCell(colnum);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rownum + " or column " + colnum + " does not exist in xls";
		}

	}
}
