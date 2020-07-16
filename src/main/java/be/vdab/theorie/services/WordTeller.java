package be.vdab.theorie.services;

import java.util.IllegalFormatException;
import java.util.StringTokenizer;

public class WordTeller {
    private final String zin;

    public WordTeller(String zin) {
        this.zin = zin;
    }
    public int aantalWorden() {
        return new StringTokenizer(zin, " ,").countTokens();
        /*if (zin == null) {
            throw new NullPointerException();
        }else if(zin.equals("")) {
            return 0;
        } else {
            String zin1 = zin;
            if (zin.contains(",")) {
                zin1 = zin.replaceAll(",", " ");
            }
            if (zin1.contains("  ")) {
                zin1 = zin.replaceAll(" {2}", " ");
            }
            if (zin1.contains(".")) {
                zin1 = zin.replaceAll("\\.", "");
            }
            return zin1.split(" ").length;
            //throw  new UnsupportedOperationException();
        }*/
    }
}
