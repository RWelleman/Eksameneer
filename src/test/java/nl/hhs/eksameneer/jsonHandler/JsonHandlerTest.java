package nl.hhs.eksameneer.jsonHandler;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonHandlerTest {
    @Test
    public void TestStudent() throws IOException {
        // Arrange
        ArrayList<Object> studenten = new ArrayList<Object>();

        Student testStudent = new Student(1, "Abdallah");
        Student testStudentTwee = new Student(254, "TestNaam");
        Student testStudentDrie = new Student(-5, null); // unhappy flow
        studenten.add(testStudent);
        studenten.add(testStudentTwee);
        studenten.add(testStudentDrie);

        Examen examen = new Examen(null, "Duits");
        Resultaat resultaat = new Resultaat(testStudent, examen, 6.5);
        Resultaat resultaatTwee = new Resultaat(testStudentDrie, examen, -10.00); // unhappy flow
        Resultaat resultaatDrie = new Resultaat(testStudentTwee, examen, null); // unhappy flow
        ArrayList<Object> resultaten = new ArrayList<>();
        resultaten.add(resultaat);
        resultaten.add(resultaatTwee);
        resultaten.add(resultaatDrie);

        // Act
        JsonHandler.slaOp(resultaten, "result3reraat.json"); // unhappy flow
        JsonHandler.slaOp(resultaten, "resultaat.json");
        JsonHandler.slaOp(studenten, "student.json");
        ArrayList<Student> opgehaaldeStudenten = JsonHandler.haalStudentenOp();
        Student abdallah = JsonHandler.haalStudentOp(testStudent.getStudentNummer());
        Student unhappy = JsonHandler.haalStudentOp(testStudentDrie.getStudentNummer());
        ArrayList<Resultaat> opgehaaldeResultaten = JsonHandler.haalResultatenOp();

        // Assert
        assertEquals(studenten.size(), opgehaaldeStudenten.size());
        assertEquals("Abdallah", opgehaaldeStudenten.get(0).getNaam());
        assertEquals("Abdallah", abdallah.getNaam());
        assertEquals(null, unhappy.getNaam());

        assertEquals(resultaten.size(), opgehaaldeResultaten.size());
        assertEquals("Abdallah", opgehaaldeResultaten.get(0).getStudent().getNaam());
        assertEquals(6.5, opgehaaldeResultaten.get(0).getCijfer());
        assertEquals(null, opgehaaldeResultaten.get(1).getStudent().getNaam());

    }
}