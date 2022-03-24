package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.vraag.GeslotenVraag;

import nl.hhs.eksameneer.vraag.Vraag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    @DisplayName("toonBehaaldeExamens hoort behaalde examens te weergeven.")
    public void toonBehaaldeExamens() {
        Antwoord antwoord = new Antwoord("Ja");
        antwoord.setGoed(true);
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag(null, "Deze test slaagt. Ja of Nee", "Ja", antwoord));
        Examen examen = new Examen(vragen, "SlaagtTest");
        Student student = new Student(21010102, "Mike de Boer");
        Resultaat resultaat = new Resultaat(student, examen, 7.5);

        student.getBehaaldeExamens();
        assertEquals(student.getBehaaldeExamens().size(), 1 );

    }

}
