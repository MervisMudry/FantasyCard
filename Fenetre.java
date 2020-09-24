import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import java.util.Random;
import java.text.*;


/*Dans mon code, il y a beaucoup de code mis en commentaire. Ce sont plusieurs tentatives ratées d'utiliser plusieurs fonctions. List.size() par exemple qui lorsque je compile, me dit que cela retourne une dimension et non un nombre, je n'ai donc pas pu gérer le fait que l'indice du clan dépasse la taille du clan.
Il y a également eu mes nombreuses tentatives de mettre à jour l'affichage de cette liste de clan. Il en résulte que lorsqu'un personnage meurt et qu'on le sélectionne, le personnage suivant est pris en compte.*/

public class Fenetre extends JFrame
{
  //static final float serialVersionUID = 1L;

  public Fenetre(Clan C1, Clan C2)
  {
    // System.out.println("Fen");
    this.setTitle("FantasyCard");
    this.setSize(700, 400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(new GridLayout(3, 1)); //On crée la grille de la fenêtre globale

    JButton boutonAttaquer1 = new JButton("C1 Attaque !");
    JButton boutonSoigner1 = new JButton("C1 Soigne !");
    JButton boutonAttaquer2 = new JButton("C2 Attaque !");
    JButton boutonSoigner2 = new JButton("C2 Soigne !");
    JTextArea Texte1 = new JTextArea("--");

    Texte1.setText("r");
    JTextArea Texte2 = new JTextArea("--");
    JPanel Top = new JPanel();
    JPanel Mid = new JPanel();
    JPanel Bot = new JPanel();
    JList List1 = new JList (C1.toArray());
    JList List2 = new JList (C2.toArray());


    // final int newAlea3;
    // final int newAlea4;
    //int Arret2 = 1;
    Random nbAlea = new Random();
    // Personnage tmp3 = new Archer("Nom", "Action"); //Pour palier à une erreur d'initialisation
    // Personnage tmp4 = new Archer("Nom", "Action");


    boutonAttaquer1.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
//Une de mes tentatives pour mettre à jour ma JListe à l'affichage

        Top.removeAll();
        Top.validate();
        // Top.add(List1);
        // Top.add(List2);
        Top.revalidate();
        Top.repaint();

        Mid.removeAll();
        Mid.validate();
        Mid.add(boutonAttaquer1);
        Mid.add(boutonSoigner1);
        Mid.add(boutonAttaquer2);
        Mid.add(boutonSoigner2);
        Mid.revalidate();
        Mid.repaint();

        Bot.removeAll();
        Bot.validate();
        Bot.add(Texte1);
        Bot.add(Texte2);
        Bot.revalidate();
        Bot.repaint();

        check(C1);
        check(C2);
        MajPanelTop(Top, List1, List2);

        int index1 = List1.getSelectedIndex();
        int index2 = List2.getSelectedIndex();
        if (index1 < 0) index1 = 0;
        if (index2 < 0) index2 = 0;


        final Personnage tmp3 = C1.get(index1);
        // final Personnage tmp3 = (Personnage)C1.getSelectedValue();
        final Personnage tmp4 = C2.get(index2);

        attaquePerso(tmp3, tmp4);

        try{
          SeuilCritique(tmp4.getPV());
        }
        catch (Exception error)
        {
          System.out.println(error + "\n");
          System.out.println(tmp4.getNom() + " en danger ! \n");
        }


        check(C1);
        check(C2);
        MajPanelTop(Top, List1, List2);

        if (C1.size() == 0)
        {
          System.out.println("Victoire pour le clan 2  ! \n");
          System.exit(0);
        }
        if (C2.size() == 0)
        {
          System.out.println("Victoire pour le clan 1 tours ! \n");
          System.exit(0);
        }

        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });

    boutonAttaquer2.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {

        check(C1);
        check(C2);
        MajPanelTop(Top, List1, List2);

        int index1 = List1.getSelectedIndex();
        int index2 = List2.getSelectedIndex();
        if (index1 < 0) index1 = 0;
        if (index2 < 0) index2 = 0;

        final Personnage tmp3 = C1.get(index1);
        // final Personnage tmp3 = (Personnage)C1.getSelectedValue();
        final Personnage tmp4 = C2.get(index2);

        attaquePerso(tmp4, tmp3);

        try{
          SeuilCritique(tmp3.getPV());
        }
        catch (Exception error)
        {
          System.out.println(error + "\n");
          System.out.println(tmp3.getNom() + " en danger ! \n");
        }


        check(C1);
        check(C2);
        MajPanelTop(Top, List1, List2);

        if (C1.size() == 0)
        {
          System.out.println("Victoire pour le clan 2  ! \n");
          System.exit(0);
        }
        if (C2.size() == 0)
        {
          System.out.println("Victoire pour le clan 1 tours ! \n");
          System.exit(0);
        }

        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });


    boutonSoigner1.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {


        MajPanelTop(Top, List1, List2);

        int index1 = List1.getSelectedIndex();
        if (index1 < 0) index1 = 0;

        final Personnage tmp3 = C1.get(index1);

        soinPerso(tmp3, tmp3);


        MajPanelTop(Top, List1, List2);


        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });

    boutonSoigner2.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {


        MajPanelTop(Top, List1, List2);

        int index2 = List2.getSelectedIndex();
        if (index2 < 0) index2 = 0;

        final Personnage tmp4 = C2.get(index2);

        soinPerso(tmp4, tmp4);


        MajPanelTop(Top, List1, List2);


        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });

    List1.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {



        MajPanelTop(Top, List1, List2);

        int index1 = List1.getSelectedIndex();
        if (index1 < 0) index1 = 0;

        final Personnage tmp3 = C1.get(index1);

        if (tmp3 instanceof Archer)
        {
          Archer Newtmp3 = (Archer)tmp3;
          Texte1.setText(Newtmp3.allInfo());
        }
        else if (tmp3 instanceof Cogneur)
        {
          Cogneur Newtmp3 = (Cogneur)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof MageBlanc)
        {
          MageBlanc Newtmp3 = (MageBlanc)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof MageNoir)
        {
          MageNoir Newtmp3 = (MageNoir)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof DruideBlanc)
        {
          DruideBlanc Newtmp3 = (DruideBlanc)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof DruideNoir)
        {
          DruideNoir Newtmp3 = (DruideNoir)tmp3;
          Texte1.setText(Newtmp3.allInfo());
        }


        int index2 = List2.getSelectedIndex();
        if (index2 < 0) index2 = 0;

        final Personnage tmp4 = C2.get(index2);

        if (tmp4 instanceof Archer)
        {
          Archer Newtmp4 = (Archer)tmp4;
          Texte2.setText(Newtmp4.allInfo());
        }
        else if (tmp4 instanceof Cogneur)
        {
          Cogneur Newtmp4 = (Cogneur)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof MageBlanc)
        {
          MageBlanc Newtmp4 = (MageBlanc)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof MageNoir)
        {
          MageNoir Newtmp4 = (MageNoir)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof DruideBlanc)
        {
          DruideBlanc Newtmp4 = (DruideBlanc)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof DruideNoir)
        {
          DruideNoir Newtmp4 = (DruideNoir)tmp4;
          Texte2.setText(Newtmp4.allInfo());
        }

        MajPanelTop(Top, List1, List2);



        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });
    List2.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {


        MajPanelTop(Top, List1, List2);


        int index1 = List1.getSelectedIndex();
        if (index1 < 0) index1 = 0;

        final Personnage tmp3 = C1.get(index1);

        if (tmp3 instanceof Archer)
        {
          Archer Newtmp3 = (Archer)tmp3;
          Texte1.setText(Newtmp3.allInfo());
        }
        else if (tmp3 instanceof Cogneur)
        {
          Cogneur Newtmp3 = (Cogneur)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof MageBlanc)
        {
          MageBlanc Newtmp3 = (MageBlanc)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof MageNoir)
        {
          MageNoir Newtmp3 = (MageNoir)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof DruideBlanc)
        {
          DruideBlanc Newtmp3 = (DruideBlanc)tmp3;
          Texte1.setText(Newtmp3.allInfo());

        }
        else if (tmp3 instanceof DruideNoir)
        {
          DruideNoir Newtmp3 = (DruideNoir)tmp3;
          Texte1.setText(Newtmp3.allInfo());
        }


        int index2 = List2.getSelectedIndex();
        if (index2 < 0) index2 = 0;

        final Personnage tmp4 = C2.get(index2);

        if (tmp4 instanceof Archer)
        {
          Archer Newtmp4 = (Archer)tmp4;
          Texte2.setText(Newtmp4.allInfo());
        }
        else if (tmp4 instanceof Cogneur)
        {
          Cogneur Newtmp4 = (Cogneur)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof MageBlanc)
        {
          MageBlanc Newtmp4 = (MageBlanc)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof MageNoir)
        {
          MageNoir Newtmp4 = (MageNoir)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof DruideBlanc)
        {
          DruideBlanc Newtmp4 = (DruideBlanc)tmp4;
          Texte2.setText(Newtmp4.allInfo());

        }
        else if (tmp4 instanceof DruideNoir)
        {
          DruideNoir Newtmp4 = (DruideNoir)tmp4;
          Texte2.setText(Newtmp4.allInfo());
        }


        MajPanelTop(Top, List1, List2);


        //Si la partie dure trop longtemps
        //Arret2++;
        revalidate();
      }
    });



    Top.add(List1);
    Top.add(List2);

    Mid.add(boutonAttaquer1);
    Mid.add(boutonSoigner1);
    Mid.add(boutonAttaquer2);
    Mid.add(boutonSoigner2);
    Bot.add(Texte1);
    Bot.add(Texte2);


    this.add(Top);
    this.add(Mid);
    this.add(Bot);
    this.setVisible(true);


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

  public static void attaquePerso(Personnage tmp3, Personnage tmp4)
  {
    if (tmp3 instanceof Archer)
    {
      Archer Newtmp1 = (Archer)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp4);
    }
    else if (tmp3 instanceof Cogneur)
    {
      Cogneur Newtmp1 = (Cogneur)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp4);

    }
    else if (tmp3 instanceof MageBlanc)
    {
      MageBlanc Newtmp1 = (MageBlanc)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp4);

    }
    else if (tmp3 instanceof MageNoir)
    {
      MageNoir Newtmp1 = (MageNoir)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.attaque(tmp4);

    }


  }

  public static void soinPerso(Personnage tmp3, Personnage tmp4)
  {
    if (tmp3 instanceof DruideBlanc)
    {
      DruideBlanc Newtmp1 = (DruideBlanc)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.soin(tmp4);
    }
    else if (tmp3 instanceof DruideNoir)
    {
      DruideNoir Newtmp1 = (DruideNoir)tmp3;
      System.out.println("\n" + Newtmp1.allInfo());
      Newtmp1.soin(tmp4);

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






  public static void MajPanelTop(JPanel Top, JList List1, JList List2)
  {
    Top.removeAll();
    Top.validate();
    Top.add(List1);
    Top.add(List2);
    Top.revalidate();
    Top.repaint();
  }
}
