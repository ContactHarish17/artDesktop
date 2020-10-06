package utility;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadExcelDemo
{
   public static List excelData = new ArrayList();
    public static FileInputStream fileInputStream = null;
   public static  XSSFWorkbook workbook=null;
   public static  XSSFSheet excelSheet=null;

    public static void OpenExcel(String excelpath) throws FileNotFoundException {

        try {
            fileInputStream = new FileInputStream(excelpath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static List<String> getExcelvaluestoArray(String sheetname) throws IOException
    {
        try {
            // Retrieve the first sheet of the workbook.
            excelSheet = workbook.getSheet(sheetname);
            // Iterate through the sheet rows and cells.
            // Store the retrieved data in an arrayList
            Iterator rows = excelSheet.rowIterator();
            while (rows.hasNext())
            {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List cellData = new ArrayList();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    cellData.add(cell);
                }
                excelData.add(cellData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fileInputStream.close();
        return excelData;
    }

    public static List getvalues()
    {
        List partners = new ArrayList();
        for (int rowNum = 1; rowNum < excelData.size(); rowNum++)
        {
            List list = (List) excelData.get(rowNum);

            for (int cellNum = 0; cellNum < list.size(); cellNum++)
            {

                XSSFCell cell = (XSSFCell) list.get(cellNum);

                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                {
                    //System.out.print(cell.getRichStringCellValue().getString() + " ");
                    partners.add(cell.getRichStringCellValue().getString());
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                {
                    //System.out.print(cell.getNumericCellValue() + " ");
                    int number = (int) cell.getNumericCellValue();
                    partners.add(number);
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN)
                {
                    //System.out.println(cell.getBooleanCellValue() + " ");
                    partners.add(cell.getBooleanCellValue());
                }
            }
            System.out.println("");
        }
        return partners;
    }

    public static List excelvalues(int sheetnumber)
    {
        try {
            // Retrieve the first sheet of the workbook.
            excelSheet = workbook.getSheetAt(sheetnumber);

            int sheetcount = workbook.getNumberOfSheets();
            System.out.println("the number of sheets are " + sheetcount);


//            for(int i=0;i<sheetcount;i++) {
//             System.out.println("The sheet names are " +workbook.getSheetName(i));
//             //   System.out.println("the sheet index are "+ workbook.getSheetName(i));
//            }

            // Iterate through the sheet rows and cells.
            // Store the retrieved data in an arrayList
            Iterator rows = excelSheet.rowIterator();
            while (rows.hasNext())
            {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List cellData = new ArrayList();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    cellData.add(cell);
                }
                excelData.add(cellData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        List partners = new ArrayList();
        for (int rowNum = 1; rowNum < excelData.size(); rowNum++)
        {
            List list = (List) excelData.get(rowNum);

            for (int cellNum = 0; cellNum < list.size(); cellNum++)
            {

                XSSFCell cell = (XSSFCell) list.get(cellNum);

                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                {
                    //System.out.print(cell.getRichStringCellValue().getString() + " ");
                    partners.add(cell.getRichStringCellValue().getString());
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                {
                    //System.out.print(cell.getNumericCellValue() + " ");
                    int number = (int) cell.getNumericCellValue();
                    partners.add(number);
                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN)
                {
                    //System.out.println(cell.getBooleanCellValue() + " ");
                    partners.add(cell.getBooleanCellValue());
                }
            }
            System.out.println("");
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partners;

    }




//    public static void main(String argd[]) throws IOException {
//        getExcelvaluestoArray(Constant.ExcelFilepath,Constant.contactSheetName);
//        List valuespartner = getvalues();
//        for(int i=0;i<valuespartner.size();i++)
//        {
//            System.out.println("the values = " + valuespartner.get(i));
//        }
//
//    }
}

