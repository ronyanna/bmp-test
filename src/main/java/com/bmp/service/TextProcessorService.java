package com.bmp.service;

import com.itextpdf.layout.property.TextAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TextProcessorService  {


    public Map<String, Object> findTextCount(Map<String, Object> data) {
        List<String> text= (List<String>) data.get("searchText");
        Map<String, Long> counts =
                text.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
       // Object[] objectArray = counts.entrySet().toArray();
        Map<String,Object> response=new HashMap<>();
        response.put("counts",counts);
        return response;

    }

    public byte[] findWordCountAndWriteInCsv(Map<String, Object> dataTask) throws IOException {
        String str = (String) dataTask.get("searchText");
        List <String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Map <String, Integer > wordCounter = list.stream()
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Word Count");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        Cell[] cells = addCell(row, new ReportField(4, TextAlignment.LEFT, 0, "Word Count"));
        for(String columnHeading:wordCounter.keySet())
        {
            addCell(row, new ReportField(ReportFieldType.LABEL, 1, "LIGHT_GRAY", columnHeading));
        }
        row = sheet.createRow(rowNum++);
        for(Integer columnValues:wordCounter.values())
        {
            addCell(row, new ReportField(ReportFieldType.LABEL, 1, "LIGHT_GRAY", String.valueOf(columnValues)));
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            workbook.write(baos);
            workbook.close();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cell[] addCell(Row row, ReportField field) throws IOException {
        short index = (short) Math.max(row.getLastCellNum(), 0);
        for (String token : field.getFields()) {
            Cell cell = row.createCell(index++);
            cell.setCellValue(token);
        }
        return null;
    }
}
