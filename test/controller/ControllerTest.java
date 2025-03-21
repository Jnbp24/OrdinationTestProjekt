package controller;

import ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    Controller controller;
    LocalDate startDate;
    LocalDate endDate;
    Patient patient;
    Laegemiddel laegemiddel;

    @BeforeEach
    public void setUp() {
        controller = Controller.getTestController();
        startDate = LocalDate.of(2025, 03, 20);
        endDate = LocalDate.of(2025, 03, 20);
        patient = new Patient("1212121212", "Test Testersen", 80);
        laegemiddel = new Laegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
    }

    @Test
    void opretPN() {
        PN actual = controller.opretPNOrdination(startDate, endDate, patient, laegemiddel, 2);
        assertNotNull(actual);
        assertInstanceOf(PN.class, actual);
    }

    @Test
    void opretDagligSkaev() {
        LocalTime[] tider = {LocalTime.of(8, 0), LocalTime.of(18, 0)};
        double[] antalEnheder = {2, 2};

        DagligSkaev dagligSkaev = controller.opretDagligSkaevOrdination(startDate, endDate, patient, laegemiddel, tider, antalEnheder);
        assertNotNull(dagligSkaev);
        assertInstanceOf(DagligSkaev.class, dagligSkaev);
    }

    @Test
    void opretDagligFast() {
        DagligFast dagligFast = controller.opretDagligFastOrdination(startDate, endDate, patient, laegemiddel, 1, 2, 3, 4);
        assertNotNull(dagligFast);
        assertInstanceOf(DagligFast.class, dagligFast);
    }
}
