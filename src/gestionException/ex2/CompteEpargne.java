package gestionException.ex2;

public class CompteEpargne extends CompteBancaire {
    private double tauxInteret = 0.02;

    public CompteEpargne(String numero, String titulaire, double solde) {
        super(numero, titulaire, solde);
    }

    public void appliquerInterets() {
        solde += solde * tauxInteret;
    }

    @Override
    public void transfertVers(CompteBancaire destinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException {

        if (destinataire == null) {
            throw new CompteInexistantException("Compte destinataire inexistant.");
        }
        this.retirer(montant);
        destinataire.deposer(montant);
    }
}
