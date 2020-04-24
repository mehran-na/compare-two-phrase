public class Gramme1 {
    //Fields:
    private String mot1;


    //Constructors:
    public Gramme1(String mot1) {
        this.mot1 = mot1;
    }

    /*
    * Override method equals pour utilise dans comparaison des grammes
    *
    * @param : autreObjet
    * @return : boolean si ils sont equal alors return true sinon return false
    * */
    @Override
    public boolean equals(Object autreObjet) {
        boolean resultat;
        // un test rapide pour voir si les objets sont identiques
        if (this == autreObjet) {
            resultat = true;
        }else if (autreObjet == null) {
            // resultat doit être false si le paramètre est null
            resultat = false;
        }else if (getClass() != autreObjet.getClass()) {
            // si les classes ne correspondent pas, elles ne peuvent pas être égales
            resultat = false;
        }else{
            // maintenant nous savons que autreObjet est un Gramme1 non null
            Gramme1 autre = (Gramme1) autreObjet;
            // tester si les fields ont des valeurs identiques
            resultat = mot1.toLowerCase().equals(autre.mot1.toLowerCase());
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "\"" + mot1 + "\"";
    }
}

