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
public class ErrorRS {

    /** The list of errors occurs. */
    @Schema(description = "The wrapper array to store error details.")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDetails> errors = new ArrayList<>();

    /** The list of errors occurs. */
    @Schema(description = "The wrapper array to store warnings details.")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDetails> warnings = new ArrayList<>();
}
