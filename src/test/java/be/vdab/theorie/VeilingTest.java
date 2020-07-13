package be.vdab.theorie;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VeilingTest {

    @Test
    void nogGeenBodIsBodZero() {
        var veiling = new Veiling();
        assertThat(veiling.getHoogsteBod()).isZero();
    }

    @Test
    void erresteBodisHoogsteBod() {
        var veiling = new Veiling();
        veiling.doeBod(1000);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo(1000);
    }

    @Test
    void bodBedragIsHoogsteBod() {
        var veiling = new Veiling();
        veiling.doeBod(20);
        veiling.doeBod(200);
        veiling.doeBod(2000);
        assertThat(veiling.getHoogsteBod()).isEqualByComparingTo(2000);
    }
}