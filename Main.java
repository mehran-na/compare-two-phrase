public class Main {

    public static void main(String[] args) {
        // Méthode d'affichage du message de bienvenue
        Console.msgBienvenue();

        // Méthode d'affichage du résumé de ce que programme fait
        Console.msgResume();

        //Demande des informations à l'utilisateur:
        String phrase1 = Console.lirePhrase("Entrer première phrase S.V P : ");
        String phrase2 = Console.lirePhrase("Entrer deuxièm phrase S.V P : ");

        //Modifie phrase
        PhraseModifie phraseModifie1 = new PhraseModifie(phrase1);
        PhraseModifie phraseModifie2 = new PhraseModifie(phrase2);

        //Creer inventaire pour phrase1
        Inventaire inventaire1 = new Inventaire(phraseModifie1.getPhrase());

        inventaire1.creerGrmme1();
        inventaire1.creerGrmme2();
        inventaire1.creerGrmme3();
        inventaire1.creerGrmme4();

        //Creer inventaire pour phrase2
        Inventaire inventaire2 = new Inventaire(phraseModifie2.getPhrase());
        inventaire2.creerGrmme1();
        inventaire2.creerGrmme2();
        inventaire2.creerGrmme3();
        inventaire2.creerGrmme4();

        inventaire1.nombreGrammeCommun(inventaire2);
        inventaire1.claculRappel(inventaire2);
        inventaire1.claculPrecision();
        inventaire1.claculMesure();


        System.out.println(inventaire1.toString());



        Console.msgFin();
    }
}
