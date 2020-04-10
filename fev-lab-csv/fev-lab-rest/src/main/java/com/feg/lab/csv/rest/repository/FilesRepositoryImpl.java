package com.feg.lab.csv.rest.repository;

import com.feg.lab.csv.rest.model.dto.base.BaseRecord;
import com.feg.lab.csv.rest.model.dto.base.Record;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Repository
public class FilesRepositoryImpl implements FilesRepository {

    private static List<Record> recordsStorage = new ArrayList<>();

    @Override
    public void removeAll() {
        recordsStorage.clear();
    }

    @Override
    public List<Record> findAll() {
        return recordsStorage;
    }

    @Override
    public List<Record> findAll(final int count) {
        return recordsStorage.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public void saveAll(final List<Record> records) {
        recordsStorage.addAll(records);
    }

    @Override
    public void save(final Record record) {
        recordsStorage.add(record);
    }

    @Override
    public List<Record> returnByHeaders(final List<String> headersNames) {
        return recordsStorage.stream().peek(
                record -> record.setRecords(
                        record.getRecords().stream()
                                .filter(rec -> headersNames.contains(rec.getName()))
                                .collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    @Override
    public List<Record> returnByHeadersAndLimit(final List<String> headersNames, int count) {
        return returnByHeaders(headersNames).stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public List<Record> returnNumeric(final List<String> headersNames, int count) {
        List<Record> recordsResult = new ArrayList<>();
        for (Record record: recordsStorage) {
            List<BaseRecord> baseRecords = record.getRecords().stream()
                    .filter(BaseRecord::isNumeric)
                    .filter(rec -> {
                        if (headersNames != null) {
                            return headersNames.contains(rec.getName());
                        } else {
                            return true;
                        }
                    })
                    .collect(Collectors.toList());
            if (!baseRecords.isEmpty()) {
                Record recordResult = new Record();
                recordResult.setRecords(baseRecords);
                recordsResult.add(recordResult);
            }
        }
        if (count > 0) {
            recordsResult = recordsResult.stream().limit(count).collect(Collectors.toList());
        }
        return recordsResult;
    }
}
