package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {
    private Veiling veiling;
    @BeforeEach
    void beforeEach(){
        veiling = new Veiling();
    }
    @Test
    void nogGeenBodIsBodZero() {
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void erresteBodisHoogsteBod() {
        veiling.doeBod(1000);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo(1000);
    }

    @Test
    void bodBedragIsHoogsteBod() {
        veiling.doeBod(20);
        veiling.doeBod(200);
        veiling.doeBod(2000);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo(2000);
    }
}