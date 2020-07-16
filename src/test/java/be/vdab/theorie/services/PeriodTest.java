package be.vdab.theorie.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PeriodTest {
    @Test
    @DisplayName("1Jan 2014 is before 1 Feb 2014")
    void KomtNietNa(){
        assertThat(Period.KomtNa(new Period(LocalDate.of(2014, 1, 1)
                ,(LocalDate.of(2014, 2, 1))))).isFalse();
    }
    @Test
    @DisplayName("1Feb 2014 is before 1 Jan 2014")
    void KomtNa(){
        assertThat(Period.KomtNa(new Period(LocalDate.of(2014, 2, 1)
        ,(LocalDate.of(2014, 1, 1))))).isTrue();
    }
    @Test
    @DisplayName("Null Van")
    void NullVanKomtNa(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->Period.KomtNa(new Period(null,
                        (LocalDate.of(2014, 1, 1))))
        );
    }
    @Test
    @DisplayName("Null tot")
    void NullTotKomtNa(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->Period.KomtNa(new Period(LocalDate.of(2014, 2, 1),null)));
    }

    @Test
    @DisplayName("1Jan 2014 overlapt met 2 Jan 2014")
    void overlapingDatum(){
        LocalDate start1 = LocalDate.of(2014, 1, 1);
        LocalDate end1 = LocalDate.of(2014, 3, 31);
        LocalDate start2 = LocalDate.of(2014, 2, 1);
        LocalDate end2 = LocalDate.of(2014, 1, 1);
        assertThat(Period.OverlptMet(new Period(start1,end1),new Period(start2,end2))).isTrue();
    }
    @Test
    @DisplayName("1Feb 2014 is before 1 Jan 2014")
    void GeenOverlapingDatum(){
        LocalDate start1 = LocalDate.of(2014, 1, 1);
        LocalDate end1 = LocalDate.of(2014, 3, 31);
        LocalDate start2 = LocalDate.of(2014, 4, 1);
        LocalDate end2 = LocalDate.of(2014, 5, 1);
        assertThat(Period.OverlptMet(new Period(start1,end1),new Period(start2,end2))).isFalse();
    }
    @Test
    @DisplayName("Gelijk Datum overlapen")
    void DezelfdeDatum(){
        LocalDate start1 = LocalDate.of(2014, 1, 1);
        LocalDate end1 = LocalDate.of(2014, 3, 31);
        LocalDate start2 = LocalDate.of(2014, 1, 1);
        LocalDate end2 = LocalDate.of(2014, 3, 31);
        assertThat(Period.OverlptMet(new Period(start1,end1),new Period(start2,end2))).isTrue();
    }
}