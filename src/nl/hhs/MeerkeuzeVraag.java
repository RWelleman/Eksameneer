package nl.hhs;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {
    private final ArrayList<String> antwoorden;

    public MeerkeuzeVraag(String inhoud, String correcteAnwoord, ArrayList<String> antwoorden) {
        super(inhoud, correcteAnwoord);
        // Moet de laatste parameter null zijn als ik arraylist wil ipv antwoord?

        this.antwoorden = antwoorden;
    }

    @Override
    public String getInhoud() {
        StringBuilder inhoudString = new StringBuilder();
        inhoudString.append(this.inhoud).append("\n");

        for(int i = 0; i < antwoorden.size()-1; i++) {
            inhoudString.append(i+1).append(". ").append(antwoorden.get(i));
            if(i != antwoorden.size()-1) inhoudString.append("\n");
        }

        return inhoudString.toString();
    }

    public ArrayList<String> getAntwoorden() {
        return antwoorden;
    }
}
