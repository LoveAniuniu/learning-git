package Util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ExcelUtil {
    //java读取excel的两种方式poi(xls和xlsx)、jxl(xls)
    public static Object[][] getTestData(String filePath,String fileName,String sheetName) throws IOException {
        File file = new File(filePath+"/"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        if(fileName.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }else if(fileName.endsWith(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        //获取行数
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //System.out.println(rowCount);
        //获取列数
        //int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] result = new Object[rowCount][];
        //i=1,从第2行取参数（第一行是表头）
        for(int i=1;i<=rowCount;i++){
            Row row=sheet.getRow(i);
            //最后一个空格所在的列数；
            //区分这两个参数：row.getLastCellNum();   row.getPhysicalNumberOfCells();
            String[] field = new String[row.getLastCellNum()];
            for (int j=0;j<field.length;j++){
                Cell cell = row.getCell(j);
                if(cell!=null){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                   //得到单元格中的值
                    field[j] = cell.getStringCellValue();
                }else {
                    field[j]=null;
                }
            }
            result[i-1]=field;
        }
        return result;
    }

    //方法二
    public static Object[][] getTestData2(String filePath,String fileName,String sheetName) throws IOException {
        File file = new File(filePath+"/"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        if(fileName.endsWith(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }else if(fileName.endsWith(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheet(sheetName);
        //获取行数
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //System.out.println(rowCount);
        //获取列数
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] result = new Object[rowCount][colCount];
        for(int i=1;i<=rowCount;i++){
            Row row=sheet.getRow(i);
            //最后一个空格所在的列数；
            //区分这两个参数：row.getLastCellNum();   row.getPhysicalNumberOfCells();
            for (int j=0;j<result[i-1].length;j++){
                Cell cell = row.getCell(j);
                if(cell!=null){
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    result[i-1][j] = row.getCell(j).getStringCellValue();
                }else {
                    result[i-1][j]=null;
                }
            }
        }
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        Object[][] result = getTestData2("testData","test.xls","Sheet1");
//        for (Object[] obj:result){
//            System.out.println(Arrays.toString(obj));
//        }
//    }

}
