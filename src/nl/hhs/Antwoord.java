package nl.hhs;

public class Antwoord {
    private String input;
    private boolean isGoed;

    public Antwoord(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isGoed() {
        return isGoed;
    }

    public void setGoed(boolean goed) {
        isGoed = goed;
    }
}
