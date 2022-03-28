package nl.hhs.eksameneer.examen;

import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.Vraag;

import java.util.ArrayList;

public class Examen {
    private String examenCode;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    public static ArrayList<Examen> alleExamen = new ArrayList<Examen>();

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    // Overload
    public Examen(String examenCode) {
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

    public String getExamenCode() {
        return examenCode;
    }

    public void setExamenCode(String examenCode) {
        this.examenCode = examenCode;
    }
}

// test