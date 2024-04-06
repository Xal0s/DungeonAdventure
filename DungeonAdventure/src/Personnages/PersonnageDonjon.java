package Personnages;

import Armes.Arme;
import Objets.TypePotion;
/**
 * Classe abstraite, mère de Monstre et de Heros.
 * Réalise les méthodes de récupération des points de dommages infligés par le monstre en cours et d'affectation de ceux-ci aux points de vie du héros.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return m_bEstMort, typePotion, m_Arme
 */
public abstract class PersonnageDonjon {
   protected int m_iPointsDeVie;
   protected int pointsDeDommage;
   protected int pointsDeForce;


   protected boolean m_bEstMort;
   protected Arme m_Arme;
   protected TypePotion typePotion;
   public void attaque(PersonnageDonjon p_Personnage) {
      p_Personnage.recevoirDommages(this.getPointsDeDommage());
   }
   public boolean aPotion() {
      return typePotion != null;
   }

   public int getM_iPointsDeVie() {
      return m_iPointsDeVie;
   }

   public void setM_iPointsDeVie(int m_iPointsDeVie) {
      this.m_iPointsDeVie = m_iPointsDeVie;
   }

   public int getPointsDeDommage() {
      return pointsDeDommage+pointsDeForce;
   }

   public void recevoirDommages(int p_iPointsDeDommage) {
      if (!this.estMort()) {
         this.m_iPointsDeVie -= p_iPointsDeDommage;

         if (this.m_iPointsDeVie <= 0) {
            this.m_iPointsDeVie = 0; // Assure que les points de vie ne deviennent pas négatifs
            this.setEstMort(true);
         }
      }
   }

   protected abstract void setEstMort(boolean var1);

   public boolean estMort() {
      return this.m_bEstMort;
   }
}
