package nl.hhs.eksameneer.vraag;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.examen.Examen;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {
    private ArrayList<Antwoord> antwoorden;

    public MeerkeuzeVraag(Examen examen, String inhoud, String correcteAnwoord, ArrayList<Antwoord> antwoorden) {
        super(examen, inhoud, correcteAnwoord, null);
        // Moet de laatste parameter null zijn als ik arraylist wil ipv antwoord?

        this.antwoorden = antwoorden;
    }

    public ArrayList<Antwoord> getAntwoorden() {
        return antwoorden;
    }
}
