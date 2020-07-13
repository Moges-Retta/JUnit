package be.vdab.theorie;

import java.util.ArrayList;
import java.util.Collections;

public class Veiling {
    private int hoogsteBod;
    private final ArrayList<Integer> bods = new ArrayList<>();

    public void doeBod(Integer bod) {
        if(bod>hoogsteBod)
            hoogsteBod = bod;
        // throw new UnsupportedOperationException();
    }

    public Integer getHoogsteBod() {
        return hoogsteBod;
        //throw new UnsupportedOperationException();
    }
}
