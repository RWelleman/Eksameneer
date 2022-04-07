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
        studenten.add(testStudent);
        studenten.add(testStudentTwee);

        Examen examen = new Examen(null, "Duits");
        Resultaat resultaat = new Resultaat(testStudent, examen, 6.5);
        ArrayList<Object> resultaten = new ArrayList<>();
        resultaten.add(resultaat);

        // Act
        JsonHandler.slaOp(resultaten, "resultaat.json");
        JsonHandler.slaOp(studenten, "student.json");
        ArrayList<Student> opgehaaldeStudenten = JsonHandler.haalStudentenOp();
        Student abdallah = JsonHandler.haalStudentOp(testStudent.getStudentNummer());
        ArrayList<Resultaat> opgehaaldeResultaten = JsonHandler.haalResultatenOp();

        // Assert
        assertEquals(2, opgehaaldeStudenten.size());
        assertEquals("Abdallah", opgehaaldeStudenten.get(0).getNaam());
        assertEquals("Abdallah", abdallah.getNaam());

        assertEquals(1, opgehaaldeResultaten.size());
        assertEquals("Abdallah", opgehaaldeResultaten.get(0).getStudent().getNaam());
        assertEquals(6.5, opgehaaldeResultaten.get(0).getCijfer());
    }
}