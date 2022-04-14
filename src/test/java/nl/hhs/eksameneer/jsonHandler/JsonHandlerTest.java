package nl.hhs.eksameneer.jsonHandler;

import nl.hhs.eksameneer.examen.Examen;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class JsonHandlerTest {
    @Test
    public void slaOp_StudentLogtIn_SlaatStudentObjectOp() {
        // Arrange
        Student testStudent = new Student(1, "Abdallah");
        Student testStudentTwee = new Student(254, "TestNaam");
        Student testStudentDrie = new Student(-5, null); // unhappy flow
        Student.alleStudenten.add(testStudent);
        Student.alleStudenten.add(testStudentTwee);
        Student.alleStudenten.add(testStudentDrie);

        Examen examen = new Examen(null, "Duits");

        Resultaat resultaat = new Resultaat(testStudent, examen, 6.5);
        Resultaat resultaatTwee = new Resultaat(testStudentDrie, examen, -10.00); // unhappy flow
        Resultaat resultaatDrie = new Resultaat(testStudentTwee, examen, null); // unhappy flow
        Resultaat.alleResultaten.add(resultaat);
        Resultaat.alleResultaten.add(resultaatTwee);
        Resultaat.alleResultaten.add(resultaatDrie);

        // Act
        JsonHandler.slaStudentenOp();
        ArrayList<Student> opgehaaldeStudenten = JsonHandler.haalStudentenOp();

        JsonHandler.slaResultatenOp();
        ArrayList<Resultaat> opgehaaldeResultaten = JsonHandler.haalResultatenOp();

        Student abdallah = JsonHandler.haalStudentOp(testStudent.getStudentNummer());
        Student unhappy = JsonHandler.haalStudentOp(testStudentDrie.getStudentNummer());

        // Assert
        assertEquals(Student.alleStudenten.size(), opgehaaldeStudenten.size());
        assertEquals("Abdallah", opgehaaldeStudenten.get(0).getNaam());
        assertEquals("Abdallah", abdallah.getNaam());
        assertNull(unhappy.getNaam());

        assertEquals(Resultaat.alleResultaten.size(), opgehaaldeResultaten.size());
        assertEquals("Abdallah", opgehaaldeResultaten.get(0).getStudent().getNaam());
        assertEquals(6.5, opgehaaldeResultaten.get(0).getCijfer());
        assertNull(opgehaaldeResultaten.get(1).getStudent().getNaam());

    }
}