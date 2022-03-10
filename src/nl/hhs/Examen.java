package nl.hhs;

import java.util.ArrayList;

public class Examen {
    public ArrayList<Vraag> vragen;
    public ArrayList<Student> studenten;
    public Vak vak;

    public Examen(ArrayList<Vraag> vragen, ArrayList<Student> studenten, Vak vak) {
        this.vragen = vragen;
        this.studenten = studenten;
        this.vak = vak;
    }

    public Resultaat neemAf(Student student){
        Resultaat resultaat = new Resultaat(student, this, 5.0);
        return resultaat;
    }
}