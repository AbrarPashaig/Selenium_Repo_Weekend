package genericutility;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtility {
	public String getStringDataFromExcel(String SheetName, int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(SheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	}
}
