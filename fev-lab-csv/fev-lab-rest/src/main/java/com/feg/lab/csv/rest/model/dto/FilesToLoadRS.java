package com.feg.lab.csv.rest.model.dto;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Data
public class FilesToLoadRS {

    private List<Pair<String, String>> files;

    public void addFile(final String fileName) {
        if (files == null) {
            files = new ArrayList<>();
        }
        files.add(Pair.of("name", fileName));
    }
}
