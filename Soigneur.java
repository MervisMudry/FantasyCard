import java.util.Random;


public abstract class Soigneur extends Personnage implements InterfaceSoigner
{
  private int PS;
  Random nbAlea= new Random();

  public int getPS()
  {
    return this.PS;
  }

  public void setPS(int PS)
  {
    this.PS = PS;
  }


  Soigneur(String Nom, String Action)
  {
    super(Nom, Action);
    this.PS = 4 + nbAlea.nextInt(3);
  }
  public void soin(Personnage cible)
  {
      cible.setPV(cible.getPV() + this.PS);
  }
}
