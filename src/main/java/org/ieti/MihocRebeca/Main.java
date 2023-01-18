package org.ieti.MihocRebeca;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "./build/resources/main/data.xlsx";
        XSSFWorkbook workbook = FileUtils.readFile(path);

        ExcelService excelService = new ExcelService(workbook);
        String[] headers = excelService.getHeaders();
        String[][] content = excelService.getContent();

        Table tableBuilder = new Table();
        tableBuilder.buildTable(content, headers);



    }

}
