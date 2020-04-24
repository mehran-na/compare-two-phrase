public class Gramme4 extends Gramme3 {
    //Fields:
    private String mot4;

    //constructors:
    public Gramme4(String mot1, String mot2, String mot3, String mot4) {
        super(mot1, mot2, mot3);
        this.mot4 = mot4;
    }

    //Méthods :

    /*
     * Override method equals pour utilise dans comparaison des grammes
     *
     * @param : autreObjet
     * @return : boolean si ils sont equal alors return true sinon return false
     * */
    @Override
    public boolean equals (Object autreObjet){
        boolean resultat;
        if(!super.equals(autreObjet)){
            resultat = false;
        }else{
            Gramme4 autre = (Gramme4) autreObjet;
            resultat = mot4.toLowerCase().equals(autre.mot4.toLowerCase());
        }
        return resultat;
    }



    @Override
    public String toString() {
        return super.toString() + "," + "\"" + mot4 + "\"";
    }
}
