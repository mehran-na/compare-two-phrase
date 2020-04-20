public class Gramme1 {
    //Fields:
    private String mot1;


    //Constructors:
    public Gramme1(String mot1) {
        this.mot1 = mot1;
    }

    //Getters:
    public String getMot1() {
        return mot1;
    }

    @Override
    public boolean equals(Object otherObject) {
        boolean result;
        // a quick test to see if the objects are identical
        if (this == otherObject) {
            result = true;
        }else if (otherObject == null) {
            // must return false if the explicit parameter is null
            result = false;
        }else if (getClass() != otherObject.getClass()) {
            // if the classes don't match, they can't be equal
            result = false;
        }else{
            // now we know otherObject is a non-null Employee
            Gramme1 other = (Gramme1) otherObject;
            // test whether the fields have identical values
            result = mot1.toLowerCase().equals(other.mot1.toLowerCase());
        }
        return result;
    }
}

