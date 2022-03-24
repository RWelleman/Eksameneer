package nl.hhs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GeslotenVraag extends Vraag {
    public GeslotenVraag(Examen examen, String inhoud, String correcteAnwoord, Antwoord antwoord) {
        super(examen, inhoud, correcteAnwoord, antwoord);
    }

    public ArrayList<String> getAntwoorden(){
        ArrayList<String> antwoorden = null;
        antwoorden.add("ja");
        antwoorden.add("nee");
        return antwoorden;
    }
}
