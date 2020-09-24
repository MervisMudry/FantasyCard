import java.util.Random;

public abstract class Paladin extends Personnage implements InterfaceAttaque, InterfaceSoigner
{
  private int PA;
  private int PS;
  private int Portee;
  Random nbAlea= new Random();

  public int getPortee()
  {
    return this.Portee;
  }

  public void setPortee(int Portee)
  {
    this.Portee = Portee;
  }


  public int getPA()
  {
    return this.PA;
  }

  public void setPA(int PA)
  {
    this.PA = PA;
  }


  public int getPS()
  {
    return this.PS;
  }

  public void setPS(int PS)
  {
    this.PS = PS;
  }


  public Paladin(String Nom, String Action)
  {
    super(Nom, Action);
    this.PA = 7 + nbAlea.nextInt(10);
    this.PS = 7 + nbAlea.nextInt(10);
    this.Portee = 500;
  }

  public void attaque(Personnage cible)
  {
    cible.setPV(cible.getPV() - this.PA);
  }
  public void soin(Personnage cible)
  {
      cible.setPV(cible.getPV() + this.PS);
  }


}
