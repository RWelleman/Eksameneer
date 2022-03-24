package nl.hhs.examen;

import nl.hhs.resultaat.Resultaat;
import nl.hhs.student.Student;
import nl.hhs.vraag.Vraag;

import java.util.ArrayList;

public class Examen {
    private String examenCode;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    private static ArrayList<Examen> alleExamen;

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    public void maakVraag(Vraag vraag){

    }

    public void verwijderVraag(Vraag vraag){

    }

    public Resultaat neemAf(Student student){
        Resultaat resultaat = new Resultaat(student, this, 5.0);
        return resultaat;
    }
}

// test