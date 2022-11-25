package com.zoho.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * class to get dat
 * a from external file
 * @author Akash R J
 *
 */
public class ExternalFile {
	/**
	 * Method used to return data from property file taking key as argument.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./Docs/Procuratio.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	/**
	 * Method used to return data from excel file.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheet,int cell,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Docs/Zoho CRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell data = wb.getSheet(sheet).getRow(row).getCell(cell);
		DataFormatter d = new DataFormatter();
		String data1 = d.formatCellValue(data);
		return data1;
	}
	/**
	 * To update a cell value in excel
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelData(String sheet,int row,int cell, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Docs/Zoho CRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./Docs/Zoho CRM.xlsx");
		wb.write(fos);
		wb.close();
	}

}
