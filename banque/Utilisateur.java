package banque;

public class Utilisateur implements Authentifiable {
    private String nom;
    private String prenom;

    private String motDePasse;
    private String login;

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(String nom, String prenom, String motDePasse, String login) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public boolean authentifier(String motDePasse) {
        if(this.getMotDePasse().equals(motDePasse))
            return true;
        else
            return false;
    }

    @Override
    public String getMotDePasse() {
        return this.motDePasse;
    }

    @Override
    public void setMotDePasse(String motDePasse) {
        this.motDePasse=motDePasse;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public void setLogin(String login) {
        this.login=login;
    }

    @Override
    public String getLog() {
        return null;
    }
}
