package Personnages;
import Objets.*;
import Personnages.*;
import Armes.*;

import java.util.Random;
/**
 * La classe ConstructeurMonstre permet de créer des monstres de manière aléatoire.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */
public class ConstructeurMonstre {
   static Random rand = new Random();
   /**
    * Crée un monstre aléatoire parmi les différents types de monstres disponibles.
    *
    * @return Le monstre généré aléatoirement.
    */
   public static Monstre CreerMonstreAleatoire() {
      Monstre monstreARetourner = null;
      int choix = rand.nextInt(TypeDeMonstre.values().length);
      switch (TypeDeMonstre.values()[choix]) {
         case BARBARE:
            monstreARetourner = new Barbare();
            break;
         case SORCIER:
            monstreARetourner = new Sorcier();
            break;
         case TROLL:
            monstreARetourner = new Troll();
            break;
         case VOLEUR:
            monstreARetourner = new Voleur();
            break;
         case ZOMBIE:
            monstreARetourner = new Zombie();
            break;
         case DIABLO:
            monstreARetourner = new Diablo();
            break;
      }
      return monstreARetourner;
   }
}
