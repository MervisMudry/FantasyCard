public class DruideBlanc extends Soigneur
{
  public DruideBlanc(String Nom, String Action)
  {
    super(Nom, Action);
  }

  public String allInfo()
  {
    return "Nom: " + getNom() + "\nFonction : " + getClass().getName() + "\nPV : " + getPV() + "\nAction : " + getAction() + "\nPS : " + getPS()  +"\nCoordonées : (" + getX() + ", " + getY() + ") \n";
  }
}
