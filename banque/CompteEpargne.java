package banque;

/*
 * un compte epargne n'a pas de de découvert autorisé, pas de type de carte et ne peux
 * faire de transferts d'argents qu'avec les autres comptes de son proprietaire. (héritage)
 * */

public class CompteEpargne extends Compte {
    final private float decouvertMax = 0;

    public CompteEpargne() {
        super();
        this.setIntitule("Compte Epargne");
    }

    public CompteEpargne(float montant, Client client) {
        super(montant, client);
        this.setIntitule("Compte Epargne");
    }

    public  float getDecouvertMax(){
        return 0;
    } ;


    @Override
    public String toString() {
        return "CompteEpargne{" +
                "numero=" + this.getNumero() +
                ", montant=" + this.getMontant() +
                ", intitule='" + this.getIntitule() + '\'' +
                ", decouvertMax=" + decouvertMax +
                ", client=" + this.getClient() +
                '}';
    }


}
