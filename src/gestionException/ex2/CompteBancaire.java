package gestionException.ex2;

public abstract class CompteBancaire {
    protected String numero;
    protected double solde;
    protected String titulaire;

    public CompteBancaire(String numero, String titulaire, double solde) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public void deposer(double montant) {
        solde += montant;
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour le retrait.");
        }
        solde -= montant;
    }

    public void afficherSolde() {
        System.out.println("Compte " + numero + " - Solde : " + solde);
    }

    public String getNumero() {
        return numero;
    }

    public abstract void transfertVers(CompteBancaire destinataire, double montant)
            throws FondsInsuffisantsException, CompteInexistantException;
}
