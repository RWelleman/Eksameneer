package nl.hhs.vraag;

import nl.hhs.antwoord.Antwoord;
import nl.hhs.examen.Examen;

public class OpenVraag extends Vraag {
    public OpenVraag(Examen examen, String inhoud, String correcteAnwoord, Antwoord antwoord) {
        super(examen, inhoud, correcteAnwoord, antwoord);
    }
}
