package com.jcrafters.commons;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public class FullOffsetDateTimeMapper {

    public static FullOffsetDateTimeMapper INSTANCE = Mappers.getMapper(FullOffsetDateTimeMapper.class);

    private static final DateTimeFormatter OFFSET_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public String asString(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return offsetDateTime.format(OFFSET_DATE_TIME_FORMATTER);
    }

    public OffsetDateTime asOffsetDateTime(String offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return OffsetDateTime.parse(offsetDateTime);
    }

    public String asString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public LocalDate asLocalDate(String date) {
        if (date == null) {
            return null;
        }
        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

}