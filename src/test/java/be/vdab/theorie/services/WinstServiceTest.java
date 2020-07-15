package be.vdab.theorie.services;

import be.vdab.theorie.repositories.KostRepositoryStub;
import be.vdab.theorie.repositories.OpbrengstRepositoryStub;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinstServiceTest {
    WinstService winst = new WinstService(new OpbrengstRepositoryStub(),
            new KostRepositoryStub());
    @Test
    void winstIS50VoorOpbrengst100EnKost50(){
        assertThat(winst.getWinst()).isEqualByComparingTo(BigDecimal.valueOf(50));
    }
}
