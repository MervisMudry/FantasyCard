import java.util.Random;

public class Jeu
{
  public static void main (String[] args)
  {
    Clan C1 = new Clan(5);
    Clan C2 = new Clan(5);

    Fenetre f = new Fenetre(C1, C2);

    Random nbAlea = new Random();
    int newAlea1;
    int newAlea2;
    int Arret = 1;


    Personnage tmp1;
    Personnage tmp2;
    // System.out.println("Bonjour");

    // while(true)
    // {
    //
    //   check(C1);
    //   check(C2);
    //   // AfficheClan(C1);
    //   // AfficheClan(C2);
    //
    //   // Personnage tmp1 = new Personnage("Nom", "Action");
    //   newAlea1 = nbAlea.nextInt(C1.size());
    //   newAlea2 = nbAlea.nextInt(C2.size());
    //   tmp1 = C1.get(newAlea1);
    //
    //   tmp2 = C2.get(newAlea2);
    //
    //   System.out.println("Au tour du clan 1 ! \n");
    //
    //
    //   attaquePerso(tmp1, tmp2);
    //   soinPerso(tmp1, tmp1);
    //
    //   try{
    //     SeuilCritique(tmp2.getPV());
    //   }
    //   catch (Exception error)
    //   {
    //     System.out.println(error + "\n");
    //     System.out.println(tmp2.getNom() + " en danger ! \n");
    //   }
    //
    //
    //   check(C1);
    //   check(C2);
    //
    //   if (C1.size() == 0)
    //   {
    //     System.out.println("Victoire pour le clan 2 après " + Arret + " tours ! \n");
    //     System.exit(0);
    //   }
    //   if (C2.size() == 0)
    //   {
    //     System.out.println("Victoire pour le clan 1 après " + Arret + " tours ! \n");
    //     System.exit(0);
    //   }
    //
    //   System.out.println("Au tour du clan 2 \n");
    //
    //
    //   attaquePerso(tmp2, tmp1);
    //   soinPerso(tmp2, tmp2);
    //
    //   check(C1);
    //   check(C2);
    //
    //   if (C1.size() == 0)
    //   {
    //     System.out.println("Victoire pour le clan 2 après " + Arret + " tours ! \n");
    //     System.exit(0);
    //   }
    //   if (C2.size() == 0)
    //   {
    //     System.out.println("Victoire pour le clan 1 après " + Arret + " tours ! \n");
    //     System.exit(0);
    //   }
    //
    //
    //   //Si la partie dure trop longtemps
    //   Arret++;
    //   try{
    //     Interminable(Arret);
    //   }
    //   catch (Exception error)
    //   {
    //     System.out.println(error + "\n");
    //     System.out.println("Ca fait déjà " + Arret + " tours !  \n");
    //     System.exit(0);
    //   }
    //
    //
    // }
    //
  }
  public static void check(Clan clan)
  {
    int i = 0;
    for (i = 0; i < clan.size(); i++)
    {
      Personnage tmp = clan.get(i);
      if(tmp.getPV() <= 0)
      {
        System.out.println(tmp.getNom() + " a succombé à ses blessures ! \n" );

        clan.remove(i);
      }
    }
  }
  // public static void AfficheClan(Clan clan)
  // {
  //   int i = 0;
  //   for (i = 0; i < clan.size(); i++)
  //   {
  //     Personnage tmp = clan.get(i);
  //     //System.out.println(tmp.allInfo());
  //   }
  //
  // }

  public static void attaquePerso(Personnage tmp1, Personnage tmp2)
  {
    if (tmp1 instanceof Archer)
    {
      Archer Newtmp1 = (Archer)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp2);
    }
    else if (tmp1 instanceof Cogneur)
    {
      Cogneur Newtmp1 = (Cogneur)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp2);

    }
    else if (tmp1 instanceof MageBlanc)
    {
      MageBlanc Newtmp1 = (MageBlanc)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp2);

    }
    else if (tmp1 instanceof MageNoir)
    {
      MageNoir Newtmp1 = (MageNoir)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp2);

    }


  }

  public static void soinPerso(Personnage tmp1, Personnage tmp2)
  {
    if (tmp1 instanceof DruideBlanc)
    {
      DruideBlanc Newtmp1 = (DruideBlanc)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.soin(tmp2);
    }
    else if (tmp1 instanceof DruideNoir)
    {
      DruideNoir Newtmp1 = (DruideNoir)tmp1;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.soin(tmp2);

    }


  }


  public static void SeuilCritique(double d) throws Exception
  {
    if (d < 15)
    {
      throw new Exception("Seuil Critique atteint !");
    }
  }

  public static void Interminable(int d) throws Exception
  {
    if (d > 200)
    {
      throw new Exception("Partie interminable !");
    }
  }

}
