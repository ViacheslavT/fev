package com.feg.lab.csv.rest.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.feg.lab.csv.rest.model.dto.base.Record;
import lombok.Data;

import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RecordsRS {

    List<Record> records;
}
