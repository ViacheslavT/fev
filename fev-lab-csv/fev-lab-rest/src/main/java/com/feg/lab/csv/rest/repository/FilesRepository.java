package com.feg.lab.csv.rest.repository;

import com.feg.lab.csv.rest.model.dto.base.Record;

import java.util.List;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
public interface FilesRepository {

    List<Record> findAll();
    List<Record> findAll(final int count);
    void saveAll(final List<Record> records);
    void save(final Record record);
    List<Record> returnByHeaders(final List<String> headersNames);
    List<Record> returnByHeadersAndLimit(final List<String> headersNames, final int count);
    List<Record> returnNumeric(final int count);
}
