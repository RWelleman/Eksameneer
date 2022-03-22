package nl.hhs;

public class Resultaat {
    private Student student;
    private Examen examen;
    private Double cijfer;

    public Resultaat (Student student, Examen examen, Double cijfer) {
        this.student = student;
        this.examen = examen;
        this.cijfer = cijfer;
    }
}
