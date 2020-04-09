package com.feg.lab.csv.rest.model.dto.base;

import lombok.Getter;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Getter
public enum Measure {

    DATE("Date", "TT.MM.JJJJ", false);

    private final String title;
    private final String pattern;
    private final boolean isNumeric;

    Measure(final String title, final String pattern, final boolean isNumeric) {
        this.title = title;
        this.pattern = pattern;
        this.isNumeric = isNumeric;
    }

    public static Measure fromTitle(final String value) {
        for (Measure measure: Measure.values()) {
            if (measure.title.equals(value)) {
                return measure;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
