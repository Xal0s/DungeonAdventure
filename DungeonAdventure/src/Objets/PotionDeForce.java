package Objets;
import Objets.*;
import Personnages.*;
import Armes.*;

public class PotionDeForce extends Objet {
    private int pointsDeForce;

    public PotionDeForce() {
        this.pointsDeForce = 20;
    }

    public void utiliser(Heros heros) {
        heros.augmenterForce(pointsDeForce);
        System.out.println("\t\t\t\tVous avez utilisé une Potion de Force. Votre force a augmenté de " + pointsDeForce + " points.");
    }

}
