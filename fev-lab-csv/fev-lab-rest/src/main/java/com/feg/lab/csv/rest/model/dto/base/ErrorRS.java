package com.feg.lab.csv.rest.model.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@Schema(description = "Base DTO  response object which contains meta information such as errors and warnings.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorRS {

    /** The list of errors occurs. */
    @Schema(description = "The wrapper array to store error details.")
    private List<ErrorDetails> errors = new ArrayList<>();

    /** The list of errors occurs. */
    @Schema(description = "The wrapper array to store warnings details.")
    private List<ErrorDetails> warnings = new ArrayList<>();
}
