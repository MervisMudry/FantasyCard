import java.util.Random;

public abstract class Personnage
{
  private int PV;
  private String Nom;
  private String Action;
  private int X;
  private int Y;
  Random nbAlea= new Random();

  public void setPV(int PV)
  {
    this.PV = PV;
  }

  public int getPV()
  {
    return this.PV;
  }
  public String getNom()
  {
    return this.Nom;
  }
  public void setNom(String Nom)
  {
    this.Nom = Nom;
  }
  public String getAction()
  {
    return this.Action;
  }
  public void setAction(String Action)
  {
    this.Action = Action;
  }

  public int getX()
  {
    return this.X;
  }
  public void setX(int X)
  {
    this.X = X;
  }

  public int getY()
  {
    return this.Y;
  }
  public void setY(int Y)
  {
    this.Y = Y;
  }

  public Personnage(String Nom, String Action)
  {
    this.PV = 40 + nbAlea.nextInt(60);
    this.Nom = Nom;
    this.Action = Action;
    this.X = nbAlea.nextInt(1000);
    this.Y = nbAlea.nextInt(1000);
  }
  public String toString()
  {
    return this.Nom;
  }
}
