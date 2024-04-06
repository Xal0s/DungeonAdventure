import Objets.Objet;
import Objets.TypePotion;
import Personnages.*;

import java.util.ArrayList;
import java.util.List;

public class Salle {
   Monstre m_Monstre = ConstructeurMonstre.CreerMonstreAleatoire();
   private List<Objet> m_ObjetList;
   private InterfaceMonstre m_MonstreMonstre;
   private static int nombreInstancesBarbare = 0;
   private static int nombreInstancesSorcier = 0;
   private static int nombreInstancesZombie = 0;
   private static int nombreInstancesTroll = 0;
   private static int nombreInstancesVoleur = 0;
   public Salle() {
      m_ObjetList = new ArrayList<>();
   }
   public Monstre getMonstre() {
      return m_Monstre;
   }
   public void ajouterObjet(Objet objet) {
      m_ObjetList.add(objet);
   }
   public void ajouterMonstre(TypeDeMonstre typeDeMonstre) {
      switch (typeDeMonstre) {
         case ZOMBIE:
            m_Monstre = new Zombie();
            nombreInstancesZombie++;
            break;
         case TROLL:
            m_Monstre = new Troll();
            nombreInstancesTroll++;
            break;
         case VOLEUR:
            m_Monstre = new Voleur();
            nombreInstancesVoleur++;
            break;
         case SORCIER:
            m_Monstre = new Sorcier();
            nombreInstancesSorcier++;
            break;
         case DIABLO:
            m_Monstre = new Diablo();
            break;
         case BARBARE:
            m_Monstre = new Barbare();
            nombreInstancesBarbare++;
            break;

      }
      setTypePotion();
   }
   private void setTypePotion() {
      if (m_MonstreMonstre != null) {
         TypeDeMonstre typeDeMonstre = m_MonstreMonstre.obtenirTypeDeMonstre();
         switch (typeDeMonstre) {
            case BARBARE:
               m_MonstreMonstre.setTypePotion((nombreInstancesBarbare % 2 == 0) ? TypePotion.POTION_DE_FORCE : TypePotion.POTION_DE_VIE);
               break;
            case SORCIER:
               m_MonstreMonstre.setTypePotion((nombreInstancesSorcier % 3 == 0) ? TypePotion.POTION_DE_VIE : null);
               break;
            case ZOMBIE:
               m_MonstreMonstre.setTypePotion((nombreInstancesZombie % 5 == 0) ? TypePotion.POTION_DE_FORCE : null);
               break;
            case TROLL:
               m_MonstreMonstre.setTypePotion((nombreInstancesTroll % 4 == 0) ? TypePotion.POTION_DE_FORCE : null);
               break;
            case VOLEUR:
               m_MonstreMonstre.setTypePotion((nombreInstancesVoleur % 6 == 0) ? TypePotion.POTION_DE_VIE : null);
               break;
            default:
               m_MonstreMonstre.setTypePotion(null);
               break;
         }
      }
   }

   public void ouvertureDeLaSallePourLeHeros(Heros p_heros) {
      Monstre monstre = this.getMonstre();
      if (monstre != null) {
         p_heros.decouvrirEnnemi(monstre);

         while (!monstre.estMort() && !p_heros.estMort()) {
            monstre.attaque(p_heros);

            if (!p_heros.estMort()) {
               p_heros.attaque(monstre);
            } else {
               break;
            }

            if (monstre.estMort()) {
               p_heros.fouillerMonstre(monstre);
               break;
            }
         }
      }
   }
}
