package banque;

import java.util.ArrayList;
import java.util.List;

// il peut voir que les comptes qui gérer
public class Employe extends Utilisateur{
    private List<Client> listClient= new ArrayList<Client>();
    private List<Compte> listCompte= new ArrayList<Compte>();
    public Employe(String nom, String prenom) {
        super(nom, prenom);
    }
    public Employe(String nom, String prenom, String motDePasse, String login) {
        super(nom, prenom, motDePasse, login);
    }

    public List<Client> getListClient() {
        return listClient;
    }
    public void addClient(Client client){
        this.listClient.add(client);
    }

    public List<Compte> getListCompte() {
        return listCompte;
    }
    public void addCompte(Compte compte){
        this.listCompte.add(compte);
    }
}
