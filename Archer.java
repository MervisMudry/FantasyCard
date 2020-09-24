public class Archer extends Guerrier
{
  private int Portee;

  public Archer(String Nom, String Action)
  {
    super(Nom, Action);
    this.Portee = 500;
  }

  public int getPortee()
  {
    return this.Portee;
  }

  public void setPortee(int Portee)
  {
    this.Portee = Portee;
  }



  public String allInfo()
  {
    return "Nom: " + getNom() + "\nFonction : " + getClass().getName() + "\nPV : " + getPV() + "\nAction : " + getAction() + "\nPA : " + getPA() + "\nPortee : " + getPortee() +"\nCoordonées : (" + getX() + ", " + getY() + ") \n";
  }
}
