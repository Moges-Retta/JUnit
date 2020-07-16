package be.vdab.theorie.services;

import java.time.LocalDate;

public class Period {
    private final LocalDate van;
    private final LocalDate tot;
    public Period(LocalDate van,LocalDate tot){
        if(van==null||tot==null){
            throw new IllegalArgumentException();
        }
        this.van=van;
        this.tot=tot;
    }
    public static boolean KomtNa(Period period1){
        return period1.van.isAfter(period1.tot);
    }
    public static boolean OverlptMet(Period period1,Period period2){
        return period1.van.compareTo(period2.tot)<=0&&
                period1.tot.compareTo(period2.van)>=0;
    }
}
