package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DagligSkaev extends Ordination {
    private List<Dosis>doser;

    public DagligSkaev(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel){
        super(startDato, slutDato, laegemiddel);
        this.doser =  new ArrayList<>();
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doser.add(dosis);
    }

    public Dosis[] opretDoser(LocalTime[] tider, double[] antal) {
        Dosis[] doser = new Dosis[tider.length];
        for (int i = 0; i < tider.length; i++) {
            doser[i]= new Dosis(tider[i], antal[i]);
            this.doser.add(doser[i]);
        }

        return doser;
    }

    public Dosis[] getDoser() {
        return doser.toArray(new Dosis[0]);
    }

    @Override
    public double samletDosis() {
        double totalDosis = 0;

        for (Dosis dosis : doser) {
            totalDosis += dosis.getAntal();
        }
        return totalDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "DagligSkaev";
    }

}
