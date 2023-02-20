package banque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Utilisateur implements Comparable<Client> {

    private Date dateNaissance;
    private Date datePremierCompte;
    private List<Compte> listCompte= new ArrayList<Compte>();
    private Employe conseiller;

    public Client(String nom, String prenom, Employe conseiller) {
        super(nom,prenom);
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" +  this.getNom()+ '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                '}';
    }



    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Date getDatePremierCompte() {
        return datePremierCompte;
    }
    public void addCompteList(Compte compte){
        this.listCompte.add(compte);
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }

    public float getMontantTotal(){
        List<Compte>listCurrent= this.getListCompte();
        float totalArgentCurrent=0;
        for (Compte compte:listCurrent){
            totalArgentCurrent+=compte.getMontant();
        }
        return totalArgentCurrent;
    }
    @Override
    public int compareTo(Client clientCompare) {
        float totalCurrent= this.getMontantTotal();
        float totalCompare= clientCompare.getMontantTotal();

        if(totalCurrent==totalCompare)
            return 0;
        else if (totalCurrent>totalCompare)
            return 1;
        else
            return -1;

    }
}
