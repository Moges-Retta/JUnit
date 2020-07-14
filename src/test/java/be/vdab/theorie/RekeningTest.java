package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.OnvoldoendeSaldoException;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class RekeningTest {
    private Rekening rekening;
    @BeforeEach
    void beforeEach(){
         rekening = new Rekening();
    }
    @Test
    void hetSaldoVanEenNieuweRekeningIs0€() {
        assertThat(rekening.getSaldo()).isZero();
    }
    @Test
    void nadatJe10€StortIsHetSaldo10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }
    @Test
    void nadatJe10€En1€StortIsHetSaldo11€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
    @Test
    void hetGestorteBedragMagNietNulZijn() {
        assertThatIllegalArgumentException().isThrownBy(
        () -> rekening.stort(BigDecimal.ZERO));
    }
    @Test
    void hetGestortBedragMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> rekening.stort(BigDecimal.valueOf(-1)));
    }
    @Test
    void stortMetNullKanNiet() {
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }
    @Test
    void saldoTeWeinig() {
        assertThatExceptionOfType(OnvoldoendeSaldoException.class)
                .isThrownBy(() -> rekening.haalAf(BigDecimal.TEN));
    }
}