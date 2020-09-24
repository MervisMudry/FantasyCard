public class Cogneur extends Guerrier
{
  private int Portee;

  public Cogneur(String Nom, String Action)
  {
    super(Nom, Action);
    this.Portee = 50;
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
