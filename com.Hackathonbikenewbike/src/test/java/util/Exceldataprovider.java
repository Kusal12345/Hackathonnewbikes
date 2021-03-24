package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Exceldataprovider {
	XSSFWorkbook wb;
	public Exceldataprovider()
	{
		File src=new File("./testdata/EmailIdData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file"+ e.getMessage());
		}
		
	}
	public String getStringdata(int sheetindex,int row,int col) 
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}
	public String getStringdata(String sheetname,int row,int col) 
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericdata(String sheetname,int row,int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
		
}
