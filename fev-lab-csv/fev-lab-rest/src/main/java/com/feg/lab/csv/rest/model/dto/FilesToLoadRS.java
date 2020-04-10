package com.feg.lab.csv.rest.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FilesToLoadRS {

    private List<Pair<String, String>> files = new ArrayList<>();

    public void addFile(final String fileName) {
        files.add(Pair.of("name", fileName));
    }
}
