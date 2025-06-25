package gestionException.ex2;

public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise = 1000;

    public CompteCourant(String numero, String titulaire, double solde) {
        super(numero, titulaire, solde);
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde + decouvertAutorise) {
            throw new FondsInsuffisantsException("Dépassement du découvert autorisé.");
        }
        solde -= montant;
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
