package nl.hhs;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void toonMenu(){
        System.out.println("== Menu ==");
        System.out.println("1) Voeg examen toe");
        System.out.println("2) Selecteer een examen");
        System.out.println("0) Exit");
        System.out.println("====");
    }

    public static void main(String[] args) {
        // write your code here //
        Scanner scanner = new Scanner(System.in);

        toonMenu();
        int gekozen = scanner.nextInt();
        while(gekozen != 0){
            switch(gekozen) {
                case 1:
                    System.out.println("Kies een code");
                    String examenCode = scanner.next();
                    new Examen(examenCode);
                    break;
                case 2:
                    ArrayList<Examen> alleExamen = Examen.getAlleExamen();
                    System.out.println("== Selecteer een examen ==");
                    for(int i = 0; i< alleExamen.size(); i++){
                        System.out.println(i+1 + ") " + alleExamen.get(i).getExamenCode());
                    }
                    System.out.println("0) Terug naar menu");
                    System.out.println("====");

                    int examenOptie = scanner.nextInt();
                    if(examenOptie == 0){
                        break;
                    }
                    Examen gekozenExamen = alleExamen.get(examenOptie - 1);
                    System.out.println("== Gekozen Examen: " + gekozenExamen.getExamenCode() + " ==");
                    System.out.println("1) Voeg vraag toe");
                    System.out.println("2) Selecteer vraag");
                    System.out.println("====");

                    int gekozenOptie = scanner.nextInt();
                    switch(gekozenOptie){
                        case 1:
                            int typeVraagGekozen = 0;
                            System.out.println("== Voeg type vraag toe: " + gekozenExamen.getExamenCode() + " ==");
                            System.out.println("1) Gesloten vraag");
                            System.out.println("0) Terug naar menu");
                            System.out.println("====");
                            typeVraagGekozen = scanner.nextInt();
                            switch(typeVraagGekozen){
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("== Vraagstelling: ==");
                                    String vraagStelling = scanner.next();
                                    System.out.println("== Goede antwoord (Ja/Nee): ==");
                                    String antwoord = scanner.nextLine();
                                    antwoord = antwoord.toLowerCase(Locale.ROOT);
                                    while(!antwoord.equals("ja") && !antwoord.equals("nee")){
                                        System.out.println("== AUB 'Ja' of 'Nee' invullen: ==");
                                        antwoord = scanner.next().toLowerCase(Locale.ROOT);
                                    }

                                    new GeslotenVraag(gekozenExamen, vraagStelling, antwoord);
                            }
                        case 2:
                            System.out.println("== work in progress ==");
                            System.out.println("1) ...");
                            System.out.println("====");
                            break;
                    }

                    break;
            }
            toonMenu();
            gekozen = scanner.nextInt();
        };
        //Examen nieuweExamen = new Examen();
    }
}
