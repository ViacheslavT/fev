package com.feg.lab.csv.rest.controller.api;

import com.feg.lab.csv.rest.model.dto.FilesToLoadRS;
import com.feg.lab.csv.rest.model.dto.base.ErrorRS;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Tag(name = "files", description = "Files API.")
public interface FilesApi {

    /**
     * The REST endpoint to retrieve all available files for uploading to database.
     *
     * @return the completed {@link ResponseEntity} filled by links to upload files.
     */
    @Operation(summary = "Get files", description = "Returns list of available files.", tags = { "files" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FilesToLoadRS.class))}),
            @ApiResponse(responseCode = "404", description = "No files found to be processed.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))}),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<FilesToLoadRS> getFiles();


    @Operation(summary = "Upload file", description = "Upload file to a system to be loaded into database.", tags = { "files" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation.", content = {@Content(mediaType = "multipart/form-data", schema = @Schema(implementation = MultipartFile.class))}),
            @ApiResponse(responseCode = "404", description = "Implementation not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))}),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<Void> uploadFile(@RequestParam("file") final MultipartFile file);

    @Operation(summary = "Save file", description = "Saves file to a database.", tags = { "files" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation."),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<Void> saveFile(@RequestParam("file") final String fileName);
}
