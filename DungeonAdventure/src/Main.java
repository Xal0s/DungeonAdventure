import Personnages.Heros;
import java.io.*;
import java.util.*;

public class Main {
   private static final String SCORES_FILE = "scores.csv";
   private static Scanner scanner;
   private static int numeroPartie = 0;

   /**
    * Classe Main.
    * Créée une instance de Heros.
    * Lance le jeu.
    *
    * @author TP RECO 2023
    * @version 0.4
    * @return
    * @since 07/12/2023
    */
   public static void main(String[] args) {
      System.out.println(
              "\t\t|" + "#".repeat(70) + "|\n\n" +
                      "\t\t\t\t\tBienvenue sur le jeu : Super Donjon Aventure" +
                      "\n\n\t\t\t\t\tCopyright : Kévin, Philippe, Robin, Walter\n\n" +
                      "\t\t|" + "#".repeat(70) + "|\n\n"
      );

      Heros heros = new Heros();
      heros.initialiserPartie();

      char retplayer;
      do {
         try {
            playGame(heros);
         } catch (Exception var3) {
            System.out.println("Error");
            var3.printStackTrace();
         }
         Score.sauvegarderScore(heros.getNomJoueur(), numeroPartie, heros.getScore());
         System.out.println(
                 "\n\n|" + "/".repeat(140) + "|\n\n" +
                         "\t\t\tVous avez terminé le jeu : Appuyez sur \"1\" pour continuer ou sur \"2\" pour quitter." +
                         "\n\n|" + "/".repeat(140) + "|\n\n"
         );

         for (retplayer = getPlayerInput(); retplayer != '1' && retplayer != '2'; retplayer = getPlayerInput()) {
            System.out.println("\t\t\tSeuls les touches 1 et 2 sont acceptées");
         }
/*
Choix du joueur : ne pas recommencer une partie.
 */
         if (retplayer == '2') {
            System.out.println("\t\t\tMerci d'avoir joué, à bientôt");
            Score.afficherScoresJoueur(heros.getNomJoueur(), heros.getScore());
            Score.afficherTopScores();
            System.exit(0);
         }
         Score.afficherScoresJoueur(heros.getNomJoueur(), heros.getScore());
         Score.afficherTopScores();

         numeroPartie++;
      } while (retplayer == '1');
   }

   private static void playGame(Heros heros) {

      int nbSalles;
      do {
         System.out.println("\n\t\t\t\tCombien de salles voulez-vous dans le donjon ?");
         String saisie = scanner.nextLine();

         try {
            nbSalles = Integer.parseInt(saisie);
         } catch (NumberFormatException e) {
            System.out.println("\t\t\t\tSaisissez un nombre entier positif.");
            continue;
         }

         if (nbSalles < 2 || nbSalles > 100) {
            System.out.println("\t\t\t\tLe nombre de salles doit être compris entre 2 et 100.");
            continue;
         }

         break;
      } while (true);
      System.out.println("\n\n|" + "*".repeat(140) + "|\n\n" +
              "\t\t\t\tVous êtes un héros courageux, " +
              "\n\t\t\t\tvous rentrez dans le donjon à vos risques et périls...\n\n" +
              "|" + "*".repeat(140) + "|\n\n");
      Donjon donjon = new Donjon(nbSalles, true);
      donjon.entrer(heros);

      if (!heros.estMort()) {
         System.out.println(
                 "\n\n|" + "*".repeat(140) + "|\n\n" +
                         "\t\t\t\tVous êtes arrivé à la salle du trésor ! Félicitations, vous avez gagné !!!!!!" +
                         "\n\n|" + "*".repeat(140) + "|\n"
         );

         int score = nbSalles;
         heros.setScore(score);

         incrementerNumeroPartie();
      }
   }

   private static void incrementerNumeroPartie() {
      numeroPartie++;
   }

   private static char getPlayerInput() {
      String input = scanner.nextLine();
      return input.charAt(0);
   }

   static {
      scanner = new Scanner(new InputStreamReader(System.in));
   }
}
