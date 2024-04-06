package Personnages;

import Armes.SceptreMaudit;
import Armes.TypeArmeHeros;
import Objets.TypePotion;
/**
 * Classe représentant le monstre Diablo.
 * Diablo est un monstre spécifique avec des comportements d'attaque particuliers.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */
public class Diablo extends Monstre implements InterfaceMonstre {

    private int nombreAttaques = 0;
    private TypePotion typePotion;
    /**
     * Constructeur de la classe Diablo.
     * Initialise les points de vie, l'arme et le type d'arme efficace de Diablo.
     */
    public Diablo() {
        this.m_iPointsDeVie = 150;
        this.m_Arme = new SceptreMaudit();
        this.m_eTypeDArmeEfficace = TypeArmeHeros.EXCALIBUR;
        this.pointsDeDommage = 35;
        TypePotion m_typePotion = this.m_TypePotion;

    }
    /**
     * Méthode d'attaque spécifique de Diablo contre un héros.
     * Diablo peut effectuer un coup critique tous les s_iTourMaxAvantCoupCritique tours.
     *
     * @param p_Heros Le héros contre lequel Diablo attaque.
     */
    public void attaque(PersonnageDonjon p_Heros) {
        System.out.println(
                "                            ,-.\n" +
                        "       ___,---.__          /'|`\\          __,---,___\n" +
                        "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                        "  ,'        |           ~'\\     /`~           |        `.\n" +
                        " /      ___//              `. ,'          ,  , \\___      \\\n" +
                        "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                        "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                        "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                        " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                        "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                        "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                        "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                        "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                        "eViL        /   /     ||--+--|--+-/-|     \\   \\\n" +
                        "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                        "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                        "             `-._,-'   `-._______,-'   `-._,-'" +
                        "\n\t\t\t\tVous avez dérangé Diablo, il est très en colère, " +
                        "\n\t\t\t\til vous donne un coup de sceptre."
        );
        this.m_Arme.verifierEvenement(p_Heros);
        p_Heros.recevoirDommages(this.pointsDeDommage);
    }

    /**
     * Surcharge de la methode coupCritique pour l'adapter a la version de Diablo
     * @param p_Heros
     */
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

    }
    @Override
    /**
     * Obtient le type de potion de Diablo.
     *
     * @return Le type de potion actuellement possédé par Diablo.
     */
    public TypePotion getTypePotion() {
        return typePotion;
    }
    /**
     * Obtient le type de monstre pour Diablo.
     *
     * @return Le type de monstre correspondant à Diablo.
     */
    @Override
    public TypeDeMonstre obtenirTypeDeMonstre() {
        return TypeDeMonstre.DIABLO;
    }
    /**
     * Définit le type de potion de Diablo.
     *
     * @param typePotion Le type de potion à attribuer à Diablo.
     */
    @Override
    public void setTypePotion(TypePotion typePotion) {
        this.typePotion = typePotion;
    }
}