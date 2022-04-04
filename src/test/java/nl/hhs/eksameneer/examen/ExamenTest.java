package nl.hhs.eksameneer.examen;

import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.Vraag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ExamenTest {
    @Test
    void newExamenWithNullParametersShouldntBeAddedToAllExams() {
        Examen examenFullyEmpty = new Examen(null, null);
        Examen examenNoQuestions = new Examen(new ArrayList<Vraag>(), null);
        Examen examenNoCode = new Examen(null, "Test examencode");
        ArrayList<Examen> alleExamens = Examen.alleExamen;

        assertFalse(alleExamens.contains(examenFullyEmpty));
        assertFalse(alleExamens.contains(examenNoCode));
        assertFalse(alleExamens.contains(examenNoQuestions));
    }

    @Test
    void neemAfShouldGetNull() {
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Deze test slaagt. Ja of Nee", "Ja"));
        Examen examen = new Examen(vragen, "SlaagtTest");

        assertNull(examen.neemAf(null));
    }

    @Test
    void returnAnArrayListOfAllVragen() {
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Deze test slaagt. Ja of Nee", "Ja"));
        Examen examen = new Examen(vragen, "SlaagtTest");

        assertEquals(vragen, examen.getVragen());
    }


}
