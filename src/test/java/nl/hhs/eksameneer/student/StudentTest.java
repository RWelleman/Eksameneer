package nl.hhs.eksameneer.student;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.vraag.GeslotenVraag;

import nl.hhs.eksameneer.vraag.Vraag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentTest {

    @Test
    @DisplayName("toonBehaaldeExamens hoort behaalde examens te weergeven.")
    public void toonBehaaldeExamens() {
        Antwoord antwoord = new Antwoord();
        antwoord.setInput("test");
        antwoord.setIsGoed(true);

        ArrayList<Vraag> vragen = new ArrayList<>();

        vragen.add(new GeslotenVraag("TEst", "Deze test slaagt. Ja of Nee"));

        Examen examen = new Examen(vragen, "SlaagtTest");

        Student student = new Student(21010102, "Mike de Boer");

        Resultaat resultaat = new Resultaat(student, examen, 7.5);

        ArrayList<Resultaat> resultaten = new ArrayList<>();
        resultaten.add(resultaat);


        student.setBehaaldeExamens(resultaten);
        student.getBehaaldeExamens();

        ArrayList<Examen> alleExamens = new ArrayList<>();

        alleExamens.add(examen);
        Examen.setAlleExamen(alleExamens);

        assertEquals(student.getBehaaldeExamens().size(), 1);

    }

    @Test
    @DisplayName("Behaalde examens heeft geen voldoende in zich")
    public void toonGeenBehaaldeExamens(){
        Antwoord antwoord = new Antwoord();
        antwoord.setInput("ja");
        antwoord.setIsGoed(false);

        ArrayList<Vraag> vragen = new ArrayList<>();

        vragen.add(new GeslotenVraag("Fuck", "Deze test slaagt. Ja of Nee"));

        Examen examen = new Examen(vragen, "SlaagtTest");

        Student student = new Student(21010102, "Mike de Boer");

        Resultaat resultaat = new Resultaat(student, examen, 4.0);

        ArrayList<Resultaat> resultaten = new ArrayList<>();
        resultaten.add(resultaat);


        student.setBehaaldeExamens(resultaten);

        ArrayList<Examen> alleExamens = new ArrayList<>();

        alleExamens.add(examen);
        Examen.setAlleExamen(alleExamens);
        student.getBehaaldeExamens();

        assertNull(student.getBehaaldeExamens());
    }

}


