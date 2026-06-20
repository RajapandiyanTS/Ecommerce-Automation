package util;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;

public class ExcelUtils {
    public static Object[][] getSheetDataMatrix(String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testdata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i + 1);
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = row.getCell(j);
//                    data[i][j] = cell.toString();
                    DataFormatter formatter = new DataFormatter();
                    data[i][j] = formatter.formatCellValue(cell);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
