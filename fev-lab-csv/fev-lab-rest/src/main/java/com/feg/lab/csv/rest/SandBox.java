package com.feg.lab.csv.rest;

import com.feg.lab.csv.rest.exceptions.ClientInternalException;
import com.feg.lab.csv.rest.model.dto.base.BaseRecord;
import com.feg.lab.csv.rest.model.dto.base.Record;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public class SandBox {

    private static final String fileName = "example_small.csv";
    private static final String fileName2 = "example.csv";

    public static void main(String[] args) throws Exception {
        List<Record> records = new ArrayList<>();
        Record record = new Record();
        BaseRecord baseRecord = new BaseRecord();
        baseRecord.setName("DATE_REC");
        record.addRecord(baseRecord);
        baseRecord = new BaseRecord();
        baseRecord.setName("TMOD_REC");
        record.addRecord(baseRecord);
        records.add(record);
        //System.out.println(records);
        List<String> criteria = new ArrayList<>();
        criteria.add("TMOD_REC");
        //criteria.add("DATE_REC");
        /*System.out.println(records.get(0).getRecords());
        List<BaseRecord> baseRecords = records.get(0).getRecords().stream().filter(rec -> criteria.contains(rec.getName())).collect(Collectors.toList());*/
        System.out.println(records);
        List<Record> filtered = records.stream().peek(r -> r.setRecords(r.getRecords().stream().filter(rec -> criteria.contains(rec.getName())).collect(Collectors.toList()))).collect(Collectors.toList());
        System.out.println(filtered);
        /*List<Record> list = readAll(fileName);
        for (Record record: list) {
            System.out.println(record);
        }*/
    }

    public static List<Record> readAll(final String fileName) throws Exception {
        File file;
        try {
            file =  ResourceUtils.getFile(
                    "classpath:data/csv/" + fileName);
        } catch (FileNotFoundException e) {
            throw new ClientInternalException(e.getLocalizedMessage());
        }
        InputStreamReader targetStream = new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1);
        CSVReader csvReader = new CSVReader(targetStream);
        String[] line;
        List<String[]> headersList = new ArrayList<>();
        List<Record> records = new ArrayList<>();
        while ((line = csvReader.readNext()) != null) {
            long linesRead = csvReader.getLinesRead();
            if (linesRead == 1) {
                for (String header: line) {
                    String[] headers = new String[2];
                    headers[0] = header;
                    headersList.add(headers);
                }
            } else if (linesRead == 2) {
                for (int i = 0; i < line.length; i++) {
                    headersList.get(i)[1] = (line[i]);
                }
            } else {
                Record record = new Record();
                for (int i = 0; i < line.length; i++) {
                    String value = line[i];
                    String[] header = headersList.get(i);
                    BaseRecord baseRecord = new BaseRecord();
                    baseRecord.setName(header[0]);
                    baseRecord.setMeasure(header[1]);
                    baseRecord.setValue(value);
                    baseRecord.setNumeric(NumberUtils.isCreatable(value));
                    record.addRecord(baseRecord);
                }
                records.add(record);
            }
        }
        targetStream.close();
        csvReader.close();
        return records;
    }
}
