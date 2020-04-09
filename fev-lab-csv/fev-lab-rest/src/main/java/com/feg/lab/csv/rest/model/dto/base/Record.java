package com.feg.lab.csv.rest.model.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Record {

    List<BaseRecord> records;

    public void addRecord(final BaseRecord record) {
        if (records == null) {
            records = new ArrayList<>();
        }
        records.add(record);
    }
}
