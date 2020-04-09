package com.feg.lab.csv.rest.service;

import com.feg.lab.csv.rest.model.dto.FilesToLoadRS;
import com.feg.lab.csv.rest.model.dto.RecordsRS;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public interface FilesService {

    void removeAll();
    FilesToLoadRS getAllFilesToLoad();
    void uploadFile(final MultipartFile file);
    void saveFile(final String fileName);
    RecordsRS getRecordsByHeaders(final List<String> headersNames);
    RecordsRS getRecordsByHeadersAndLimit(int count, final List<String> headersNames);
    RecordsRS getAllRecords();
    RecordsRS getAllRecords(int count);
    RecordsRS getNumericRecords(int count, final List<String> headers);
}
