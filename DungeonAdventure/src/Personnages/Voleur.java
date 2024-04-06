package Personnages;

import Armes.Dagues;
import Armes.TypeArmeHeros;
import Objets.TypePotion;

/**
 * La classe Voleur est une fille de la classe Monstre qui implante l'interface InterfaceMonstre.
 * Créée une nouvelle instance de son arme, la Dague.
 * Détermine que l'arme efficace contre lui est la Flèche.
 * Lance l'attaque sur le héros.
 * Lance un coup critique tous les 4 coups.
 * Affiche les informations du combat sur la console.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return typePotion, TypeDeMonstre.VOLEUR
 */
public class Voleur extends Monstre implements InterfaceMonstre {


    public Voleur() {
        this.m_iPointsDeVie = 35;
        this.m_Arme = new Dagues();
        this.m_eTypeDArmeEfficace = TypeArmeHeros.FLECHE;
        this.pointsDeDommage = 9;
        TypePotion m_typePotion = this.m_TypePotion;

    }


    public void attaque(PersonnageDonjon p_Heros) {
        System.out.println(
                "  __.------.                          \n" +
                        "                      (__  ___   )                         \n" +
                        "                        .)e  )\\ /                          \n" +
                        "                       /_.------                           \n" +
                        "                       _/_    _/                           \n" +
                        "                   __.'  / '   `-.__                       \n" +
                        "                  / <.--'           `\\                     \n" +
                        "                 /   \\   \\c           |                    \n" +
                        "                /    /    )  GoT  x    \\                   \n" +
                        "                |   /\\    |c     / \\.-  \\                  \n" +
                        "                \\__/  )  /(     (   \\   <>'\\               \n" +
                        "                     / _/ _\\-    `-. \\/_|_ /<>             \n" +
                        "                    / /--/,-\\     _ \\     <>.`.            \n" +
                        "                    \\/`--\\_._) - /   `-/\\    `.\\           \n" +
                        "                     /        `.     /   )     `\\          \n" +
                        "                     \\      \\   \\___/----'                 \n" +
                        "                     |      /    `(                    " +
                        "\n\t\t\t\tComme vous refusez de lui donner ce qu'il veut, " +
                        "\n\t\t\t\tle voleur vous donne des coups de dagues."
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
                    heros.setM_iPointsDeVie(20);
                    break;
                case POTION_DE_FORCE:
                    System.out.println("\t\t\t\tLe Barbare avait une Potion de Force.");
                    heros.augmenterForce(10);
                    break;
            }
        } else {
            System.out.println("\t\t\t\tDommage, pas de potions sur ce Voleur.");
        }
    }
    @Override
    public TypePotion getTypePotion() {
        return typePotion;
    }

    @Override
    public TypeDeMonstre obtenirTypeDeMonstre() {
        return TypeDeMonstre.VOLEUR;
    }
    @Override
    public void setTypePotion(TypePotion typePotion) {
        this.typePotion = typePotion;
    }
}
