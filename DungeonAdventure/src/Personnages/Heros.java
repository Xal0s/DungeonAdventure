package Personnages;

import Armes.ArmeHeros;
import Armes.Fiole;
import Armes.Fiole;
import Armes.Paralyze;
import Armes.TypeArmeHeros;
import Objets.TypePotion;
import Personnages.InterfaceMonstre;
import Personnages.Monstre;
import Personnages.PersonnageDonjon;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Classe représentant le personnage héros du jeu.
 * Le héros possède des caractéristiques spéciales et des actions uniques.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */
public class Heros extends PersonnageDonjon implements Paralyze {
   private int pointsDeDommage;

   ArmeHeros[] m_Armes;
   private String nomJoueur;
   private boolean m_bEstParalyse;
   private Scanner rentreeJoueur;
   private int nbPotionsDeVie = 3;
   private int nbPotionsDeForce = 2;
   private int score = 0;
   private int m_iPointsDeVieDeBase = 300;
   private int compteurEauMagique = 0;

    /** Constructeur de la classe Héros.
    * Initialise les attributs du héros tels que ses points de vie, ses armes, etc.
    */

   public Heros() {
      this.rentreeJoueur = new Scanner(System.in);
      this.m_Armes = new ArmeHeros[TypeArmeHeros.values().length];

      for (int i = 0; i < this.m_Armes.length; ++i) {
         this.m_Armes[i] = ArmeHeros.creerTypeArme(TypeArmeHeros.values()[i]);
      }

      this.m_Arme = null;
      this.m_iPointsDeVie = 300;
      this.pointsDeForce = 0;
      this.pointsDeDommage = 10;
   }
   public void appliquerDegatsEauMagique() {
      compteurEauMagique++;
      System.out.printf("\t\t\t\tLe Sorcier a subi %d points de dégâts supplémentaires par l'eau magique.\n", 5);
      System.out.printf("\t\t\t\tIl a maintenant %d points de dégâts cumulés.\n", compteurEauMagique);
   }
   public void setNomJoueur(String nomJoueur) {
      this.nomJoueur = nomJoueur;
   }

   /**
    * Méthode d'attaque du héros contre un monstre.
    * Le héros peut contre-attaquer en fonction de l'arme qu'il possède.
    *
    * @param p_Monstre Le monstre contre lequel le héros attaque.
    */
   public void attaque(PersonnageDonjon p_Monstre) {
      if (this.m_bEstParalyse) {
         this.m_bEstParalyse = false;
      } else {
         System.out.println("\t\t\t\tRentrer dans la console " + this.m_Arme.getClass().getSimpleName() + " pour contre-attaquer.");
         String attaque = this.rentreeJoueur.nextLine();
         attaque = correcteurDeCase(attaque);
         if (attaque.equals(this.m_Arme.getClass().getSimpleName())) {
            this.m_Arme.verifierEvenement(p_Monstre);
            int dommagesCauses = obtenirDommagesCauses()+ Fiole.getCumulDommages();
            p_Monstre.recevoirDommages(dommagesCauses);
            if (this.m_Arme.getClass().getSimpleName().equals("Fiole")) {
               Fiole.remiseAZeroCumulDommages();
            }
         }
      }
   }


   protected int obtenirDommagesCauses() {
      return pointsDeDommage + pointsDeForce;
   }

   /**
    * Méthode permettant au héros de recevoir des dommages.
    * Elle met à jour les points de vie restants du héros après avoir reçu des dommages.
    *
    * @param p_iPointsDeDommage Les dommages reçus par le héros.
    */
   public void recevoirDommages(int p_iPointsDeDommage) {
      super.recevoirDommages(p_iPointsDeDommage);
      System.out.println(
              "\t\t\t\tVous avez perdu " + p_iPointsDeDommage + " points de vie." +
                      "\n\t\t\t\tVous avez " + this.m_iPointsDeVie + " points de vie restant."
      );
      if (m_iPointsDeVie <= 0) {
         setEstMort(true);
      }
   }
   /**
    * Méthode permettant de définir si le héros est mort ou non.
    * Affiche un message approprié si le héros est mort.
    *
    * @param p_bEstMort Indique si le héros est mort ou non.
    */
   protected void setEstMort(boolean p_bEstMort) {
      this.m_bEstMort = p_bEstMort;
      if (p_bEstMort) {
         System.out.println(
                 "\n\n|" + "~".repeat(100) + "|\n\n" +
                         "\t\t\t\tDommage, vous êtes mort. Vous avez perdu." +
                         "\n\n|" + "~".repeat(100) + "|\n\n"
         );
      }

   }
   /**
    * Méthode pour définir le héros comme étant paralysé.
    * Affiche un message indiquant que le héros a été paralysé.
    */
   public void setParalyze() {
      System.out.println("\t\t\t\tVous avez été paralysé.");
      this.m_bEstParalyse = true;
   }
   /**
    * Méthode pour augmenter les points de vie du héros.
    * Affiche un message indiquant l'augmentation des points de vie du héros.
    *
    * @param points Le nombre de points de vie à ajouter au héros.
    */
   public void augmenterVie(int points) {
      if (m_iPointsDeVie + points <= m_iPointsDeVieDeBase) {
         m_iPointsDeVie += points;
         System.out.println("\t\t\t\tLe héros a récupéré " + points + " points de vie, il a maintenant " + m_iPointsDeVie + " points de vie.");
      } else {
         System.out.println("\t\t\t\tVous ne pouvez pas dépasser vos points de vie initiaux, qui sont de " + m_iPointsDeVieDeBase);
      }
   }
   /**
    * Méthode pour augmenter la force du héros.
    * Affiche un message indiquant l'augmentation de la force du héros.
    *
    * @param points Le nombre de points de force à ajouter au héros.
    */
   public void augmenterForce(int points) {
      pointsDeForce += points;
      System.out.println("\t\t\t\tLe héros a " + points + " points de force en plus," +
              "\n\t\t\t\til a maintenant " + pointsDeForce + " points de force." +
              "\n\t\t\t\t(heureusement qu'il n'y a pas de contrôle anti-dopage au Moyen-Âge)"
      );
   }

   public void decouvrirEnnemi(Monstre p_Monstre) {
      System.out.println("\n\t\t\t\tDerrière la porte, il y a " + p_Monstre.getClass().getSimpleName());
      this.m_Arme = this.m_Armes[p_Monstre.obtenirLArmeEfficace().obtenirValeur()];
      if (nbPotionsDeVie > 0 || nbPotionsDeForce > 0){
         proposerPotions();}
   }

   public void fouillerMonstre(Monstre monstre) {
      monstre.fouillerMonstre(this);
   }

   public void proposerPotions() {
      int choixPotionsVie;
      int choixPotionsForce;
      Scanner scanner = new Scanner(System.in);

      System.out.println("\t\t\t\tVoulez-vous prendre des potions avant le combat suivant ?");

      if (nbPotionsDeVie > 0) {
         System.out.println("\t\t\t\tPotions de vie disponibles : " + nbPotionsDeVie);
         System.out.println("\t\t\t\tEntrez le nombre de potions de vie que vous souhaitez prendre:");

         choixPotionsVie = 0;
         while (true) {
            try {
               choixPotionsVie = scanner.nextInt();
            } catch (InputMismatchException e) {
               System.out.println("\t\t\t\tVous devez entrer un nombre.");
            }

            if (choixPotionsVie < 0) {
               System.out.println("\t\t\t\tVous ne pouvez pas prendre de potions négatives.");
            } else if (choixPotionsVie > nbPotionsDeVie) {
               System.out.println("\t\t\t\tVous ne possédez que " + nbPotionsDeVie + " potions de vie.");
            } else {
               break;
            }
         }
      } else {
         choixPotionsVie = 0;
      }

      if (nbPotionsDeForce > 0) {
         System.out.println("\t\t\t\tPotions de force disponibles : " + nbPotionsDeForce);
         System.out.println("\t\t\t\tEntrez le nombre de potions de force que vous souhaitez prendre:");

         choixPotionsForce = 0;
         while (true) {
            try {
               choixPotionsForce = scanner.nextInt();
            } catch (InputMismatchException e) {
               System.out.println("\t\t\t\tVous devez entrer un nombre.");
            }

            if (choixPotionsForce < 0) {
               System.out.println("\t\t\t\tVous ne pouvez pas prendre de potions négatives.");
            } else if (choixPotionsForce > nbPotionsDeForce) {
               System.out.println("\t\t\t\tVous ne possédez que " + nbPotionsDeForce + " potions de force.");
            } else {
               break;
            }
         }
      } else {
         choixPotionsForce = 0;
      }

      if (choixPotionsVie > 0 || choixPotionsForce > 0) {
         appliquerEffetsPotions(choixPotionsVie, choixPotionsForce);
      } else {
         System.out.println("\t\t\t\tVous décidez de ne pas prendre de potions.");
      }
   }

   /**
    * Methode pour utiliser les potions et appliquer les effets sur le heros
    * @param choixPotionsVie
    * @param choixPotionsForce
    */
   public void appliquerEffetsPotions(int choixPotionsVie, int choixPotionsForce) {
      if (choixPotionsVie > 0 && nbPotionsDeVie > 0) {
         int pointsDeVieRendus = choixPotionsVie * 10;
         augmenterVie(pointsDeVieRendus);
         nbPotionsDeVie -= choixPotionsVie;
      }

      if (choixPotionsForce > 0 && nbPotionsDeForce > 0) {
         int pointsDeForceAjoutes = choixPotionsForce * 20;
         augmenterForce(pointsDeForceAjoutes);
         nbPotionsDeForce -= choixPotionsForce;
      }
   }

   public int getNbPotionsDeForce() {
      return nbPotionsDeForce;
   }

   public int getNbPotionsDeVie() {
      return nbPotionsDeVie;
   }

   public void setScore(int newScore) {
      this.score = newScore;
   }
   /**
    * Méthode pour obtenir le score du héros.
    *
    * @return Le score actuel du héros.
    */
   public int getScore() {
      return score;
   }
   /**
    * Méthode pour initialiser les paramètres du héros en début de partie.
    * Permet au joueur de saisir son nom pour commencer une nouvelle partie.
    */
   public void initialiserPartie() {
      Scanner scanner = new Scanner(System.in);

      System.out.print("\t\t\t\tEntrez votre nom : ");
      nomJoueur = scanner.nextLine();

   }

   /**
    * Méthode pour obtenir le nom du joueur.
    *
    * @return Le nom du joueur.
    */
   public String getNomJoueur() {

      return nomJoueur;
   }
   private String correcteurDeCase(String input){
      if (input == null || input.isEmpty()){
         return input;
      }
      else{
         return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
      }
   }


}
