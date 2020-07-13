import be.vdab.theorie.Palindrom;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PalindromTest {
    @Test
    @DisplayName("Test of een woord in reverse is tegelijk als de woord ")
    void isEenWoordPalindrom(){
        var palindrom = new Palindrom("lepel");
        assertThat(palindrom.isPalindrom()).isTrue();
    }
    @Test
    @DisplayName("Test of een woord in reverse is tegelijk als de woord ")
    void isEenWoordNietPalindrom(){
        var palindrom = new Palindrom("Moges");
        assertThat(palindrom.isPalindrom()).isFalse();
    }
    @Test
    void eenLegeStringIsEenPalindroom() {
        assertThat(new Palindrom("").isPalindrom()).isTrue();
    }
}
