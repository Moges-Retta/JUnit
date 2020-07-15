package be.vdab.theorie.services;

import be.vdab.theorie.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class WinstServiceTest {
    private WinstService winst;
    @Mock
    private KostRepository kostRepository;
    @Mock
    private OpbrengstRepository opbrengstRepository;

    @BeforeEach
    void beforeEach() {
         winst = new WinstService(opbrengstRepository, kostRepository);
    }
    @Test
    void winstIS50VoorOpbrengst100EnKost50(){
        when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(50));
        when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(100));
        assertThat(winst.getWinst()).isEqualByComparingTo(BigDecimal.valueOf(50));
        verify(kostRepository).findTotaleKost();
        verify(opbrengstRepository).findTotaleOpbrengst();
    }
}
