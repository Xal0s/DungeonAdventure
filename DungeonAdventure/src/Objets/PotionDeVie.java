package Objets;
import Objets.*;
import Personnages.*;
import Armes.*;

public class PotionDeVie extends Objet {
    private int pointsDeVie;

    public PotionDeVie() {
        this.pointsDeVie = 10;
    }

    public void utiliser(Heros heros) {
        heros.augmenterVie(pointsDeVie);
        System.out.println("\t\t\t\tVous avez utilisé une Potion de Vie. Vous avez récupéré " + pointsDeVie + " points de vie.");
    }
}
