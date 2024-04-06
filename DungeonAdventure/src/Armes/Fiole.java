package Armes;

import Personnages.PersonnageDonjon;

/**
 * Eau_magique : classe fille de ArmeHeros
 * Elle permet de créer différents types d'armes utilisées par le héros dans le jeu.
 * Cette classe comporte une méthode verifierEvenement
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */

public class Fiole extends ArmeHeros {
   private PersonnageDonjon m_Ennemi = null;
   private static int cumulDommages = 0;

   public void verifierEvenement(PersonnageDonjon p_PersonnageDonjon) {
      if (this.m_Ennemi != p_PersonnageDonjon) {
         this.remiseAZeroDuBonus(p_PersonnageDonjon);
         this.m_Ennemi = p_PersonnageDonjon;
      } else {
         cumulDommages += 5;
         if (cumulDommages > 20) {
            cumulDommages = 20;
         }
         System.out.println(
                 "\t\t\t\tUne autre fiole d'eau magique touche le méchant sorcier" +
                         "\n\t\t\t\tet ajoute de l'eau qui s'accumule à ses pieds, " +
                         "\n\t\t\t\tvos dégâts sont augmentés de 5" +
                         "\n\t\t\t\tDégâts cumulés : " + cumulDommages);
      }
   }

   private void remiseAZeroDuBonus(PersonnageDonjon p_PersonnageDonjon) {
      System.out.println("\t\t\t\tLes dégâts de l'eau magique sont réinitialisés");
      cumulDommages = 0;
   }

   public static int getCumulDommages() {

      return cumulDommages;
   }

   public static void remiseAZeroCumulDommages() {
      cumulDommages = 0;
   }
}
