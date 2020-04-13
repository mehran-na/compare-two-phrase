public class Gramme3 extends Gramme2 {
    //Fields:
    private String mot3;

    //Constructors:
    public Gramme3(String mot1, String mot2, String mot3) {
        super(mot1, mot2);
        this.mot3 = mot3;
    }

    public String getMot3() {
        return mot3;
    }

    //Methods:

    @Override
    public boolean equals (Object otherObject){
        boolean result;
        if(!super.equals(otherObject)){
            result = false;
        }else{
            Gramme3 other = (Gramme3) otherObject;
            result = mot3.equals(other.mot3);
        }
        return result;
    }
}
