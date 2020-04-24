public class Gramme2 extends Gramme1 {
    //Fields:
    private String mot2;

    //Constructors:
    public Gramme2(String mot1, String mot2) {
        super(mot1);
        this.mot2 = mot2;
    }

    //Methods:

    /*
     * Override method equals pour utilise dans comparaison des grammes
     *
     * @param : autreObjet
     * @return : boolean si ils sont equal alors return true sinon return false
     * */
    @Override
    public boolean equals(Object autreObjet) {
        boolean resultat;
        if (!super.equals(autreObjet)) {
            resultat = false;
        }else{
            Gramme2 autre = (Gramme2) autreObjet;
            resultat = mot2.toLowerCase().equals(autre.mot2.toLowerCase());
        }
        return resultat;
    }

    @Override
    public String toString() {
        return super.toString() + "," + "\"" + mot2 + "\"";
    }
}
