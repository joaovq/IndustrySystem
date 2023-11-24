package utils.converter;


import com.joaovq.utils.converter.BigDecimalConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Locale;

public class BigDecimalConverterTest {
    @Test
    void shouldReturnStringFormattedToLocaleBrazil() {
        // given
        var value = BigDecimal.valueOf(3000.00);
        //when
        String actual = BigDecimalConverter.toBigDecimalFormatLocale(value, Locale.forLanguageTag("pt-BR"));
        //then
        Assertions.assertEquals("3.000",actual);
    }
}
