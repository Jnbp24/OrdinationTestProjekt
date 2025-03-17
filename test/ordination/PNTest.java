package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class PNTest {
    private PN myPn;
    private LocalDate startDato;
    private LocalDate slutDato;


    @BeforeEach
    public void setUp(){
       startDato = LocalDate.of(2025,3,1);
       slutDato = LocalDate.of(2025,3,15);
       Laegemiddel paracetamol = new Laegemiddel("Paracetamol", 1,6,12,"stk");
       myPn = new PN(startDato,slutDato,2,paracetamol);
    }
    @Test
    public void givDosisIndenforPeriode() {

        LocalDate dosisDato = LocalDate.of(2025,3,8);
        assertTrue(myPn.givDosis(dosisDato));
    }
    @Test
    public void givDosisFørPeriode() {
        LocalDate dosisDato = LocalDate.of(2025,2,13);
        assertFalse(myPn.givDosis(dosisDato));
    }
    @Test
    public void givDosisEfterPeriode() {
        LocalDate dosisDato = LocalDate.of(2025,3,16);
        assertFalse(myPn.givDosis(dosisDato));
    }
    @Test
    public void sidsteDosisogAntalGangeGivet() {
        LocalDate dosisDato = LocalDate.of(2025,3,5);
        myPn.givDosis(dosisDato);

        assertEquals(dosisDato,myPn.getSidsteDosis());
        assertEquals(1, myPn.getAntalGangeGivet());
    }
}