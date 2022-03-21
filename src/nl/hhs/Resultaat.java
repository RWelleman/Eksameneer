package nl.hhs;

public class Resultaat {
    private Student student;
    private Examen examen;
    private double cijfer;

    public Resultaat(Student student, Examen examen, double cijfer) {
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

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }
}