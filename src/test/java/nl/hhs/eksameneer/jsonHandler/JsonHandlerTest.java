package nl.hhs.eksameneer.jsonHandler;

import nl.hhs.eksameneer.student.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonHandlerTest {
    @Test
    public void TestStudent() throws IOException {
        // Arrange
        Student testStudent = new Student(1, "Abdallah");
        String filename = "student.json";

        // Act
        JsonHandler.slaOp(testStudent, filename);
        Student opgehaaldeStudent = (Student) JsonHandler.haalOp(Student.class, "student.json");

        // Assert
        assertEquals(1, opgehaaldeStudent.getStudentNummer());
        assertEquals("Abdallah", opgehaaldeStudent.getNaam());
    }
}