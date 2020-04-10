package com.feg.lab.csv.rest.controller;

import com.feg.lab.csv.rest.controller.api.FilesApi;
import com.feg.lab.csv.rest.model.dto.FilesToLoadRS;
import com.feg.lab.csv.rest.service.FilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@CrossOrigin
@RestController
@RequestMapping("files")
@Slf4j
public class FilesController implements FilesApi {

    private final FilesService filesService;

    @Autowired
    public FilesController(final FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilesToLoadRS> getFiles() {
        return ResponseEntity.ok(filesService.getAllFilesToLoad());
    }

    @Override
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> uploadFile(final MultipartFile file) {
        filesService.uploadFile(file);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveFile(@RequestParam("file") @NotBlank final String fileName) {
        filesService.saveFile(fileName);
        return ResponseEntity.ok().build();
    }
}
