public class Gramme3 extends Gramme2 {
    //Fields:
    private String mot3;

    //Constructors:
    public Gramme3(String mot1, String mot2, String mot3) {
        super(mot1, mot2);
        this.mot3 = mot3;
    }

    //Methods:

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
            Gramme3 autre = (Gramme3) autreObjet;
            resultat = mot3.toLowerCase().equals(autre.mot3.toLowerCase());
        }
        return resultat;
    }

    @Override
    public String toString() {
        return super.toString() + "," + "\"" + mot3 + "\"";
    }
}
