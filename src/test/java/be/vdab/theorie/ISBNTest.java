package be.vdab.theorie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.ISBNException;

import static org.assertj.core.api.Assertions.*;

public class ISBNTest {
    @Test
    public void bevat13Cijfers(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN(978316148410L));
    }
    @Test
    public void bevat11Cijfers(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN(978316148410L));
    }
    @Test
    public void bevat14Cijfers(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN(97831614841001L));
    }
    @Test
    public void bevatMaxLongCijfers(){
        assertThatExceptionOfType(ISBNException.class).isThrownBy( ()->ISBN.controlISBN(Long.MAX_VALUE));
    }

    @Test
    public void eerste3cijfers977(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN(9773161484100L));
    }
    @Test
    public void eerste3cijfers980(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN(9803161484100L));
    }
    @Test
    public void isbnVoldoetControl(){
        assertThat(ISBN.controlISBN(9789027439642L)).isTrue();
    }
    @Test
    public void isbnVoldoetNietControl(){
        assertThatExceptionOfType(ISBNException.class)
                .isThrownBy( ()->ISBN.controlISBN((9789027439643L)));
    }
    @Test
    void toStringMoetHetNummerTeruggeven() {
        assertThat(new ISBN(9789227439640L)).hasToString("9789227439640");
    }
}
