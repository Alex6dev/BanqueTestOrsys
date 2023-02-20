package banque;

public class CompteCourant extends Compte{

    private float decouvertMax;

    private TypeCarte typeCarte;
    public CompteCourant(){
        super();
        setDecouvertMax();
        this.setIntitule("Compte Courant");
    }
    public CompteCourant(float montant,Client client){
        super(montant, client);
        setDecouvertMax();
        this.setIntitule("Compte Courant");
    }
    public CompteCourant(float montant,Client client,TypeCarte typeCarte){
        super(montant, client);
        setDecouvertMax();
        this.setIntitule("Compte Courant");
        this.typeCarte= typeCarte;
    }

    private void setDecouvertMax() {
        this.decouvertMax = (float) (this.getMontant()*0.5);
    }
    @Override
    public float getDecouvertMax() {
        return this.decouvertMax;
    }
    @Override
    public void setMontant(float montant) {
        super.setMontant(montant);
        setDecouvertMax();
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "numero=" + this.getNumero() +
                ", montant=" + this.getMontant() +
                ", intitule='" + this.getIntitule() + '\'' +
                ", decouvertMax=" + decouvertMax +
                ", client=" + this.getClient() +
                ", typeCarte=" + typeCarte +
                '}';
    }
}
