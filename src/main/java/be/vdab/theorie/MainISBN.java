package be.vdab.theorie;

import util.ISBNException;

public class MainISBN {
    public static void main(String[] args) throws Exception {
        try {
            ISBN.controlISBN(9789027439642L);
        }catch (ISBNException ex){
            ex.printStackTrace();
        }
    }
}
