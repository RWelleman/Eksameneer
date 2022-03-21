package nl.hhs;

public class Antwoord {
    private String inhoud;
    private boolean isGoed;

    public Antwoord(String inhoud, boolean isGoed) {
        this.inhoud = inhoud;
        this.isGoed = isGoed;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public boolean isGoed() {
        return isGoed;
    }

    public void setGoed(boolean goed) {
        isGoed = goed;
    }
}
