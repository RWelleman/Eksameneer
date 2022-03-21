package nl.hhs;

public abstract class Vraag {
    private String inhoud;
    private String correcteAnwoord;
    private Antwoord antwoord;

    public Vraag(String inhoud, String correcteAnwoord, Antwoord antwooord) {
        this.inhoud = inhoud;
        this.correcteAnwoord = correcteAnwoord;
        this.antwoord = antwooord;
    }

    public Antwoord controleer() {
        // goed = true; fout = false
        // pak this.correcteAntwoord & vergelijk dit met this.antwoord.getInput()
        // Als het klopt zet this.antwoord.setGoed()
        // Deze functie kan overwritten worden bij subclasses
        // return this.antwoord

        return this.antwoord;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public String getCorrecteAnwoord() {
        return correcteAnwoord;
    }

    public void setCorrecteAnwoord(String correcteAnwoord) {
        this.correcteAnwoord = correcteAnwoord;
    }

    public Antwoord getAntwooord() {
        return antwoord;
    }

    public void setAntwooord(Antwoord antwooord) {
        this.antwoord = antwooord;
    }
}
