package dataDriven;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class excel {
    public static ExcelReader excel = null;

    // This would run as a single test though it is 3 tests (Running 3 data/rows set in excel)
    @Test
    public void getExcel() throws IOException
    {
        FileInputStream fis=new FileInputStream("C:/rahulShetty/excelDataProviderRahulShetty/src/main/resources/excelDriven.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object data[][]=new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++)
        {
            System.out.println("outer loop started");
            row=sheet.getRow(i+1);
            for(int j=0;j<colCount;j++)
            {
                System.out.println(row.getCell(j));
            }
            System.out.println("outer loop Ended");
        }
    }
}
