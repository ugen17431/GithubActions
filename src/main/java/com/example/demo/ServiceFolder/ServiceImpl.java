package com.example.demo.ServiceFolder;

import com.example.demo.model.Info;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl {

    static String[] HEADERs = { "Id", "Employee Name", "Company Name", "Salary" };
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public ByteArrayInputStream generateExcel() throws IOException {
        int rowIndex = 0;
        List<Info> infoList = new ArrayList<>();
        for(int i=1 ;i<10 ; i++) {
            Info info = new Info(i, "emp"+i, "cmp"+i, i*1000.0);
            infoList.add(info);
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row headerRow = sheet.createRow(rowIndex);
        for(int i=0;i<HEADERs.length;i++)
        {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(HEADERs[i]);
        }
        for(Info info: infoList) {
            rowIndex++;
            Row row = sheet.createRow(rowIndex);
            row.createCell(0).setCellValue(info.getId());
            row.createCell(1).setCellValue(info.getEmpName());
            row.createCell(2).setCellValue(info.getCompanyName());
            row.createCell(3).setCellValue(info.getSalary());
        }
        workbook.getSheet("sheet1").setColumnHidden(0, true);
        ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        workbook.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
