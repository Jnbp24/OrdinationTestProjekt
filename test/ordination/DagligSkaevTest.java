package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {
    private DagligSkaev dagligSkaev;


    @BeforeEach
    void setUp(){
        Laegemiddel laegemiddel = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");
        LocalDate startDato = LocalDate.of(2025,3,20);
        LocalDate slutDato = LocalDate.of(2025,3,22);

        dagligSkaev = new DagligSkaev(startDato,slutDato,laegemiddel);

    }
    @Test
    void samletDosis() {
        dagligSkaev.opretDosis(LocalTime.of(6,0),10);
        dagligSkaev.opretDosis(LocalTime.of(12,0),10);
        dagligSkaev.opretDosis(LocalTime.of(18,0),10);

        double result = dagligSkaev.samletDosis();

        assertEquals(30.0,result);

    }

    @Test
    void doegnDosis() {
        dagligSkaev.opretDosis(LocalTime.of(6,0),10);
        dagligSkaev.opretDosis(LocalTime.of(12,0),10);
        dagligSkaev.opretDosis(LocalTime.of(18,0),10);

        double result = dagligSkaev.doegnDosis();
        //Bør udregne antal dage mellem start og slut dato og dividere med den samlede dosis

        assertEquals(10.0,result);
    }



}