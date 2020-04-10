package com.feg.lab.csv.rest.model.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseRecord {

    private String name;
    private String measure;
    private String value;
    private boolean numeric;
}
