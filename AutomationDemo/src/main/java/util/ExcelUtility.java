package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility extends BaseTest {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	public static Object[][] getExcelData(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 1;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			// you can write a function as well to get Column count

			int totalCols = 2;

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j <= totalCols; j++, cj++) {

					tabArray[ci][cj] = getCellData(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception

	{

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;

			int ci = 0, cj = 0;

			int totalRows = 1;

			int totalCols = 2;

			tabArray = new String[totalRows][totalCols];

			for (int j = startCol; j <= totalCols; j++, cj++)

			{

				tabArray[ci][cj] = getCellData(iTestCaseRow, j);

				System.out.println(tabArray[ci][cj]);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			}

			else {

				String CellData = Cell.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;

		try {

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");

			value = value.substring(posi + 1);

			return value;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;

		try {

			int rowCount = ExcelUtility.getRowUsed();

			for (i = 0; i < rowCount; i++) {

				if (ExcelUtility.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

					break;

				}

			}

			return i;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowUsed() throws Exception {

		try {

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

	public static int getrowIndex(String filepath, String workbookname, String sheetname, String strvalue)
			throws IOException {

		FileInputStream file = new FileInputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetname);
		boolean check = true;
		int i = 1;
		while (check) {
			Row = ExcelWSheet.getRow(i);
			String Cellvalue = Row.getCell(0).getStringCellValue();
			if (Cellvalue.equals(strvalue)) {
				check = false;
			} else {
				i = i + 1;
			}
		}
		return i;

	}

	public static  LinkedHashMap<String, String> getrowdata(String filepath, String workbookname, String sheetname,
			int rowindex) throws Exception {
		FileInputStream file = new FileInputStream(new File(filepath + "/" + workbookname + ".xlsx"));
		ExcelWBook = new XSSFWorkbook(file);
		ExcelWSheet = ExcelWBook.getSheet(sheetname);
		Row=ExcelWSheet.getRow(rowindex);
		XSSFRow headerRow=ExcelWSheet.getRow(0);
		LinkedHashMap<String,String>data=new LinkedHashMap<String,String>();
		int firstcell=headerRow.getFirstCellNum();
		int lastcell=headerRow.getLastCellNum();
		XSSFCell cell1=headerRow.getCell(firstcell);
		XSSFCell cell2=Row.getCell(firstcell);
		
		for(int i=firstcell;i<lastcell;i++)
		{
			cell1=headerRow.getCell(i);
			cell2=Row.getCell(i);
			String headerValue=cell1.getStringCellValue();
			String fieldValue;
			if(cell2==null)
			{
				fieldValue="";
			}
			else
			{
				fieldValue=cell2.getStringCellValue();
			}
			data.put(headerValue,fieldValue);
			}
		file.close();
		return data;
	}
}
