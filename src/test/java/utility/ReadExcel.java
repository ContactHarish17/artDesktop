package utility;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

    static FileInputStream fileInputStream;
    public static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;
    static jxl.Cell cells;
    static XSSFRow Row;


    public static void OpenExcel(String excelpath) throws FileNotFoundException {

        try {
            fileInputStream = new FileInputStream(excelpath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getRowCount(String sheetname) {
        sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getPhysicalNumberOfRows();
        return rowcount;
    }

    public static List<String> getExcelvaluestoArray(String excelfilepath, String sheetname) throws IOException {
        FileInputStream fileInputStream = null;

        // Array List to store the excel sheet data
        List excelData = new ArrayList();
        try {
            // FileInputStream to read the excel file
            fileInputStream = new FileInputStream(excelfilepath);

            // Create an excel workbook
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // Retrieve the first sheet of the workbook.
            XSSFSheet excelSheet = workbook.getSheet(sheetname);

            // Iterate through the sheet rows and cells.
            // Store the retrieved data in an arrayList
            Iterator rows = excelSheet.rowIterator();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List cellData = new ArrayList();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    cellData.add(cell);
                }

                excelData.add(cellData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }


    public static String getCellData(String Sheetname, int row, int col) {
        try {
            sheet = workbook.getSheet(Sheetname);
            cell = sheet.getRow(row).getCell(col);
            if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                return String.valueOf(cell.getNumericCellValue());
            } else {
                return cell.getStringCellValue();
            }

        } catch (Exception e) {
        }
        return "";
    }

    public static Boolean getBooleanData(String Sheetname, int row, int col) {
        try {
            sheet = workbook.getSheet(Sheetname);
            cell = sheet.getRow(row).getCell(col);
            if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType())
            {
               return cell.getBooleanCellValue();
            }

        } catch (Exception e) {
        }
        return true;
    }

    public static void updateExchelSheet(String sheetname, String excelpath, String result, int row, int col) {
        XSSFSheet sheets = workbook.getSheet(sheetname);
        Row = sheets.getRow(row);
        cell = Row.getCell(col, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
        if (cell == null) {
            cell = Row.createCell(col);
            cell.setCellValue(result);
        } else {
            cell.setCellValue(result);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(excelpath);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getOwnerDOB(String sheetname, int row, int col) throws IOException {

        String filename = Constant.ExcelFilepath;
        String cellStringValue = null;

        try (FileInputStream fis = new FileInputStream(filename)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetname);

            // Read a cell the first cell on the sheet.
            XSSFCell cell = sheet.getRow(row).getCell(col);

            DataFormatter dataFormatter = new DataFormatter();
            cellStringValue = dataFormatter.formatCellValue(sheet.getRow(row).getCell(col));
            System.out.println("Is shows data as show in Excel file" + cellStringValue);
        } catch (Exception e) {
        }
        return cellStringValue;


    }


    public static void main(String args[]) {

        try {
            OpenExcel(Constant.ExcelFilepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(getCellData(Constant.activitySheetName, 1, 4));
//        String mobilenumber = getCellData(Constant.activitySheetName, 1, 4);
//        int mobile = Integer.parseInt(mobilenumber.substring(2, mobilenumber.lastIndexOf(".")));
//        System.out.println(mobilenumber.replaceAll("[-+.,%EBDAF]", ""));
//        System.out.println("Year" + mobile);

        int VechileYear = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 4, 1)).intValue();
        System.out.println("The Vehicle year is " + VechileYear);

        System.out.println("The CR number is  " + ReadExcel.getCellData(Constant.createQuoteSheet, 4, 1).replaceAll("[-+.,%EBDAF]", ""));
        System.out.println("The Vehicle year is " + ReadExcel.getCellData(Constant.createQuoteSheet, 4, 3).replaceAll("[-+.,%EBDAF]", ""));

        int NIDvalue = new Double(ReadExcel.getCellData(Constant.createQuoteSheet, 2, 1)).intValue();
     //   enterText(driver, quotePageObjects.ownernationalID, String.valueOf(NIDvalue));
        System.out.println("The CR number is  " + ReadExcel.getCellData(Constant.createQuoteSheet, 2, 1).replaceAll("[-+.,%EBDAF]", ""));
        System.out.println("The Non Saudi " + NIDvalue);


       }

    }





