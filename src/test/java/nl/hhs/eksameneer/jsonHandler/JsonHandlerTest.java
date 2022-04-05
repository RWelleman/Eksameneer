package nl.hhs.eksameneer.jsonHandler;

import nl.hhs.eksameneer.JsonStorable;
import nl.hhs.eksameneer.student.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
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

        String filename = "student.json";

        // Act
        JsonHandler.slaOp(studenten, filename);
        ArrayList<Student> opgehaaldeStudenten = (ArrayList<Student>) JsonHandler.haalOp(studenten.getClass(), "student.json");

        // Assert
        System.out.println(studenten);
        System.out.println(opgehaaldeStudenten);

        // assertEquals(1, opgehaaldeStudent.getStudentNummer());
        // assertEquals("Abdallah", opgehaaldeStudent.getNaam());
    }
}