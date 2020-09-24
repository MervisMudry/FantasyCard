public class MageNoir extends Paladin
{
  public MageNoir(String Nom, String Action)
  {
    super(Nom, Action);
  }
  public String allInfo()
  {
    return "Nom: " + getNom() + "\nFonction : " + getClass().getName() + "\nPV : " + getPV() + "\nAction : " + getAction() + "\nPA : " + getPA() + "\nPS : " + getPS() +"\nPortee : " + getPortee() +"\nCoordonées : (" + getX() + ", " + getY() + ") \n";
  }
}
