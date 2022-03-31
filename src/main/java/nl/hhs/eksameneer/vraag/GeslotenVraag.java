package nl.hhs.eksameneer.vraag;
import java.util.ArrayList;

public class GeslotenVraag extends Vraag {
    private final ArrayList<String> antwoorden = new ArrayList<>();

    public GeslotenVraag(String inhoud, String correcteAnwoord) {
        super(inhoud, correcteAnwoord);
        this.antwoorden.add("Ja");
        this.antwoorden.add("Nee");
    }

    @Override
    public String getInhoud() {
        StringBuilder inhoudString = new StringBuilder();
        inhoudString.append(this.inhoud).append("\n");

        for(String antwoord : antwoorden) {
            inhoudString.append(antwoord);
            if(antwoord.equals("Ja")) inhoudString.append("\n");
        }

        return inhoudString.toString();
    }

    public ArrayList<String> getAntwoorden(){
        // gesloten vraag is toch ja/nee vraag?
        return this.antwoorden;
    }
}
