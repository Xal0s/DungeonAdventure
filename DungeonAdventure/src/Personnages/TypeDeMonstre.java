package Personnages;
import Objets.*;
import Personnages.*;
import Armes.*;

/**
 * La classe TypeDeMonstre est une énumération des différents types de monstres.
 * Retourne une nouvelle instance de TypeDeMonstre [].
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return typeDeMonstre[]
 */
public enum TypeDeMonstre {
   BARBARE,
   SORCIER,
   TROLL,
   VOLEUR,
   ZOMBIE,
   DIABLO;

   private static TypeDeMonstre[] $valeurs() {
      return new TypeDeMonstre[]{BARBARE, SORCIER,TROLL,VOLEUR,ZOMBIE,DIABLO};
   }
}
