package Armes;
import Objets.*;
import Personnages.*;
import Armes.*;

/**
 * La classe Epee est une classe fille de la classe abstraite ArmeHeros.
 * Elle fournit ce type d'arme pour le héros dans le jeu.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */

public class Epee extends ArmeHeros {

   /**
    * Vérifie si un événement spécial se produit lorsque l'arme est utilisée contre un monstre.
    * Si certaines conditions sont remplies, comme une probabilité déterminée et le type de monstre,
    * un effet comme la paralysie peut être appliqué au monstre.
    *
    * @param p_PersonnageDonjon Le personnage du donjon (le monstre) contre lequel l'épée est utilisée.
    */

   public void verifierEvenement (PersonnageDonjon p_PersonnageDonjon) {
      if (s_ProbaArme.nextInt(100) < 10 && p_PersonnageDonjon instanceof Paralyze) {
         System.out.println(
                 "\t\t\t\tBien joué, vous avez touché le " + p_PersonnageDonjon.getClass().getSimpleName() + " à la tête," +
                         "\n\t\t\t\til est étourdi pour un tour et ne vous attaquera pas"
         );
         ((Paralyze)p_PersonnageDonjon).setParalyze();
      }
   }
}
