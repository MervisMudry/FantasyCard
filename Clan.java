import java.util.Random;
import java.util.ArrayList;
public class Clan extends ArrayList<Personnage>
{
  static int cptPerso = 0;
  public Clan(int nbM)
  {
    //static final long serialVersionUID = 1L;
    cptPerso++;

    int cmpt = 0;
    Personnage tmp1;
    Random nbAlea= new Random();
    for(cmpt = 0; cmpt < nbM; cmpt++)
    {
      int newAlea = nbAlea.nextInt(5);
      if (newAlea == 0)
      {
      tmp1 = new Archer("Archer" + cptPerso, "Attaque");
      this.add(tmp1);
      }
      if (newAlea == 1)
      {
      tmp1 = new Cogneur("Cogneur" + cptPerso, "Attaque");
      this.add(tmp1);

      }
      if (newAlea == 2)
      {
      tmp1 = new MageBlanc("MageBlanc" + cptPerso, "Attaque");
      this.add(tmp1);

      }
      if (newAlea == 3)
      {
      tmp1 = new MageNoir("MageNoir" + cptPerso, "Attaque");
      this.add(tmp1);

      }
      if (newAlea == 4)
      {
      tmp1 = new DruideBlanc("DruideBlanc" + cptPerso, "Soin");
      this.add(tmp1);

      }
      if (newAlea == 5)
      {
      tmp1 = new DruideNoir("DruideNoir" + cptPerso, "Soin");
      this.add(tmp1);

      }

    }
  }
}
