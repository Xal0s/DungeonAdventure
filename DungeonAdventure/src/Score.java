import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score {
    private static final String SCORES_FILE = "scores.csv";

    public static void sauvegarderScore(String nomJoueur, int numeroPartie, int score) {
        try (FileWriter writer = new FileWriter(SCORES_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            if (nomJoueur != null && !nomJoueur.isEmpty()) {
                printWriter.println(nomJoueur + "," + numeroPartie + "," + score);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void afficherScoresJoueur(String nomJoueur, int score) {
        List<String[]> scores = lireScores();

        System.out.println("\t\t\tScores de " + nomJoueur + " :");
        for (String[] scoreArray : scores) {
            if (scoreArray[0].equals(nomJoueur)) {
                System.out.println("\t\t\tPartie " + scoreArray[1] + ": " + score + " points");
            }
        }
    }

    public static void afficherTopScores() {
        System.out.println("\n\t\t\tTop scores :\n");
        List<String[]> scores = lireScores();

        if (scores.isEmpty()) {
            System.out.println("\nIl n'y a pas encore de scores enregistrés.");
            return;
        }

        scores.sort(Comparator.comparingInt(scoreArray -> {
            if (scoreArray.length >= 3) {
                return Integer.parseInt(scoreArray[2]);
            } else {
                return 0;
            }
        }));
        Collections.reverse(scores);

        for (int i = 0; i < Math.min(5, scores.size()); i++) {
            String[] scoreArray = scores.get(i);
            if (scoreArray.length >= 3) {
                System.out.println("\t\t\t" + scoreArray[0] + " - Partie " + scoreArray[1] + ": " + scoreArray[2] + " points");
            }
        }
    }

    private static List<String[]> lireScores() {
        List<String[]> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(SCORES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                scores.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scores;
    }
}
