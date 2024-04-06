package Personnages;

import Armes.TypeArmeHeros;
import Objets.TypePotion;
import Objets.PotionDeVie;
import Objets.PotionDeForce;


/**
 * Classe abstraite représentant un monstre du jeu.
 * Les monstres étendent cette classe et implémentent des comportements spécifiques.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */
public abstract class Monstre extends PersonnageDonjon {
   protected int nombreAttaques = 0;
   protected TypePotion m_TypePotion;
   private boolean fouilleEffectuee=false;

   protected static final int s_iTourMaxAvantCoupCritique = 4;
   protected TypeArmeHeros m_eTypeDArmeEfficace;
   /**
    * Obtient le type d'arme efficace pour le monstre.
    *
    * @return Le type d'arme efficace du monstre.
    */
   public TypeArmeHeros obtenirLArmeEfficace() {

      return this.m_eTypeDArmeEfficace;
   }
   int nbMonstresTues = 0;

   /**
    * Creation de la methode abstraite coupCritique qui servira aux classes heritieres
    * @param p_Heros
    */
   protected abstract void coupCritique(PersonnageDonjon p_Heros);

   public boolean siFouilleEffectuee() {
      return fouilleEffectuee;
   }

   public void setFouilleEffectuee(boolean fouilleEffectuee) {
      this.fouilleEffectuee = fouilleEffectuee;
   }
   public abstract void fouillerMonstre(Heros heros);

   /**
    * Méthode pour recevoir des dommages.
    * Affiche un message indiquant les dommages reçus par le monstre.
    *
    * @param p_iPointsDeDommage Les dommages reçus par le monstre.
    */
   public void recevoirDommages(int p_iPointsDeDommage) {

      super.recevoirDommages(p_iPointsDeDommage);

      System.out.printf("\t\t\t\tLe %s a perdu %d points de vie.\n", this.getClass().getSimpleName(), p_iPointsDeDommage);

      this.setEstMort(this.estMort());

      if (!this.m_bEstMort) {
         System.out.printf("\t\t\t\tIl n'a plus que %d points de vie restant.\n", this.m_iPointsDeVie);
      }

      if (this.m_bEstMort && this.peutFaireCoupCritique()) {
         this.coupCritique(null);
      }
      if (this.m_bEstMort) {

         System.out.printf(
                 "\n\n\t\t|"+"-".repeat(70)+"|\n\n"+
                 "\t\t\t\tFélicitations, le %s est mort.\n\n"+
                 "\t\t|"+"-".repeat(70)+"|\n\n",
                 this.getClass().getSimpleName()
         );

      }
   }

   private boolean peutFaireCoupCritique() {
      return (nombreAttaques % s_iTourMaxAvantCoupCritique == 0) && (nombreAttaques > 0);
   }
   protected void attaqueAvecCoupCritique(PersonnageDonjon p_Heros) {
      if (peutFaireCoupCritique()) {
         coupCritique(p_Heros);
   /**
    * Méthode pour définir si le monstre est mort ou non.
    * Affiche un message approprié si le monstre est mort.
    *
    * @param p_bEstMort Indique si le monstre est mort ou non.
    */
      }
      nombreAttaques++;
   }
   protected void setEstMort(boolean p_bEstMort) {
      if (!this.m_bEstMort) {
         this.m_bEstMort = p_bEstMort;
         if (p_bEstMort) {

            nbMonstresTues++;
         }
      }
   }
   public TypePotion getTypePotion() {
      if (estMort() && m_TypePotion != null) {
         return m_TypePotion;
      } else {
         return null;
      }
   }
}