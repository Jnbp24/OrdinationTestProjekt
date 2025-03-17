package ordination;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class PN extends Ordination {
    private double antalEnheder;
    private int antalGangeGivet = 0;


    public PN(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDato, slutDato, laegemiddel); // Kalder superklassens konstruktor
        this.antalEnheder = antalEnheder;
    }

    public boolean givDosis(LocalDate givetDato) {
        if (!givetDato.isBefore(getStartDato()) && !givetDato.isAfter(getSlutDato())) {
            antalGangeGivet++;
            return true;
        }
        return false;
    }

    @Override
    public double samletDosis() {
        return antalEnheder * antalGangeGivet;
    }

    @Override
    public double doegnDosis() {
        if (antalGangeGivet == 0) {
            return 0.0; // Undgår division med 0
        }
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "PN";
    }

    public int getAntalGangeGivet() {
        return antalGangeGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }
}