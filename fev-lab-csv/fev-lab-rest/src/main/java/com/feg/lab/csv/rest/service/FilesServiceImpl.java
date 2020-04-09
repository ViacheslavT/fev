package com.feg.lab.csv.rest.service;

import com.feg.lab.csv.rest.exceptions.ClientInternalException;
import com.feg.lab.csv.rest.exceptions.ClientNotSupportedException;
import com.feg.lab.csv.rest.model.dto.FilesToLoadRS;
import com.feg.lab.csv.rest.model.dto.RecordsRS;
import com.feg.lab.csv.rest.model.dto.base.BaseRecord;
import com.feg.lab.csv.rest.model.dto.base.Record;
import com.feg.lab.csv.rest.repository.FilesRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Service
@Slf4j
public class FilesServiceImpl implements FilesService {

    @Value("${files.path.to-load}")
    private String filesToLoadPath;

    private final FilesRepository filesRepository;

    @Autowired
    public FilesServiceImpl(final FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @Override
    public FilesToLoadRS getAllFilesToLoad() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(filesToLoadPath);
        String path = Objects.requireNonNull(url).getPath();
        File[] files = new File(path).listFiles();
        FilesToLoadRS response = new FilesToLoadRS();
        for (File file: Objects.requireNonNull(files)) {
            response.addFile(file.getName());
        }
        return response;
    }

    @Override
    public void uploadFile(MultipartFile file) {
        //TODO: to be implemented if required
        throw new ClientNotSupportedException("Upload file operation is not supported yet");
    }

    @Override
    public void saveFile(String fileName) {
        try {
            filesRepository.saveAll(readFile(fileName));
        } catch (IOException e) {
            log.error("Exception during reading of a file.", e);
            throw new ClientInternalException(e.getLocalizedMessage());
        } catch (CsvValidationException e) {
            log.error("Not valid CSV file.", e);
            throw new ClientInternalException(e.getLocalizedMessage());
        }
    }

    @Override
    public RecordsRS getRecordsByHeaders(List<String> headersNames) {
        RecordsRS response = new RecordsRS();
        response.setRecords(filesRepository.returnByHeaders(headersNames));
        return response;
    }

    @Override
    public RecordsRS getRecordsByHeadersAndLimit(int count, List<String> headersNames) {
        RecordsRS response = new RecordsRS();
        response.setRecords(filesRepository.returnByHeadersAndLimit(headersNames, count));
        return response;
    }

    @Override
    public RecordsRS getAllRecords() {
        RecordsRS response = new RecordsRS();
        response.setRecords(filesRepository.findAll());
        return response;
    }

    @Override
    public RecordsRS getAllRecords(int count) {
        RecordsRS response = new RecordsRS();
        response.setRecords(filesRepository.findAll(count));
        return response;
    }

    @Override
    public RecordsRS getNumericRecords(int count) {
        RecordsRS response = new RecordsRS();
        response.setRecords(filesRepository.returnNumeric(count));
        return response;
    }

    private List<Record> readFile(final String fileName) throws IOException, CsvValidationException {
        InputStreamReader targetStream;
        try {
            final File file =  ResourceUtils.getFile(
                    "classpath:data/csv/" + fileName);
            targetStream = new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1);
        } catch (FileNotFoundException e) {
            log.error("No such file.", e);
            throw new ClientInternalException(e.getLocalizedMessage());
        }
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
