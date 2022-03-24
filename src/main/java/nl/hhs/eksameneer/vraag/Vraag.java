package nl.hhs.eksameneer.vraag;

import nl.hhs.eksameneer.antwoord.Antwoord;
import nl.hhs.eksameneer.examen.Examen;

public abstract class Vraag {
    private String inhoud;
    private String correcteAntwoord;
    private Antwoord antwoord;
    private Examen examen;

    public Vraag(Examen examen, String inhoud, String correcteAnwoord, Antwoord antwoord) {
        this.inhoud = inhoud;
        this.correcteAntwoord = correcteAnwoord;
        this.antwoord = antwoord;
        this.examen = examen;
    }

    public Antwoord controleer() {
        // goed = true; fout = false
        // pak this.correcteAntwoord & vergelijk dit met this.antwoord.getInput()
        // Doe daarna antwoord.setGoed(x) met x als true/false wanneer het klopt/niet klopt
        // Deze functie kan overwritten worden bij subclasses
        // return this.antwoord
        boolean goed = this.correcteAntwoord.equals(this.antwoord.getInput());
        this.antwoord.setGoed(goed);

        return this.antwoord;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public String getCorrecteAntwoord() {
        return correcteAntwoord;
    }

    public void setCorrecteAntwoord(String correcteAntwoord) {
        this.correcteAntwoord = correcteAntwoord;
    }

    public Antwoord getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(Antwoord antwoord) {
        this.antwoord = antwoord;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
