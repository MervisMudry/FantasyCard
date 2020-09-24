import java.util.Random;
public abstract class Guerrier extends Personnage implements InterfaceAttaque
{
  private int PA;
  Random nbAlea= new Random();

  public int getPA()
  {
    return this.PA;
  }
  public void setPA(int PA)
  {
    this.PA = PA;
  }


  public Guerrier(String Nom, String Action)
  {
    super(Nom, Action);
    this.PA = 10 + nbAlea.nextInt(10);
    //this.Portee = ;
  }
  public void attaque(Personnage cible)
  {
    cible.setPV(cible.getPV() - this.PA);
  }
}
