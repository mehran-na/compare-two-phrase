public class Gramme4 extends Gramme3 {
    //Fields:
    private String mot4;

    //constructors:
    public Gramme4(String mot1, String mot2, String mot3, String mot4) {
        super(mot1, mot2, mot3);
        this.mot4 = mot4;
    }

    //Getters:
    public String getMot4() {
        return mot4;
    }

    //Méthods :

    @Override
    public boolean equals (Object otherObject){
        boolean result;
        if(!super.equals(otherObject)){
            result = false;
        }else{
            Gramme4 other = (Gramme4) otherObject;
            result = mot4.equals(other.mot4);
        }
        return result;
    }
}
