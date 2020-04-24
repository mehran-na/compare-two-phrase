public class PhraseModifie {
    //Fields:
    private String phrase = "";

    //Constructors:
    public PhraseModifie(String phrase) {
        if (phrase.length() != 0) {
            String phraseLocal = correctionFinDeString(phrase);
            phraseLocal = changerNonLettreAvecSpace(phraseLocal);
            /*
            enlever aspace au début et à la fin et si il y a plus que une space ensemble
            elles vont changer avec une space
            */
            this.phrase = phraseLocal.trim().replaceAll("\\s{2,}", " ");
        }
    }

    //Méthods:

    /*
    * Enlever la ponctuation à la fain de la phrase
    *
    * @param String str : phrase pour modifier
    *
    * @return str
    * */

    private String correctionFinDeString(String str) {
        char c = str.charAt(str.length() - 1);
        if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /*
    * Transferer les symbols avec space
    * si il y a symbol dans phrase cette méthod la change avec space
    *
    * @param String str : la phrase
    *
    * @return str
    * */
    private String changerNonLettreAvecSpace(String str) {
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                str = str.substring(0, i) + " " + str.substring(i + 1);
            }
        }
        return str;
    }

    public String getPhrase() {
        return phrase;
    }
}
