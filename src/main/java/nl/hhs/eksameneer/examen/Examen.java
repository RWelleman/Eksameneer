package nl.hhs.eksameneer.examen;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.jsonHandler.JsonHandler;
import nl.hhs.eksameneer.resultaat.Resultaat;
import nl.hhs.eksameneer.student.Student;
import nl.hhs.eksameneer.vraag.Vraag;

import javax.print.attribute.ResolutionSyntax;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    private final String examenCode;
    private final ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    public static ArrayList<Examen> alleExamen = new ArrayList<>();

    public Examen(ArrayList<Vraag> vragen, String examenCode) {
        this.vragen = vragen;
        this.examenCode = examenCode;
        alleExamen.add(this);
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    public Resultaat neemAf(Student student) throws IOException {
        Scanner scanner = new Scanner(System.in);

        for (Vraag vraag : vragen) {
            System.out.println(vraag.getInhoud());
            Antwoord antwoord = new Antwoord(scanner.next());
            vraag.setAntwoord(antwoord);
        }

        double cijfer = 1;

        System.out.println("Lever examen in? (j/n)");
        String jn = scanner.next();
        if(jn.equals("j")) {
            int correct = 0;
            for (Vraag vraag : vragen) {
                Antwoord antwoord = vraag.controleer();
                correct += antwoord.isGoed() ? 1 : 0;
            }
            cijfer = correct / vragen.size() * 9 + 1;
        }

        Resultaat resultaat = new Resultaat(student, this, cijfer);
        Resultaat.alleResultaten.add(resultaat);
        JsonHandler.slaResultatenOp();

        return resultaat;
    }

    public String getExamenCode() {
        return examenCode;
    }

    public static Examen getExamenFromCode(String examenCode){
        for(int i = 0; i < alleExamen.size(); i++) {
            if(alleExamen.get(i).getExamenCode().equals(examenCode)){
                return alleExamen.get(i);
            };
        }

        return null;
    };
}

// test