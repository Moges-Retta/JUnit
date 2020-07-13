import be.vdab.theorie.Artikel;
import be.vdab.theorie.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtikelTest {
    @Test
    @DisplayName(" test of de getPrijsExclusiefBtw geeft de juiste bigdecimal value")
    void geeftPrijsAlsBigDecimal() {
        assertThat(new Artikel(BigDecimal.ONE,BigDecimal.valueOf(75)).getPrijsInclusiefBtw())
                .isEqualByComparingTo("1.75");
    }
    @Test
    @DisplayName(" test of de getBtwPercentage geeft de juiste bigdecimal value")
    void geeftBtwAlsBigDecimal() {
        assertThat(new Artikel(BigDecimal.ONE,BigDecimal.valueOf(75)).getBtwPercentage())
                .isEqualByComparingTo("75");
    }
}
