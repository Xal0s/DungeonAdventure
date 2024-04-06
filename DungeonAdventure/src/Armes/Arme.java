package Armes; /**
 * Armes.Arme est la classe mère et abstraite qui conditionne toutes les classes d'armes
 */
import Objets.*;
import Personnages.*;
import Armes.*;

import java.util.Random;

public abstract class Arme {

   static Random s_ProbaArme = new Random();



   public abstract void verifierEvenement(PersonnageDonjon variablePersonnageDonjon);
}
