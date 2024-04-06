import Objets.Objet;
import Objets.PotionDeForce;
import Objets.PotionDeVie;
import Personnages.Heros;
import Personnages.TypeDeMonstre;

public class Donjon {
    private Salle[] m_Salles;

    public Donjon(int nombreDeSalles, boolean afficherInformations) {
        m_Salles = new Salle[nombreDeSalles];
        for (int i = 0; i < m_Salles.length; ++i) {
            m_Salles[i] = new Salle();

            if (afficherInformations) {
                System.out.println(
                        "\t\t|"+".".repeat(70)+"|\n\n"+
                        "\t\t\t\t\tCréation de la salle " + (i+1) + " :\n"
                );
            }

            if ((i+1) % 7 == 0 && (i+1) % 4 == 0) {
                m_Salles[i].ajouterObjet(new PotionDeVie());
                m_Salles[i].ajouterObjet(new PotionDeForce());
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tContient : une potion de vie et une potion de force.");
                }
            } else if ((i+1) % 7 == 0) {
                m_Salles[i].ajouterObjet(new PotionDeVie());
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tContient : une potion de vie.");
                }
            } else if ((i+1) % 4 == 0) {
                m_Salles[i].ajouterObjet(new PotionDeForce());
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tContient : une potion de force.");
                }
            }

            if (i == m_Salles.length - 1) {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.DIABLO);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Diablo a été ajouté dans la dernière salle.\n\n"+
                            "\t\t|"+".".repeat(70)+"|\n\n");
                }
            } else if (i > 3 && estNombrePremier(i)) {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.SORCIER);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Sorcier a été ajouté.\n");
                }
            } else if (i % 4 == 0 && i % 3 == 0) {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.BARBARE);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Barbare a été ajouté.\n");
                }
            } else if (i % 4 == 0) {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.VOLEUR);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Voleur a été ajouté.\n");
                }
            } else if (i % 3 == 0) {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.TROLL);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Troll a été ajouté.\n");
                }
            } else {
                m_Salles[i].ajouterMonstre(TypeDeMonstre.ZOMBIE);
                if (afficherInformations) {
                    System.out.println("\t\t\t\t\tUn Zombie a été ajouté.\n");
                }
            }
        }
    }




    public void entrer(Heros p_Heros) {
        int numeroSalle = 1;
        for (Salle salle : m_Salles) {
            System.out.println("\t\t\t\tVous ouvrez la porte et entrez dans la salle n° "+numeroSalle+".");
            salle.ouvertureDeLaSallePourLeHeros(p_Heros);
            if (p_Heros.estMort()) {
                break;
            }
            numeroSalle++;
        }
    }
    private boolean estNombrePremier(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
