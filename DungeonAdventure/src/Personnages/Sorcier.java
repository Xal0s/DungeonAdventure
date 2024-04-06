package Personnages;

import Armes.Fiole;
import Armes.Eclair;
import Armes.TypeArmeHeros;
import Objets.TypePotion;

/**
 * La classe Sorcier est une fille de la classe Monstre qui implante l'interface InterfaceMonstre.
 * Créée une nouvelle instance de son arme, l'Eclair.
 *  * Détermine que l'arme efficace contre lui est l'Eau_magique.
 * Lance l'attaque sur le héros.
 * Lance un coup critique tous les 4 coups.
 * Affiche les informations du combat sur la console.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return typePotion, TypeDeMonstre.SORCIER
 */
public class Sorcier extends Monstre implements InterfaceMonstre {

   private int dommageCumuleEauMagique = 0;

   public Sorcier() {
      this.m_iPointsDeVie = 60;
      this.m_Arme = new Eclair();
      this.m_eTypeDArmeEfficace = TypeArmeHeros.FIOLE;
      this.pointsDeDommage = 15;
      this.dommageCumuleEauMagique=0;
      TypePotion m_typePotion = this.m_TypePotion;

   }

   public void attaque(PersonnageDonjon p_Heros) {
      System.out.println(
              "\n" +
                      "                             /\\\n" +
                      "                            /  \\\n" +
                      "                           |    |\n" +
                      "                         --:'''':--\n" +
                      "                           :'_' :\n" +
                      "                           _:\"\":\\___\n" +
                      "            ' '      ____.' :::     '._\n" +
                      "           . *=====<<=)           \\    :\n" +
                      "            .  '      '-'-'\\_      /'._.'\n" +
                      "                             \\====:_ \"\"\n" +
                      "                            .'     \\\\\n" +
                      "                           :       :\n" +
                      "                          /   :    \\\n" +
                      "                         :   .      '.\n" +
                      "                         :  : :      :\n" +
                      "                         :__:-:__.;--'\n" +
                      "                         '-'   '-'" +
                      "\t\t\t\tLe sorcier lance des éclairs sur vous."
      );
      this.m_Arme.verifierEvenement(p_Heros);
      p_Heros.recevoirDommages(this.pointsDeDommage);
   }


   @Override
   protected void coupCritique(PersonnageDonjon p_Heros) {
      int originalDmg = pointsDeDommage;
      System.out.println("\t\t\t\tCoup critique, aïe ! Les dommages sont doublés.");
      pointsDeDommage *= 2;
      System.out.println("\t\t\t\tDégâts après coup critique : " + pointsDeDommage);
      m_Arme.verifierEvenement(p_Heros);
      pointsDeDommage = originalDmg;
   }
   public void fouillerMonstre(Heros heros) {
      if (typePotion != null) {
         switch (typePotion) {
            case POTION_DE_VIE:
               System.out.println("\t\t\t\tLe Barbare avait une Potion de Vie.");
               heros.setM_iPointsDeVie(20); // Adjust the amount as needed
               break;
            case POTION_DE_FORCE:
               System.out.println("\t\t\t\tLe Barbare avait une Potion de Force.");
               heros.augmenterForce(10); // Adjust the amount as needed
               break;
         }
      } else {
         System.out.println("\t\t\t\tDommage, pas de potions sur ce Sorcier.");
      }
   }
   @Override
   public TypePotion getTypePotion() {
      return typePotion;
   }
   @Override
   public TypeDeMonstre obtenirTypeDeMonstre() {
      return TypeDeMonstre.SORCIER;
   }
   @Override
   public void setTypePotion(TypePotion typePotion) {
      this.typePotion = typePotion;
   }
}
