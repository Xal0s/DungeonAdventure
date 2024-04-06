package Personnages;

import Armes.Batte;
import Armes.TypeArmeHeros;
import Objets.TypePotion;

/**
 * La classe Troll est une fille de la classe Monstre qui implante l'interface InterfaceMonstre.
 * Créée une nouvelle instance de son arme, la Batte.
 * Détermine que l'arme efficace contre lui est la Lance.
 * Lance l'attaque sur le héros.
 * Lance un coup critique tous les 4 coups.
 * Affiche les informations du combat sur la console.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return typePotion, TypeDeMonstre.TROLL
 */
public class Troll extends Monstre implements InterfaceMonstre {


    public Troll() {
        this.m_iPointsDeVie = 50;
        this.m_Arme = new Batte();
        this.m_eTypeDArmeEfficace = TypeArmeHeros.LANCE;
        this.pointsDeDommage = 15;
        TypePotion m_typePotion = this.m_TypePotion;

    }


    public void attaque(PersonnageDonjon p_Heros) {
        System.out.println(
                "        .         __      '        .       '       .\n" +
                        "  *            _-~  ~-_      .         '      .\n" +
                        " .   .        /___  ___\\  '             .             .\n" +
                        "             / (O)  (o) \\         *         ___    *  .\n" +
                        "   __,-~-~-,/    -..-    \\  .-~~-.   __..-~~   ~~-.._\n" +
                        ".-~  `V~V~V'`\\ -v----v-   \\/     /.-~  //..  \\   \\.  `~-._\n" +
                        "  //.     \\.' `\\..___..---/    /''    .    '   .   .." +
                        "\n\t\t\t\tLe troll veut vous assommer pour vous ajouter à son menu de ce soir, " +
                        "\n\t\t\t\til vous donne un coup de batte."
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
            System.out.println("\t\t\t\tDommage, pas de potions sur ce Troll.");
        }
    }
    @Override
    public TypePotion getTypePotion() {
        return typePotion;
    }
    @Override
    public TypeDeMonstre obtenirTypeDeMonstre() {
        return TypeDeMonstre.TROLL;
    }
    @Override
    public void setTypePotion(TypePotion typePotion) {
        this.typePotion = typePotion;
    }
}
