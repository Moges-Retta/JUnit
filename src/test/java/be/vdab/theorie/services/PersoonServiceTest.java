package be.vdab.theorie.services;

import be.vdab.theorie.repositories.PersoonRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class PersoonServiceTest {
    private PersoonService service;
    /*@BeforeEach
    void beforeEach() {
        //service = new PersoonService();
    }
    @Test
    void deWeddeStandaardAfwijkingIsPositief() throws IOException {
        assertThat(service.standaardAfwijkingWeddes()).isPositive();
    }*/

    @BeforeEach
    void beforeEach() {
        service = new PersoonService(new PersoonRepositoryStub());
    }
    @Test
    void deWeddeStandaardAfwijkingIs2() throws IOException {
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }
}
