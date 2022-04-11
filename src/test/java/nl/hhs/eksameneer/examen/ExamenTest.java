package nl.hhs.eksameneer.examen;

import nl.hhs.eksameneer.vraag.GeslotenVraag;
import nl.hhs.eksameneer.vraag.Vraag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ExamenTest {
    @Test
    @DisplayName("Zonder parameters geen examen toevoegen")
    void examen_creatingNewExamenWithNullParameters_examenShouldntBeAddedToAlleExamens() {
        Examen examenFullyEmpty = new Examen(null, null);
        Examen examenNoQuestions = new Examen(new ArrayList<>(), null);
        Examen examenNoCode = new Examen(null, "Test examencode");
        ArrayList<Examen> alleExamens = Examen.alleExamen;

        assertFalse(alleExamens.contains(examenFullyEmpty));
        assertFalse(alleExamens.contains(examenNoCode));
        assertFalse(alleExamens.contains(examenNoQuestions));
    }

    @Test
    @DisplayName("Zonder student geen examen afnemen")
    void neemAf_withoutaStudentAsParameterInFunction_shouldReturnNull() {
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Deze test slaagt. Ja of Nee", "Ja"));
        Examen examen = new Examen(vragen, "SlaagtTest");

        assertNull(examen.neemAf(null));
    }

    @Test
    @DisplayName("Geef alle vragen terug van een examen")
    void getVragen_questionsAreAddedToTheExamen_shouldReturnAnArrayListOfVragen() {
        ArrayList<Vraag> vragen = new ArrayList<>();
        vragen.add(new GeslotenVraag("Deze test slaagt. Ja of Nee", "Ja"));
        Examen examen = new Examen(vragen, "SlaagtTest");

        assertEquals(vragen, examen.getVragen());
    }


}
