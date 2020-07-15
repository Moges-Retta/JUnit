package be.vdab.theorie.services;

import be.vdab.theorie.repositories.KostRepository;
import be.vdab.theorie.repositories.OpbrengstRepository;

import java.math.BigDecimal;

public class WinstService {
    private final OpbrengstRepository obrengst;
    private final KostRepository kost;
    WinstService(OpbrengstRepository obrengst,KostRepository kost){
        this.obrengst=obrengst;
        this.kost=kost;
    }
    public BigDecimal getWinst(){
        return obrengst.findTotaleOpbrengst().subtract(kost.findTotaleKost());
    }
}
