package be.vdab.theorie.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class WordTellerTest {

    @Test
    @DisplayName("zonder spatie of koma is 1 woord")
    public void eenWord(){
      assertThat(new WordTeller("ABCD").aantalWorden()).isEqualByComparingTo(1);
    }
    @Test
    @DisplayName("twee worden met een spatie  2 woord")
    public void tweeWord(){
        assertThat(new WordTeller("ABCD EFGH").aantalWorden()).isEqualByComparingTo(2);
    }
    @Test
    @DisplayName("2 woorden met 2 spatie is 2 woord")
    public void tweeWordMet2Spaties(){
        assertThat(new WordTeller("ABCD  EFGH").aantalWorden()).isEqualByComparingTo(2);
    }

    @Test
    @DisplayName("leeg string heeft nul woord")
    public void leegString(){
       // assertThatIllegalArgumentException()
                //.isThrownBy(() -> new WordTeller("").aantalWorden());
        assertThat(new WordTeller("").aantalWorden()).isEqualByComparingTo(0);
    }
    @Test
    @DisplayName("2 worden en koma is 2")
    public void metKoma(){
        assertThat(new WordTeller("ABCD,EFGH").aantalWorden()).isEqualByComparingTo(2);
    }
    @Test
    @DisplayName("3 worden en koma en spatie is 3")
    public void metKomaEnSpatie(){
        assertThat(new WordTeller("ABCD,EFGH HIJK").aantalWorden()).isEqualByComparingTo(3);
    }
    @Test
    void eenNullWaardeKanNiet() {
        assertThatNullPointerException()
                .isThrownBy(() -> new WordTeller(null).aantalWorden());
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", " ", ",", ",,,", " , ,, "})
    void bevat0Woorden(String tekst) {
        assertThat(new WordTeller(tekst).aantalWorden()).isZero();
    }
}
