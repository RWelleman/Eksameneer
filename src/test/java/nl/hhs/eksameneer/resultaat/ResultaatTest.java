package nl.hhs.eksameneer.resultaat;

import nl.hhs.eksameneer.Eksameneer;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.OpenVraag;
import nl.hhs.eksameneer.vraag.Vraag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ResultaatTest {

    //Rick
    @Test
    @DisplayName("Cijfer 11")
    void wordt_cijfer_11_opgeslagen_als_10() {
        ArrayList<Student> students = Student.alleStudenten;
        Student RickMerkel = new Student(15, "RickMerkel");

        Resultaat resultaat= new Resultaat(RickMerkel, Examen.getExamenFromCode("Haagse Hogeschool"), 11.9);

        ArrayList<Resultaat> resultaten = Resultaat.alleResultaten;
        resultaten.add(resultaat);
        double expectedResult = 10.0;

        assertTrue(resultaten.contains(resultaat));
        assertEquals(resultaat.getCijfer(), expectedResult);
    }
    //Rick
    @Test
    @DisplayName("Cijfer 0")
    void wordt_cijfer_0_opgeslagen_als_1() {
        ArrayList<Student> students = Student.alleStudenten;
        Student RickMerkel = new Student(15, "RickMerkel");

        Resultaat resultaat= new Resultaat(RickMerkel, Examen.getExamenFromCode("Haagse Hogeschool"), 0.8);

        ArrayList<Resultaat> resultaten = Resultaat.alleResultaten;
        resultaten.add(resultaat);
        double expectedResult = 1.0;

        assertTrue(resultaten.contains(resultaat));
        assertEquals(resultaat.getCijfer(), expectedResult);
    }
}
