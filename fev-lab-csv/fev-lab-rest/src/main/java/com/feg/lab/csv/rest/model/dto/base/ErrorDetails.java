package com.feg.lab.csv.rest.model.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@AllArgsConstructor
@Schema(description = "Object to store error detailed information.")
public class ErrorDetails {

    /** Contains date and time stamp for generated error. */
    @Schema(description = "The time stamp of error object creation.")
    private LocalDateTime timestamp;
    /** The unique major error code to be used by third party services. Intended to determine exact error. */
    @Schema(description = "The unique error code to be used for UI mappings or to identify group of errors. Examples 1,6,7...", example = "3")
    private int code;
    /** Sort message for the error. */
    @Schema(description = "The short message to identify common cause", example = "Not found.")
    private String message;
    /** Detailed message for the error, can be used for debug purposes. */
    @Schema(description = "The detailed message to identify root cause", example = "Current operation is not supported.")
    private String detailedMessage;
}
