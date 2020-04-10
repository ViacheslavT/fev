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

    private List<BaseRecord> records = new ArrayList<>();

    public void addRecord(final BaseRecord record) {
        records.add(record);
    }
}
