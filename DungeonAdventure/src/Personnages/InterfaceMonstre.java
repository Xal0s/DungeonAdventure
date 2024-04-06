package Personnages;

import Objets.TypePotion;
import Objets.*;
import Personnages.*;
import Armes.*;
/**
 * Interface décrivant les comportements communs à tous les monstres.
 * Les monstres implémentant cette interface doivent fournir des méthodes pour obtenir et définir leur type ainsi que leur potion associée.
 * @author TPRECO 2023
 * @version 0.5
 * @since 7/12/2023
 */
public interface InterfaceMonstre {
    /**
     * Obtient le type de monstre.
     *
     * @return Le type de monstre correspondant à l'implémentation.
     */
    TypeDeMonstre obtenirTypeDeMonstre();
    /**
     * Obtient le type de potion du monstre.
     *
     * @return Le type de potion associé au monstre.
     */
    TypePotion getTypePotion();
    /**
     * Définit le type de potion du monstre.
     *
     * @param typePotion Le type de potion à attribuer au monstre.
     */
    void setTypePotion(TypePotion typePotion);
}
