package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import  org.apache.poi.EncryptedDocumentException;

public class Excel {
	public static String getData(String path,String sheet,int r,int c)
		{
		  String v = "";
			try {
				Workbook  wb = WorkbookFactory.create(new FileInputStream(path));
				v = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
			}
			catch(Exception e)
			{
			}
		return v;
	}
}

