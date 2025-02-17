package com.easydoers.employeeservice.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.YearMonth;

@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, String> {

    @Override
    public String convertToDatabaseColumn(YearMonth attribute) {
        return (attribute != null) ? attribute.toString() : null; // Convert "2025-03"
    }

    @Override
    public YearMonth convertToEntityAttribute(String dbData) {
        return (dbData != null && !dbData.isEmpty()) ? YearMonth.parse(dbData) : null;
    }
}
