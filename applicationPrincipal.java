/**
 * Classe applicationPrincipal
 *
 * @author : Mehran Nazemi
 * @version : avril 2020
 * @Professeur : M.Bruno Malenfant
 * @email : nazemi.mehran@courrier.uqam.ca
 * @code permanent  : NAZM30088507
 */
public class applicationPrincipal {

    public static void main(String[] args) {
        // Méthode d'affichage du message de bienvenue
        Console.msgBienvenue();

        // Méthode d'affichage du résumé de ce que programme fait
        Console.msgResume();

        //Demande des informations à l'utilisateur:
        String phraseGeneree = Console.lirePhrase("Entrez la phrase generee : ");
        String phraseCible = Console.lirePhrase("Entrez la phrase cible : ");

        //Modifier les phrase
        PhraseModifie phraseGenereeModifie = new PhraseModifie(phraseGeneree);
        PhraseModifie phraseCibleModifie = new PhraseModifie(phraseCible);

        //Creer l'objet d'inventaire pour la phrase Generee
        Inventaire listPhraseGenereee = new Inventaire(phraseGenereeModifie.getPhrase(), "phrase generee");

        //Creer les arraylists (grammes1, grammes2, grammes3, grammes4) pour phrase generee
        listPhraseGenereee.creerGrmme1();
        listPhraseGenereee.creerGrmme2();
        listPhraseGenereee.creerGrmme3();
        listPhraseGenereee.creerGrmme4();

        //Creer l'object d'inventaire pour la phrase Cible
        Inventaire listPhraseCible = new Inventaire(phraseCibleModifie.getPhrase(), "phrase cible");
        listPhraseCible.creerGrmme1();
        listPhraseCible.creerGrmme2();
        listPhraseCible.creerGrmme3();
        listPhraseCible.creerGrmme4();

        //Calculer c , r , q ,F
        listPhraseGenereee.nombreGrammeCommun(listPhraseCible);
        listPhraseGenereee.claculRappel(listPhraseCible);
        listPhraseGenereee.claculPrecision();
        listPhraseGenereee.claculMesure();

        //Afficher les resultats demandés dans console
        System.out.println(listPhraseGenereee.toString());
        System.out.println(listPhraseCible.toString());
        System.out.println(listPhraseGenereee.afficherResultat());

        //Message fin de la programme
        Console.msgFin();
    }
}
