package com.feg.lab.csv.rest.controller;

import com.feg.lab.csv.rest.controller.api.RecordsApi;
import com.feg.lab.csv.rest.model.dto.RecordsRS;
import com.feg.lab.csv.rest.service.FilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@CrossOrigin
@RestController
@RequestMapping("records")
@Slf4j
public class RecordsController implements RecordsApi {

    private final FilesService filesService;

    @Autowired
    public RecordsController(final FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordsRS> getRecords(@RequestParam(value = "count", required = false) final Integer count,
                                                @RequestParam(value = "headers", required = false) final List<String> headers) {
        if (headers != null && count != null) {
            return ResponseEntity.ok(filesService.getRecordsByHeadersAndLimit(count, headers));
        } else if (headers != null) {
            return ResponseEntity.ok(filesService.getRecordsByHeaders(headers));
        } else if (count != null) {
            return ResponseEntity.ok(filesService.getAllRecords(count));
        } else {
            return ResponseEntity.ok(filesService.getAllRecords());
        }
    }

    @Override
    @GetMapping(value = "/numeric", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordsRS> getNumericRecords(@RequestParam(value = "count", required = false) final int count,
                                                       @RequestParam(value = "headers", required = false) final List<String> headers) {
        return ResponseEntity.ok(filesService.getNumericRecords(count, headers));
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<Void> removeAll() {
        filesService.removeAll();
        return ResponseEntity.ok().build();
    }
}
