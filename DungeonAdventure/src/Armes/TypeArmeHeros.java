package Armes;

public enum TypeArmeHeros {
   EPEE(0),
   FIOLE(1),
   FLECHE(2),
   LANCE(3),
   FLAMME(4),
   EXCALIBUR(5);


   private final int m_iValueur;

   TypeArmeHeros(int p_iValueur) {
      this.m_iValueur = p_iValueur;
   }

   public int obtenirValeur() {
      return this.m_iValueur;
   }


}








