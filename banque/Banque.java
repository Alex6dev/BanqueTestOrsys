package banque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banque {
    private String nom;
    private String adresse;
    private LocalDate dateCreation;
    private List<Client> listeClient = new ArrayList<Client>();
    private List<Compte> listeCompte = new ArrayList<Compte>();

    public Banque(String nom, String adresse, LocalDate dateCreation) {
        this.nom = nom;
        this.adresse = adresse;
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    public void addCompte(Compte compte) {

        this.listeCompte.add(compte);
        Collections.sort(this.listeCompte);

    }

    public void addClient(Client client) {
        this.listeClient.add(client);
        Collections.sort(this.listeClient);
    }

    public void displayClient() {
        for (int j = 0; j < this.getListeClient().size(); j++) {
            Client client = this.getListeClient().get(j);
            System.out.println(Integer.toString(j) + " - " + client);
        }
    }

    public void displayCompte() {
        for (int j = 0; j < this.getListeCompte().size(); j++) {
            Compte compte = this.getListeCompte().get(j);
            System.out.println(Integer.toString(j) + " - " + compte);
        }
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Client> getListeClient() {
        return listeClient;
    }

    public List<Compte> getListeCompte() {
        return listeCompte;
    }

    public int transfert(int indexCompte1, int indexCompte2, float montantDeTranfert) {
        if(montantDeTranfert==0)
            return -1;

        if(montantDeTranfert<0){
            montantDeTranfert=montantDeTranfert*-1;
            int indexTransfert= indexCompte1;
            indexCompte1=indexCompte2;
            indexCompte2=indexTransfert;
        }

        return this.transfertPossible(indexCompte1,indexCompte2,montantDeTranfert);
    }

    private int transfertPossible(int indexCompte1,int indexCompte2,float montantDeTranfert){
        Compte compte1 = this.getListeCompte().get(indexCompte1);
        Compte compte2 = this.getListeCompte().get(indexCompte2);
        if(compte1 instanceof CompteEpargne || compte2 instanceof CompteEpargne){
            if(compte1.getClient().equals(compte2.getClient())){
                if (this.plafondAtteint(compte1,montantDeTranfert))
                    return 3;
                else{
                    this.transfertEffectuer(compte1,compte2,montantDeTranfert);
                    Collections.sort(this.listeCompte);
                    Collections.sort(this.listeClient);
                    return 1;
                }
            }else{
                return 2;
            }
        }else{
            if (this.plafondAtteint(compte1,montantDeTranfert))
                return 3;
            else{
                this.transfertEffectuer(compte1,compte2,montantDeTranfert);
                Collections.sort(this.listeCompte);
                Collections.sort(this.listeClient);
                return 1;
            }
        }

    }
    private boolean plafondAtteint(Compte compte1,float montantDeTranfert){

        if (compte1.getMontant() - montantDeTranfert < (compte1.getDecouvertMax() * -1) ) {
            return true;
        } else {
            return false;
        }

    }
    private void transfertEffectuer(Compte compte1,Compte compte2,float montantDeTranfert){
        compte1.setMontant(compte1.getMontant() - montantDeTranfert);
        compte2.setMontant(compte2.getMontant() + montantDeTranfert);
    }
    public Compte wantedCompte(long indexWanted) {
        for (int i = 0; i < this.getListeCompte().size() - 1; i++) {
            Compte compteCourantCurrent = this.getListeCompte().get(i);
            if (compteCourantCurrent.getNumero() == indexWanted)
                return compteCourantCurrent;
        }
        return null;
    }

    public List<Client> wantedClient(String nomClientWanted) {
        List<Client> listResult = new ArrayList<Client>();
        for (Client client : this.getListeClient()) {
            String nomClient = client.getNom();
            if (nomClient.equals(nomClientWanted)) {
                listResult.add(client);
            }
        }
        return listResult;
    }
}
