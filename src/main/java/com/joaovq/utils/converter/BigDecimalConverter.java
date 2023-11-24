package com.joaovq.utils.converter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalConverter {
    public static String toBigDecimalFormatLocale(BigDecimal value, Locale locale) {
        return NumberFormat.getNumberInstance(locale).format(value.doubleValue());
    }
}
