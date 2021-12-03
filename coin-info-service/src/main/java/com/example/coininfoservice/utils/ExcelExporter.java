package com.example.coininfoservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExcelExporter<T> {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private ObjectMapper mapper;
    private List<T> list;

    // Contain the main header fields in excel file
    private List<String> headerFields;

    // Contain the field names when convert to map
    private List<String> dataFields;

    public ExcelExporter(List<String> headerFields, List<String> dataFields, List<T> list) {
        this.headerFields = headerFields;
        this.dataFields = dataFields;
        this.list = list;
        workbook = new XSSFWorkbook();
        mapper = new ObjectMapper();
    }

    /**
     * Write the header line based on Object field name
     */
    private void writeHeaderLine() {
        sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        int cellPosition = 0;
        for (String field : this.headerFields) {
            createCell(row, cellPosition, field, style);
            cellPosition++;
        }
    }

    /**
     * Write the data line based on Object field value
     */
    private void writeDataLines() {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        int rowCount = 1;
        for (T object : list) {
            Map<String, Object> map = mapper.convertValue(object, Map.class);
            Row row = sheet.createRow(rowCount);
            int cellPosition = 0;
            for (String field : dataFields) {
                createCell(row, cellPosition, map.get(field), style);
                cellPosition++;
            }
            rowCount++;
        }
    }

    /**
     * Create cell based on type of data
     *
     * @param row
     * @param columnCount
     * @param value
     * @param style
     */
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value != null) {
            cell.setCellValue(value.toString());
        } else {
            cell.setCellValue("");
        }
        cell.setCellStyle(style);
    }

    /**
     * Export the excel file
     *
     * @param response
     * @throws IOException
     */
    public void export(HttpServletResponse response, String fileName) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName + "_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
