package org.ieti.MihocRebeca;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class FileUtils {

    public static XSSFWorkbook readFile(String path) throws IOException {
        return new XSSFWorkbook(path);
    }

}
