import javax.swing.text.FieldView;
import java.util.*;

public class Inventaire {
    //Fields:
    private String nom = "";
    private String[] mots;

    private ArrayList<Gramme1> grammes1 = new ArrayList<>();
    private ArrayList<Gramme2> grammes2 = new ArrayList<>();
    private ArrayList<Gramme3> grammes3 = new ArrayList<>();
    private ArrayList<Gramme4> grammes4 = new ArrayList<>();

    private ArrayList<Integer> c = new ArrayList<>();
    private ArrayList<Double> r = new ArrayList<>();
    private ArrayList<Double> q = new ArrayList<>();
    private ArrayList<Double> F = new ArrayList<>();


    //Constructors:
    public Inventaire(String phrase, String nom) {
        mots = phrase.split("\\s+");
        this.nom = nom;
    }

    //Methods:

    /*
    * créer l'object de la classe Gramme1 et Ajouter dans arrayList grammes1
    *
    * */
    public void creerGrmme1() {
        if(!(mots.length == 1 && mots[0].equals(""))){
            for(String item : mots) {
                grammes1.add(new Gramme1(item));
            }
        }
    }

    /*
     * créer l'object de la classe Gramme2 et Ajouter dans arrayList grammes2
     *
     * */
    public void creerGrmme2() {
        if (mots.length >= 2) {
            for(int i = 0; i < mots.length - 1; i++) {
                grammes2.add(new Gramme2(mots[i], mots[i + 1]));
            }
        }
    }
    /*
     * créer l'object de la classe Gramme3 et Ajouter dans arrayList grammes3
     *
     * */
    public void creerGrmme3() {
        if (mots.length >= 3) {
            for(int i = 0; i < mots.length - 2; i++) {
                grammes3.add(new Gramme3(mots[i], mots[i + 1], mots[i + 2]));
            }
        }
    }

    /*
     * créer l'object de la classe Gramme4 et Ajouter dans arrayList grammes4
     *
     * */
    public void creerGrmme4() {
        if (mots.length >= 4) {
            for(int i = 0; i < mots.length - 3; i++) {
                grammes4.add(new Gramme4(mots[i], mots[i + 1], mots[i + 2], mots[i + 3]));
            }
        }
    }

    /*
    * Calculer c1, c2, c3, c4 et ajouter dans arraylist c
    *
    * @description : comparer 2 objets (inventaire de phrase generee et inventaire de phrase cible)
    *
    * @param Inventaire cible : l'objec Inventaire de la phrase cible
    *
    * */
    public void nombreGrammeCommun(Inventaire cible) {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        for(Gramme1 item : grammes1) {
            if (cible.grammes1.contains(item) && c1 < cible.grammes1.size())
                c1++;
        }

        for(Gramme2 item : grammes2) {
            if (cible.grammes2.contains(item) && c2 < cible.grammes2.size())
                c2++;
        }

        for(Gramme3 item : grammes3) {
            if (cible.grammes3.contains(item) && c3 < cible.grammes3.size())
                c3++;
        }

        for(Gramme4 item : grammes4) {
            if (cible.grammes4.contains(item) && c4 < cible.grammes4.size())
                c4++;
        }

        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
    }

    /*
    * calculer rapple (r1, r2, r3, r4) et ajouter dans arraylist r
    *
    * @description : Le rappel est le pourcentage de n grammes de la deuxième phrase(cible) qui ont été retrouvés dans
    * la première phrase (générée)
    *
    * @param : Inventaire cible : l'object inventaire de la phrase cible
    * */
    public void claculRappel(Inventaire cible) {
        r.add((double) c.get(0) / cible.grammes1.size());
        r.add((cible.grammes2.isEmpty()) ? 0.0 : (double) c.get(1) / cible.grammes2.size());
        r.add((cible.grammes3.isEmpty()) ? 0.0 : (double) c.get(2) / cible.grammes3.size());
        r.add((cible.grammes4.isEmpty()) ? 0.0 : (double) c.get(3) / cible.grammes4.size());
    }


    /*
    * calculer precision (q1, q2, q3, q4) et ajouter dans arraylist q
    *
    * @description : La précision est le pourcentage de n grammes de la première phrase(généré) qui ont été retrouvés
    * dans la deuxième phrase (cible).
    *
    * */
    public void claculPrecision() {
        q.add((double) c.get(0) / grammes1.size());
        q.add((grammes2.isEmpty() ? 0.0 : (double) c.get(1) / grammes2.size()));
        q.add((grammes3.isEmpty() ? 0.0 : (double) c.get(2) / grammes3.size()));
        q.add((grammes4.isEmpty() ? 0.0 : (double) c.get(3) / grammes4.size()));
    }

    /*
    * Calculer f-mesure (F1, F2, F3, F4) et ajouter dans arraylist f
    *
    * @description : f- mesure qui est une combinaison du rappel et de la précision.
    * */
    public void claculMesure() {
        for(int i = 0; i < 4; i++) {
            F.add((r.get(i) == 0 && q.get(i) == 0) ? 0.0 : 2 * (r.get(i) * q.get(i)) / (r.get(i) + q.get(i)));
        }
    }

    //override méthod toString()
    @Override
    public String toString() {
        String str = "";
        str += "\n1-grammes de la " + nom + " = [" + afficherGrammes1() + "]\n";
        str += "2-grammes de la " + nom + " = [" + afficherGrammes2() + "]\n";
        str += "3-grammes de la " + nom + " = [" + afficherGrammes3() + "]\n";
        str += "4-grammes de la " + nom + " = [" + afficherGrammes4() + "]";
        return str;
    }

    /*
    * créer string de la 1-grammes pour afficher dans console
    *
    *@return String str
    * */
    private String afficherGrammes1() {
        String str = "";
        if (!grammes1.isEmpty()) {
            for(int i = 0; i < grammes1.size(); i++) {
                if (i != grammes1.size() - 1)
                    str += grammes1.get(i).toString() + ", ";
                else
                    str += grammes1.get(i).toString();
            }
        }
        return str;
    }

    /*
     * créer string de la 2-grammes pour afficher dans console
     *
     *@return String str
     * */
    private String afficherGrammes2() {
        String str = "";
        if (!grammes2.isEmpty()) {
            for(int i = 0; i < grammes2.size(); i++) {
                if (i != grammes2.size() - 1)
                    str += "(" + grammes2.get(i).toString() + ")" + ", ";
                else
                    str += "(" + grammes2.get(i).toString() + ")";
            }
        }
        return str;
    }

    /*
     * créer string de la 3-grammes pour afficher dans console
     *
     *@return String str
     * */
    private String afficherGrammes3() {
        String str = "";
        if (!grammes3.isEmpty()) {
            for(int i = 0; i < grammes3.size(); i++) {
                if (i != grammes3.size() - 1)
                    str += "(" + grammes3.get(i).toString() + ")" + ", ";
                else
                    str += "(" + grammes3.get(i).toString() + ")";
            }
        }
        return str;
    }

    /*
     * créer string de la 4-grammes pour afficher dans console
     *
     *@return String str
     * */
    private String afficherGrammes4() {
        String str = "";
        if (!grammes4.isEmpty()) {
            for(int i = 0; i < grammes4.size(); i++) {
                if (i != grammes4.size() - 1)
                    str += "(" + grammes4.get(i).toString() + ")" + ", ";
                else
                    str += "(" + grammes4.get(i).toString() + ")";
            }
        }
        return str;
    }

    /*
    * préparer  cardinalité, rapple, précision et f-mesures pour afficher dans console
    *
    *@return String str
    * */
    public String afficherResultat() {
        String str = "\n";
        str +=
                "c1= " + c.get(0) + ", " + "c2= " + c.get(1) + ", " + "c3= " + c.get(2) + ", " + "c4= " + c.get(3) + "\n" +
                        "r1= " + r.get(0) + ", " + "r2= " + r.get(1) + ", " + "r3= " + r.get(2) + ", " + "r4= " + r.get(3) + "\n" +
                        "q1= " + q.get(0) + ", " + "q2= " + q.get(1) + ", " + "q3= " + q.get(2) + ", " + "q4= " + q.get(3) + "\n" +
                        "F1= " + F.get(0) + ", " + "F2= " + F.get(1) + ", " + "F3= " + F.get(2) + ", " + "F4= " + F.get(3);
        return str;

    }
}
