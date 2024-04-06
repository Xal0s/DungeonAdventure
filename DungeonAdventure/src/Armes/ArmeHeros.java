package Armes;
import Objets.*;
import Personnages.*;
import Armes.*;

public abstract class ArmeHeros extends Arme {
   public static ArmeHeros creerTypeArme(TypeArmeHeros valeur) {
      switch(valeur) {
         case EPEE:
            return new Epee();
         case FIOLE:
            return new Fiole();
         case FLECHE:
            return new Fleche();
         case LANCE:
            return new Lance();
         case FLAMME:
            return new Flamme();
         case EXCALIBUR:
            return new Excalibur();
         default:
            return new Epee();
      }
   }
}





