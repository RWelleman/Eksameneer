package nl.hhs;

public class Resultaat {
    public Student student;
    public Examen examen;
    public Double cijfer;

    public Resultaat (Student student, Examen examen, Double cijfer) {
        this.student = student;
        this.examen = examen;
        this.cijfer = cijfer;
    }
}
