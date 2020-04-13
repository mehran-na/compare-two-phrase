public class PhraseModifie {
    //Fields:
    private String phrase;
    //Constructors:

    public PhraseModifie(String phrase) {
        if(phrase.length() != 0){
            String phraseLocal = enleverPointFinDeString(phrase);
            phraseLocal = changerNonLettrehAvecSpace(phraseLocal);
            this.phrase = phraseLocal.trim().replaceAll("\\s{2,}", " ");
        }else {
            System.err.println("Phrase est vide !!");
            System.exit(-1);
        }
    }

    //Methods:

    

    private String enleverPointFinDeString(String str) {
        char c = str.charAt(str.length() - 1);
        if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private String changerNonLettrehAvecSpace(String str) {
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
