package nl.hhs;

import java.util.ArrayList;

public class GeslotenVraag extends Vraag {
    private ArrayList<String> antwoorden = new ArrayList<>();

    public GeslotenVraag(String inhoud, String correcteAnwoord) {
        super(inhoud, correcteAnwoord);
        this.antwoorden.add("Ja");
        this.antwoorden.add("Nee");
    }

    public ArrayList<String> getAntwoorden(){
        // gesloten vraag is toch ja/nee vraag?
        return this.antwoorden;
    }
}
