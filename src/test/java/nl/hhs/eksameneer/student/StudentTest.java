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

        ArrayList<Resultaat> resultaten = new ArrayList<>();
        resultaten.add(resultaat);


        student.setBehaaldeExamens(resultaten);

        ArrayList<Examen> alleExamens = new ArrayList<>();

        alleExamens.add(examen);
        Examen.setAlleExamen(alleExamens);
        student.getBehaaldeExamens();

        assertEquals(student.getBehaaldeExamens().size(), 1);

    }

    @Test
    @DisplayName("Behaalde examens heeft geen voldoende in zich")
    public void toonGeenBehaaldeExamens(){
        Antwoord antwoord = new Antwoord("Ja");
        antwoord.setGoed(false);

        ArrayList<Vraag> vragen = new ArrayList<>();

        vragen.add(new GeslotenVraag(null, "Deze test slaagt. Ja of Nee", "Ja", antwoord));

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

        assertEquals(student.getBehaaldeExamens().size(), 0);
    }

}
