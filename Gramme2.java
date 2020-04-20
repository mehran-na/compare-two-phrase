public class Gramme2 extends Gramme1 {
    //Fields:
    private String mot2;

    //Constructors:
    public Gramme2(String mot1, String mot2) {
        super(mot1);
        this.mot2 = mot2;
    }

    public String getMot2() {
        return mot2;
    }

    //Methods:

    @Override
    public boolean equals (Object otherObject){
        boolean result;
        if(!super.equals(otherObject)){
            result = false;
        }else{
            Gramme2 other = (Gramme2) otherObject;
            result = mot2.toLowerCase().equals(other.mot2.toLowerCase());
        }
        return result;
    }
}
