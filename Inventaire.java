import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventaire {
    //Fields:
    private String phrase;

    private ArrayList<Gramme1> grammes1 = new ArrayList<>();
    private ArrayList<Gramme2> grammes2 = new ArrayList<>(); //empty
    private ArrayList<Gramme3> grammes3 = new ArrayList<>();
    private ArrayList<Gramme4> grammes4 = new ArrayList<>();

    private ArrayList<Integer> c = new ArrayList<>();
    private ArrayList<Double> r = new ArrayList<>();
    private ArrayList<Double> q = new ArrayList<>();
    private ArrayList<Double> F = new ArrayList<>();


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

    //c1 :
    public void nombreGrammeCommun(Inventaire inventaire) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        for(Gramme1 item : grammes1) {
            if (inventaire.grammes1.contains(item))
                c1++;
        }

        for(Gramme2 item : grammes2) {
            if (inventaire.grammes2.contains(item))
                c2++;
        }

        for(Gramme3 item : grammes3) {
            if (inventaire.grammes3.contains(item))
                c3++;
        }

        for(Gramme4 item : grammes4) {
            if (inventaire.grammes4.contains(item))
                c4++;
        }

        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
    }

    //rappel :
    public void claculRappel(Inventaire cible) {
        r.add((double) c.get(0) / cible.grammes1.size());

        if (cible.grammes2.size() == 0) {
            r.add(0.0);
        }else{
            r.add((double) c.get(1) / cible.grammes2.size());
        }

        if (cible.grammes3.size() == 0) {
            r.add(0.0);
        }else{
            r.add((double) c.get(2) / cible.grammes3.size());
        }

        if (cible.grammes4.size() == 0) {
            r.add(0.0);
        }else{
            r.add((double) c.get(3) / cible.grammes4.size());
        }
    }


    //précision :
    public void claculPrecision() {
        q.add((double) c.get(0) / this.grammes1.size());

        if (this.grammes2.size() == 0) {
            q.add(0.0);
        }else{
            q.add((double) c.get(1) / this.grammes2.size());
        }

        if (this.grammes3.size() == 0) {
            q.add(0.0);
        }else{
            q.add((double) c.get(2) / this.grammes3.size());
        }

        if (this.grammes4.size() == 0) {
            q.add(0.0);
        }else{
            q.add((double) c.get(3) / this.grammes4.size());
        }
    }

    //f-mesures :
    public void claculMesure() {
        F.add(
                2 * (r.get(0) * q.get(0)) / (r.get(0) + q.get(0))
        );

        if (r.get(1) == 0 && q.get(1) == 0) {
            F.add(0.0);
        }else{
            F.add(
                    2 * (r.get(1) * q.get(1)) / (r.get(1) + q.get(1))
            );
        }

        if (r.get(2) == 0 && q.get(2) == 0) {
            F.add(0.0);
        }else{
            F.add(
                    2 * (r.get(2) * q.get(2)) / (r.get(2) + q.get(2))
            );
        }

        if (r.get(3) == 0 && q.get(3) == 0) {
            F.add(0.0);
        }else{
            F.add(
                    2 * (r.get(3) * q.get(3)) / (r.get(3) + q.get(3))
            );
        }

    }

    // @Override
    /*public String toString() {
        String str = "\n\n";

        str += "grammes1 ";
        if (grammes1 != null) {
            for(Gramme1 item : grammes1) {
                str += "(" + item.getMot1() + ") , ";
            }
        }else{
            str += "null";
        }


        str += "\n";
        str += "grammes2 ";
        if (grammes2.size() != 0) {
            for(Gramme2 item : grammes2) {
                str += "(" + item.getMot1() + "," + item.getMot2() + ") , ";
            }
        }else{
            str += "empty";
        }

        str += "\n";
        str += "grammes3 ";
        if (grammes3 != null) {
            for(Gramme3 item : grammes3) {
                str += "(" + item.getMot1() + "," + item.getMot2() + "," + item.getMot3() + ") , ";
            }
        }else{
            str += "null";
        }


        str += "\n";
        str += "grammes4 ";
        if(grammes4 != null){
            for(Gramme4 item : grammes4) {
                str += "(" + item.getMot1() + "," + item.getMot2() + "," + item.getMot3() + "," + item.getMot4() + ") , ";
            }
        }else {
            str += "null";
        }
        return str;
    }*/

    @Override
    public String toString() {
        return
                "\n" +
                        "c1= " + c.get(0) + ", " + "c2= " + c.get(1) + ", " + "c3= " + c.get(2) + ", " + "c4= " + c.get(3) + ", " +
                        "\n" +

                        "r1= " + r.get(0) + ", " + "r2= " + r.get(1) + ", " + "r3= " + r.get(2) + ", " + "r4= " + r.get(3) + ", " +
                        "\n" +

                        "q1= " + q.get(0) + ", " + "q2= " + q.get(1) + ", " + "q3= " + q.get(2) + ", " + "q4= " + q.get(3) + ", " +
                        "\n" +

                        "F1= " + F.get(0) + ", " + "F2= " + F.get(1) + ", " + "F3= " + F.get(2) + ", " + "F4= " + F.get(3);
    }
}
