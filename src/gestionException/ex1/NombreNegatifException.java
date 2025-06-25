package gestionException.ex1;

public class NombreNegatifException extends Exception {
    private int valeurErronée;

    public NombreNegatifException(int valeur) {
        super("Valeur négative : " + valeur);
        this.valeurErronée = valeur;
    }

    public int getValeurErronée() {
        return valeurErronée;
    }
}

