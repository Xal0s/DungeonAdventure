package Personnages;

import Armes.Hache;
import Armes.Paralyze;
import Armes.TypeArmeHeros;
import Objets.*;
/**
 * la classe Barbare hérite de la classe Monstre et sert de modèle aux ennemis de type Barbare.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */

public class Barbare extends Monstre implements Paralyze, InterfaceMonstre {
   /**
    * Sert à savoir si le Barbare est paralysé en renvoyant true ou false
    */
   private boolean m_bEstParalyse;
   /**
    * Defini un nombre maximum de tour avant que l'instance de Barbare n'effectue un Coup Critique
    */
   private static final int s_iTourMaxAvantCoupCritique = 4;
   /**
    * Attribut qui va s'incrementer au fur et a mesure du nombre d'attque de l'instance de Barbare
    */
   private int nombreAttaques = 0;
   /**
    * TypePotion sert à savoir lorsque le Barbare possede une potion si il s'agit d'une potion de force ou de soin
    */
   private TypePotion typePotion;

   /**
    * constructeur qui permet de definir les attribut de toutes les instances de la classe Barbare
    */
   public Barbare() {
      this.m_iPointsDeVie = 40;
      this.m_Arme = new Hache();
      this.m_eTypeDArmeEfficace = TypeArmeHeros.EPEE;
      this.pointsDeDommage = 20;
      TypePotion m_TypePotion = this.m_TypePotion;
   }

   /**
    * Attaque est la methode que toutes les instances de Barbare utilisent pour infliger des degats au Heros
    * Qui prends en compte le nombre d'attaque avant coup critique
    * @param p_Heros
    */
   public void attaque(PersonnageDonjon p_Heros) {
      if (this.m_bEstParalyse) {
         this.m_bEstParalyse = false;
         System.out.println("\t\t\t\tLe Barbare est étourdi pour ce tour et ne peut pas attaquer.");
      } else {
         System.out.println("        /|\n" +
                 "  _______________)|.. \n" +
                 "<'______________<(,_|) \n" +
                 "           .((()))| )) << YEAAYAAAAEAAAARGH!! >>\n" +
                 "           (======)| \\ \n" +
                 "          ((( \"_\"()|_ \\\n" +
                 "         '()))(_)/_/ ' )\n" +
                 "         .--/_\\ /(  /./\n" +
                 "        /'._.--\\ .-(_/  \n" +
                 "       / / )\\___:___) \n" +
                 "      ( -.'.._  |  /\n" +
                 "       \\  \\_\\ ( | )\n" +
                 "        '. /\\)_(_)|\n" +
                 "          '-|  XX |\n" +
                 "           %%%%%%%%\n" +
                 "          / %%%%%%%\\\n" +
                 "         ( /.-'%%%. \\ \n" +
                 "        /(.'   %%\\ :|\n" +
                 "       / ,|    %  ) )\n" +
                 "     _|___)   %  (__|_\n" +
                 "     )___/       )___(\n" +
                 "      |x/      mrf\\ >\n" +
                 "      |x)         / '.\n" +
                 "      |x\\       _(____''.__\n" +
                 "    --\\ -\\--\n" +
                 "     --\\__|--" +
                 "\n\t\t\t\tLe barbare vous frappe avec sa hache.");
         this.m_Arme.verifierEvenement(p_Heros);
         p_Heros.recevoirDommages(this.pointsDeDommage);
      }
   }

   /**
    * Surcharge de la methode coupCritique pour l'adapter a la version du Barbare
    * @param p_Heros
    */
   @Override
   protected void coupCritique(PersonnageDonjon p_Heros) {
      int originalDmg = pointsDeDommage;
      System.out.println("\t\t\t\tCoup critique, aïe ! Les dommages sont doublés.");
      pointsDeDommage *= 2;
      System.out.println("\t\t\t\tDégâts après coup critique : " + pointsDeDommage);
      m_Arme.verifierEvenement(p_Heros);
      pointsDeDommage = originalDmg;
   }

   /**
    * setparalyzed est un setter qui permet de changer la valeur de m_bEstParalyse en true ce qui empeche le Barbare d'attaque au prochain tour
    */
   public void setParalyze() {
      this.m_bEstParalyse = true;
   }

   /**
    * Methode pour permettre au heros de fouiller un monstre une fois battu et trouver des potions
    * @param heros
    */
   public void fouillerMonstre(Heros heros) {
      if (typePotion != null) {
         switch (typePotion) {
            case POTION_DE_VIE:
               System.out.println("\t\t\t\tLe Barbare avait une Potion de Vie.");
               heros.setM_iPointsDeVie(20);
               break;
            case POTION_DE_FORCE:
               System.out.println("\t\t\t\tLe Barbare avait une Potion de Force.");
               heros.augmenterForce(10);
               break;
         }
      } else {
         System.out.println("\t\t\t\tDommage, pas de potions sur ce Barbare.");
      }
   }
   /**
    * getTypePotion est un getter qui permet de retourner si le Barbare possede une potion de force ou une potion de soin
    * @return
    */
   @Override
   public TypePotion getTypePotion() {
      return typePotion;
   }

   /**
    * obtenirTypeDeMonstre est une methode que l'on surcharge pour chaque type de monstre que l'on peut rencontrer afin
    * de pouvoir savoir quels degats il va infliger au heros et quelle arme sera efficace contre lui.
    * @return
    */
   @Override
   public TypeDeMonstre obtenirTypeDeMonstre() {
      return TypeDeMonstre.BARBARE;
   }

   /**
    * setTypePotion est un setter qui nous permet de modifier le type de potion que le barbare possede au besoin
    * @param typePotion
    */
   @Override
   public void setTypePotion(TypePotion typePotion) {
      this.typePotion = typePotion;
   }
}