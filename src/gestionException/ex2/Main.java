package gestionException.ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        CompteCourant c1 = new CompteCourant("001", "JHON", 500);
        CompteEpargne c2 = new CompteEpargne("002", "MOLY", 800);

        comptes.add(c1);
        comptes.add(c2);

        try {
            c1.deposer(200);
            c1.afficherSolde();

            c1.retirer(300);
            c1.afficherSolde();

            c1.transfertVers(c2, 400);
            c1.afficherSolde();
            c2.afficherSolde();

            comptes.remove(c2);

            // Simulation d'une erreur
            c1.transfertVers(null, 100);

        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

