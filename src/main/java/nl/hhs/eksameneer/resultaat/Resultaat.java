package nl.hhs.eksameneer.resultaat;

import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.examen.Examen;

public class Resultaat {
    private Student student;
    private Examen examen;
    private Double cijfer;

    public Resultaat (Student student, Examen examen, Double cijfer) {
        this.student = student;
        this.examen = examen;
        this.cijfer = cijfer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Double getCijfer() {
        return cijfer;
    }

    public void setCijfer(Double cijfer) {
        this.cijfer = cijfer;
    }
}
