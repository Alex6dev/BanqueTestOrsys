package banque;

public abstract class Compte implements Comparable<Compte>{
    static long nbDeCompteOuvert=0;
    private long numero;
    private float montant=0;
    private String intitule="Compte";
    private Client client;
    public Compte(){
        this.numero=nbDeCompteOuvert;
        nbDeCompteOuvert++;

    }
    public Compte(float montant, Client client){
        this.numero=nbDeCompteOuvert;
        nbDeCompteOuvert++;
        this.montant=montant;
        this.client= client;

    }
    public long getNumero() {
        return numero;
    }
    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        this.montant = montant;
    }
    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Client getClient() {
        return client;
    }

    public abstract float getDecouvertMax() ;

    @Override
    public int compareTo(Compte compteCompare) {
        if(this.montant==compteCompare.getMontant())
            return 0;
        else if (this.montant>compteCompare.getMontant())
            return 1;
        else
            return -1;
    }
}
