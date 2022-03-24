package nl.hhs;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {
    private ArrayList<String> antwoorden;

    public MeerkeuzeVraag(String inhoud, String correcteAnwoord, ArrayList<String> antwoorden) {
        super(inhoud, correcteAnwoord);
        // Moet de laatste parameter null zijn als ik arraylist wil ipv antwoord?

        this.antwoorden = antwoorden;
    }

    public ArrayList<String> getAntwoorden() {
        return antwoorden;
    }
}
