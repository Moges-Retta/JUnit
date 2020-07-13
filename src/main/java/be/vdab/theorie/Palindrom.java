package be.vdab.theorie;

public class Palindrom {
    private final String woord;

    public Palindrom(String woord) {
        this.woord = woord;
    }
    public boolean isPalindrom(){
        StringBuilder str = new StringBuilder(woord);
        var ot = woord.toLowerCase();
        var rt = str.reverse().toString().toLowerCase();
        return ot.equals(rt);
    }
}
