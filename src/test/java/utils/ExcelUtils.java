package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    /**
     * This method is to set the File path and to open the Excel file Pass Excel
     * Path and SheetName as Arguments to this method
     *
     * @param Path
     * @throws Exception
     */
    public static void setExcelFile(String Path) throws Exception {

        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
    }

    /**
     * This method is to read the test data from the Excel cell In this we are
     * passing Arguments as Row Num, Col Num & Sheet Name
     *
     * @param RowNum
     * @param ColNum
     * @param SheetName
     * @return String
     * @throws Exception
     */
    public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }
    public static void add_Value_InSpecifiedCell__FromExcel(String ExcelPath, String sheetName, int row, int column,
                                                            String specifiedValue) {
        try {
            File file = new File(ExcelPath);
            FileInputStream fis = new FileInputStream(file);
            // Get the workbook instance for XLS file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // Get the specified sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);
            // Create a new cell
            sheet.createRow(row).createCell(column).setCellValue(specifiedValue);
            fis.close();
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}