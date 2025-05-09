import java.util.LinkedList;
import java.util.Scanner;

public class Appli {

  public static void balade(Noeud racine) {
    assert(racine.estNavigable());
    
    LinkedList<Noeud> pile = new LinkedList<Noeud>();
    pile.push(racine);

    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print(pile.peek().getNom() + " : ");
      for (int i = 0; i < pile.peek().getNombreDeFils(); ++i)
        System.out.print(pile.peek().getFils(i).getNom() + ", ");
      System.out.println();
      if (sc.hasNextInt()) {
        int nf = sc.nextInt();
        if (0 <= nf && nf < pile.peek().getNombreDeFils() && pile.peek().getFils(nf).estNavigable())
          pile.push(pile.peek().getFils(nf));
        else
          System.out.println("opération interdite");
      }
      else {
        String s = sc.next();
        if (s.equals("-"))
          if (pile.size() > 1)
            pile.pop();
          else
            System.out.println("opération interdite");
        else if (s.equals("q"))
          return;
      }
    }
  }

  }
}
