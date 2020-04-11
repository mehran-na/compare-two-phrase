import java.util.ArrayList;

public class Inventaire {
    //Fields:
    private ArrayList<Gramme1> grammes1 = new ArrayList<>();
    private ArrayList<Gramme2> grammes2 = new ArrayList<>();
    private ArrayList<Gramme3> grammes3 = new ArrayList<>();
    private ArrayList<Gramme4> grammes4 = new ArrayList<>();

    private String phrase;

    //Constructors:

    public Inventaire(String phrase) {
        this.phrase = phrase;
    }

    //Methods:

    public void creerGrmme1() {
        String[] mots = phrase.split("\\s+");
        for(String item : mots) {
            grammes1.add(new Gramme1(item));
        }
    }

    public void creerGrmme2() {
        String[] mots = phrase.split("\\s+");
        if (mots.length >= 2) {
            for(int i = 0; i < mots.length - 1; i++) {
                grammes2.add(new Gramme2(mots[i], mots[i + 1]));
            }
        }
    }

    public void creerGrmme3() {
        String[] mots = phrase.split("\\s+");
        if (mots.length >= 3) {
            for(int i = 0; i < mots.length - 2; i++) {
                grammes3.add(new Gramme3(mots[i], mots[i + 1], mots[i + 2]));
            }
        }
    }

    public void creerGrmme4() {
        String[] mots = phrase.split("\\s+");
        if (mots.length >= 4) {
            for(int i = 0; i < mots.length - 3; i++) {
                grammes4.add(new Gramme4(mots[i], mots[i + 1], mots[i + 2], mots[i + 3]));
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(Gramme1 item : grammes1) {
            str += item.getMot1() + " , ";
        }
        str += "\n";
        for(Gramme2 item : grammes2) {
            str += "(" + item.getMot1() + "," + item.getMot2() + ") , ";
        }
        str += "\n";
        for(Gramme3 item : grammes3) {
            str += "(" + item.getMot1() + "," + item.getMot2() + "," + item.getMot3() + ") , ";
        }
        str += "\n";
        for(Gramme4 item : grammes4) {
            str += "(" + item.getMot1() + "," + item.getMot2() + "," + item.getMot3() + "," + item.getMot4() +") , ";
        }
        return str;
    }
}
