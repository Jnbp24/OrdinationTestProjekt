package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private Dosis[] doser;
    private double morgenAntal;
    private double middagAntal;
    private double aftenAntal;
    private double natAntal;

    public DagligFast(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        super(startDato, slutDato, laegemiddel);
        this.morgenAntal = morgenAntal;
        this.middagAntal = middagAntal;
        this.aftenAntal = aftenAntal;
        this.natAntal = natAntal;
        this.doser = new Dosis[4];

        doser[0] = new Dosis(LocalTime.of(6, 0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
        doser[3] = new Dosis(LocalTime.of(00, 0), natAntal);

    }


    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double totalDosis = 0;
        for (Dosis dosis : doser) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis * antalDage();
    }

    @Override
    public double doegnDosis() {
        double totalDosis = 0;
        for (Dosis dosis : doser) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
