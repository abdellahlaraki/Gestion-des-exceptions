package gestionException.ex1;

public class Main {
    public static void main(String[] args) {
        try {
            EntierNaturel e = new EntierNaturel(2);
            System.out.println("Valeur initiale : " + e.getVal());

            e.decrementer();
            System.out.println("Après décrémentation : " + e.getVal());

            e.setVal(0);
            e.decrementer();

        } catch (NombreNegatifException e) {
            System.out.println("Exception : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronée());
        }
    }
}

