package Personnages;

import Armes.Morsure;
import Armes.TypeArmeHeros;
import Objets.TypePotion;

/**
 * La classe Zombie est une fille de la classe Monstre qui implante l'interface InterfaceMonstre.
 * Créée une nouvelle instance de son arme, la Morsure.
 * Détermine que l'arme efficace contre lui est la Flèche_enflammée.
 * Lance l'attaque sur le héros.
 * Lance un coup critique tous les 4 coups.
 * Affiche les informations du combat sur la console.
 *
 * @author TP RECO 2023
 * @version 0.5
 * @since 07/12/2023
 * @return typePotion, TypeDeMonstre.ZOMBIE
 */
public class Zombie extends Monstre implements InterfaceMonstre {


    public Zombie() {
        this.m_iPointsDeVie = 30;
        this.m_Arme = new Morsure();
        this.m_eTypeDArmeEfficace = TypeArmeHeros.FLAMME;
        this.pointsDeDommage = 12;
        TypePotion m_typePotion = this.m_TypePotion;

    }


    public void attaque(PersonnageDonjon p_Heros) {
        System.out.println(
                "        .--._\n" +
                        "           '---._)\n" +
                        "            Q Q )\n" +
                        "            c  /\n" +
                        "          .-;-'-,.__\n" +
                        "    \\)) _/--o---o --)\n" +
                        "    (_(=   ,H---H --|\n" +
                        "      '----'\\---))) |\n" +
                        "             \\_=(_(/\n" +
                        "             /      )\n" +
                        "            /   \\   \\\n" +
                        "           /   / \\   \\\n" +
                        "          |   |   '.  '.\n" +
                        "          |___|     \\___\\\n" +
                        "snd        |_|         \\_\\\n" +
                        "          /  )         /  )\n" +
                        "          '-'          '-'" +
                        "\n\t\t\t\tLe zombie a très faim, il fonce sur vous et vous mord."
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
            System.out.println("\t\t\t\tDommage, pas de potions sur ce Zombie.");
        }
    }
    @Override
    public TypePotion getTypePotion() {
        return typePotion;
    }
    @Override
    public TypeDeMonstre obtenirTypeDeMonstre() {
        return TypeDeMonstre.ZOMBIE;
    }
    @Override
    public void setTypePotion(TypePotion typePotion) {
        this.typePotion = typePotion;
    }
}
