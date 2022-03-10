package Practicum6_A;

import java.time.LocalDate;
import java.util.Locale;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double newPr){
        naam = nm; releaseJaar = rJ; nieuwprijs = newPr;
    }
    public String getNaam(){
        return naam;
    }
    public double huidigeWaarde(){
        double prijs = nieuwprijs;
        for (int i = 0; i < (LocalDate.now().getYear() - releaseJaar); i++) {
            prijs *= 0.7;
        }
        String prijsString = String.format(Locale.US, "%.2f", prijs);
        prijs = Double.parseDouble(prijsString);
        return prijs;
    }

    public boolean equals(Object andereObject){
        boolean result = false;
        if (andereObject instanceof Game){
            Game testObject = (Game) andereObject;
            if (this.naam.equals(testObject.naam) &&
                this.releaseJaar == testObject.releaseJaar &&
                this.nieuwprijs == testObject.nieuwprijs) {
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        return "\n" + this.getNaam() + ", uitgegeven in " + releaseJaar + " nieuwprijs: €"+ nieuwprijs + " nu voor: €" + this.huidigeWaarde();
    }
}
