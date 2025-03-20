package ordination;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaegemiddelTest {
    private Laegemiddel laegemiddel;
    private Patient patient;


    @BeforeEach
    public void setUp() {
        patient = new Patient("121256-0512", "Jane Jensen", 63.4);
        laegemiddel = new Laegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
    }

    @Test
    void anbefaletDosisPrDoegnLet() {
        //Sætter patients vægt til at være let
        double expected = 0.025 * 20;
        double result = laegemiddel.anbefaletDosisPrDoegn(20);
        assertEquals(expected, result);
    }

    @Test
    void anbefaletDosisPrDoegnNormal() {
        //Sætter patients vægt til at være let
        double expected = 0.025 * 65;
        double result = laegemiddel.anbefaletDosisPrDoegn(65);
        assertEquals(expected, result);
        System.out.println(result);
    }

    @Test
    void anbefaletDosisPrDoegn() {
        //Sætter patients vægt til at være let
        double expected = 0.025 * 125;
        double result = laegemiddel.anbefaletDosisPrDoegn(125);

        assertEquals(expected, result);
    }

    @Test
    void anbefaletDosisPrDoegnPræcis25Normal(){
        double expected = 0.025 * 25;
        double result = laegemiddel.anbefaletDosisPrDoegn(25);

        assertEquals(expected,result);
        System.out.println(result);
    }
    @Test
    void anbefaletDosisPrDoegnPræcis120Normal(){
        double expected = 0.025 * 120;
        double result = laegemiddel.anbefaletDosisPrDoegn(120);

        assertEquals(expected,result);
        System.out.println(result);
    }
}