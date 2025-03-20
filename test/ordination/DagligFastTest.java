package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {
    private DagligFast dagligFast;


    @BeforeEach
    void setUp() {
        Laegemiddel laegemiddel = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");
        LocalDate startDato = LocalDate.of(2025, 3, 20);
        LocalDate slutDato = LocalDate.of(2025, 3, 22);

        dagligFast = new DagligFast(startDato, slutDato, laegemiddel,2,2,2,2);

    }

    @Test
    void samletDosis() {
        double result = dagligFast.samletDosis();
        assertEquals(24.0, result);

    }

    @Test
    void doegnDosis() {
        double result = dagligFast.doegnDosis();
        //Bør udregne antal dage mellem start og slut dato og dividere med den samlede dosis
        assertEquals(8.0, result);
    }


}