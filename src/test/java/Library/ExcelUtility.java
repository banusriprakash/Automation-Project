package Library;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

import static Resource.Common.BrowserActions.log;

public class ExcelUtility {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static int getRowCount(String path, String sheetName) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        } catch (Exception e) {
            System.err.println("Error getting row count: " + e.getMessage());
            return 0;
        }
    }


    public static int getColumnCount(String path, String sheetName) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            return (row == null) ? 0 : row.getLastCellNum();
        } catch (Exception e) {
            System.err.println("Error getting column count: " + e.getMessage());
            return 0;
        }
    }


    public static String getCellValue(String path, String sheetName, int rowNum, int cellNum) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = (row == null) ? null : row.getCell(cellNum);

            return (cell == null) ? "" : cell.toString();
        } catch (Exception e) {
            System.err.println("Error reading cell: " + e.getMessage());
            return "";
        }
    }


    public static void setCellValue(String path, String sheetName, int rowNum, int cellNum, String value) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            row = sheet.getRow(rowNum);
            if (row == null) row = sheet.createRow(rowNum);

            cell = row.getCell(cellNum);
            if (cell == null) cell = row.createCell(cellNum);

            cell.setCellValue(value);

            // Write the changes back to the file
            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
            workbook.close();
        } catch (Exception e) {
            System.err.println("Error setting cell value: " + e.getMessage());
        }
    }


    public static void createRow(String path, String sheetName) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int lastRow = sheet.getLastRowNum();
            sheet.createRow(lastRow + 1);

            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
            workbook.close();
            System.out.println("New row added at index: " + (lastRow + 1));
        } catch (Exception e) {
            System.err.println("Error creating row: " + e.getMessage());
        }
    }
    public static java.util.Map<String, String> getRowData(String path, String sheetName, int rowNum) {
        java.util.Map<String, String> dataMap = new java.util.HashMap<>();
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            XSSFRow headerRow = sheet.getRow(0); // Assumes first row is the header

            for (int i = 0; i < row.getLastCellNum(); i++) {
                String header = headerRow.getCell(i).toString();
                String value = row.getCell(i).toString();
                dataMap.put(header, value);
            }
        } catch (Exception e) {
            log.error("Error creating data map: {}", e.getMessage());
        }
        return dataMap;
    }

    public static int findRowByValue(String path, String sheetName, String targetValue) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                if (row != null && row.getCell(0).toString().equalsIgnoreCase(targetValue)) {
                    return i;
                }
            }
        } catch (Exception e) {
            log.error("Value not found in Excel: " + targetValue);
        }
        return -1; // Return -1 if not found
    }

    public static Object[][] getAllSheetData(String path, String sheetName) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            data = new Object[rows][cols];

            for (int i = 1; i <= rows; i++) { // Skip header
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        } catch (Exception e) {
            log.error("Error converting Excel to Object Array");
        }
        return data;
    }

    public static void setCellResult(String path, String sheetName, int rowNum, int colNum, String status) {
        try (FileInputStream fis = new FileInputStream(path)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cell = row.createCell(colNum);
            cell.setCellValue(status);

            XSSFCellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);

            if (status.equalsIgnoreCase("PASS")) {
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            } else {
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
            }

            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setFont(font);
            cell.setCellStyle(style);

            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
        } catch (Exception e) {
            log.error("Error styling Excel cell");
        }
    }

}