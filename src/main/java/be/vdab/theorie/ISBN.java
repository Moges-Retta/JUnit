package be.vdab.theorie;

import util.ISBNException;

public class ISBN {
    private final long isbn;

    public ISBN(long isbn) {
        this.isbn = isbn;
    }

    public static boolean controlISBN(long isbn) {
        var isbnNummer = String.valueOf(isbn);
        var eerst3Cijfers = isbnNummer.substring(0, 3);
        if ((isbnNummer.length() != 13)) {
            throw new ISBNException("< 13 cijfers");
        }
        if (eerst3Cijfers.equals("978") || eerst3Cijfers.equals("979")) {

            var somOneven = 0;
            var someven = 0;
            var countEven = 0;
            var countOnEven = 1;
            for (var i = 0; i < 6; i++) {
                someven += Integer.parseInt(String.valueOf(isbnNummer.charAt(countEven)));
                countEven += 1;

                somOneven += Integer.parseInt(String.valueOf(isbnNummer.charAt(countOnEven)));
                countOnEven += 1;
            }

            var som = somOneven + someven * 3;
            //System.out.println("som : " + som);
            var temp = String.valueOf(som).substring(0, 2) + "0";
            var tienTaal = Integer.parseInt(temp) + 10;
            //System.out.println("tienTaal : " + tienTaal);

            var verschil = tienTaal - som;
            //System.out.println("verschil : " + verschil);
            var lastGetal = Long.parseLong((isbnNummer))%10;
            if(verschil==10){
                if(lastGetal!=0) {
                    throw new ISBNException("verkerde control getal");
                }
            } else{
                if(lastGetal!=verschil) {
                    throw new ISBNException("verkerde control getal");
                }
            }
            return verschil == lastGetal;

        } else {
            throw new ISBNException("moet met 978 of 979 starten");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(isbn);
    }
}
