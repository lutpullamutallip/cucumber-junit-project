package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    String filepath = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");
        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(200000);
        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(110000);
        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(135000);
        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(125000);

        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")) {
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");
            }
        }


        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);

        for (int i = 0; i < 10; i++) {
            System.out.println("Jenny is the best");
        }


        outputStream.close();
        workbook.close();
        fileInputStream.close();
    }

}


