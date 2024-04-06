package Armes;
import Objets.*;
import Personnages.*;
import Armes.*;
/**
 * Classe fille de la classe Arme.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 */
public class SceptreMaudit extends Arme {
    public void verifierEvenement (PersonnageDonjon p_Heros) {
        if (s_ProbaArme.nextInt(100) < 20 && p_Heros instanceof Paralyze) {
            ((Paralyze) p_Heros).setParalyze();
        }
    }
}