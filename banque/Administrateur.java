package banque;
// il peut voir touts les comptes
public class Administrateur extends Utilisateur implements Authentifiable{
    public Administrateur(String nom, String prenom) {
        super(nom, prenom);
    }

    public Administrateur(String nom, String prenom, String motDePasse, String login) {
        super(nom, prenom, motDePasse, login);
    }


}
