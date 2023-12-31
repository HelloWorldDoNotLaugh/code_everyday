package com.wy.mycode;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/8/7
 */
public class ExcelUtils {

    /**
     * @description 读数据
     * @author yuyang.zhang
     * @date 2023/8/8 12:36
     * @param filePath
     * @return java.util.List<java.util.List<java.lang.String>>
     */
    public static List<List<String>> readData(String filePath) {
        ArrayList<List<String>> results = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));
            Sheet sheet = workbook.getSheetAt(0);

            for (Row cells : sheet) {
                ArrayList<String> result = new ArrayList<>();
                RichTextString first_value = cells.getCell(0).getRichStringCellValue();

                if (null == first_value || !first_value.toString().startsWith("Bug")) {
                    continue;
                }

                result.add(first_value + "_" + cells.getCell(2));
                result.add(cells.getCell(32).getStringCellValue());

                results.add(result);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return results;
    }

    /**
     * @description 追加写入
     * @author yuyang.zhang
     * @date 2023/8/8 12:37
     * @param datas
     * @param filePath
     * @return void
     */
    public static void writeExcel(List<List<String>> datas, String filePath ) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(Files.newInputStream(Paths.get(filePath)));
        Sheet sheet = workbook.getSheetAt(0);

        int rows = 1;

        for (List<String> data : datas) {
            Row row = sheet.createRow(rows++);
            int lineNum = 0;
            for (String str : data) {
                Cell cell = row.createCell(lineNum);
                cell.setCellValue(str);
                lineNum++;
            }
        }

        workbook.write(Files.newOutputStream(Paths.get(filePath)));

    }




    public static void main(String[] args) throws Exception{
        List<List<String>> lists = readData("/Users/td/Downloads/知识图谱缺陷列表（含截图）0804.xlsx");
        String filePath = "/Users/td/code/wy.xlsx";
        writeExcel(lists, filePath);
    }
}
