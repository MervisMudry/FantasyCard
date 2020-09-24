public class DruideNoir extends Soigneur
{
  private int Malus;
  public DruideNoir(String Nom, String Action)
  {
    super(Nom, Action);
    this.Malus = getPS()/2;
  }
  public String allInfo()
  {
    return "Nom: " + getNom() + "\nFonction : " + getClass().getName() + "\nPV : " + getPV() + "\nAction : " + getAction() + "\nPS : " + getPS() + "\nMalus : " + getMalus() +"\nCoordonées : (" + getX() + ", " + getY() + ") \n";
  }

  public int getMalus()
  {
    return this.Malus;
  }
  public void setMalus(int Malus)
  {
    this.Malus = Malus;
  }

}
