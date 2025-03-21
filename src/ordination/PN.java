package ordination;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class PN extends Ordination {


    private LocalDate sidsteDosis;
    private double antalEnheder;
    private int antalGangeGivet = 0;

    public PN(LocalDate startDato, LocalDate slutDato, double antalEnheder, Laegemiddel laegemiddel) {
        super(startDato, slutDato, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givetDato
     * Returnerer true hvis givetDato er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givetDato ignoreres
     *
     * @param givetDato
     * @return
     */
    public boolean givDosis(LocalDate givetDato) {
        // Checker om dosis bliver givet i en valid periode. Hvis dosis bliver givet udenfor perioden, retuneres false
        if (givetDato.isAfter(super.getStartDato().minusDays(1)) && givetDato.isBefore(super.getSlutDato().plusDays(1))) {
            sidsteDosis = givetDato;
            antalGangeGivet++;
            return true;
        }
        return false;
    }

    public double doegnDosis() {
        // Finder antal dage mellem startdatoen og slutdatoen
        long dageImellemDosis = ChronoUnit.DAYS.between(super.getStartDato(), super.getSlutDato());
        // Udregner døgndosis baseret på antallet af enhededr og antallet af dage mellem doseringer
        return (antalEnheder * antalGangeGivet) / dageImellemDosis;
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        // Finder antal dage mellem startdatoen og slutdatoen
        long dageImellemDosis = ChronoUnit.DAYS.between(super.getStartDato(), super.getSlutDato());
        return antalEnheder * dageImellemDosis;
    }
    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGangeGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public LocalDate getSidsteDosis() {
        return sidsteDosis;
    }
}
