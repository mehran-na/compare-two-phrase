import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @description Méthod msgBienvenue, pour afficher le message de bienvenue
     */
    public static void msgBienvenue() {
        System.out.println("\n****************************************************************************************");
        System.out.println("\t\t\t\t" + Consts.MSG_BIENVENUE + Consts.AUTEUR);
    }

    /**
     * @description Méthod msgResume, pour afficher le message de résumé de programme
     */
    public static void msgResume() {
        System.out.println(Consts.MSG_RESUME);
        System.out.println("****************************************************************************************\n");
    }

    /**
     * @description Méthod msgFin, pour afficher le message de fin de programme
     */
    public static void msgFin() {
        System.out.println(Consts.MSG_FIN);
    }

    /**
     * @param prompt message pour demander phrase à l'utilisateur
     * @return phrase
     * @description Méthod lirePhrase, pour demander la phrase à l'utilisateur
     */
    public static String lirePhrase(String prompt) {
        String phrase = "";
        System.out.print(prompt);
        phrase = scanner.nextLine();
        return phrase;
    }
}
