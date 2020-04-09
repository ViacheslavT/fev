package com.feg.lab.csv.rest.controller.api;

import com.feg.lab.csv.rest.model.dto.RecordsRS;
import com.feg.lab.csv.rest.model.dto.base.ErrorRS;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Tag(name = "records", description = "Records API.")
public interface RecordsApi {

    @Operation(summary = "Get records", description = "Retrieves records according to passed parameters.", tags = { "records" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecordsRS.class))}),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<RecordsRS> getRecords(@RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "headers", required = false) final List<String> headers);

    @Operation(summary = "Get numeric records objects", description = "Retrieves records according to passed parameters.", tags = { "records" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RecordsRS.class))}),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<RecordsRS> getNumericRecords(@RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "headers", required = false) final List<String> headers);

    @Operation(summary = "Removes records", description = "Removes created records.", tags = { "records" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation."),
            @ApiResponse(responseCode = "500", description = "Any internal error.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRS.class))})
    })
    ResponseEntity<Void> removeAll();
}
