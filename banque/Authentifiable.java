package banque;

public interface Authentifiable {


    public boolean authentifier(String motDePasse);
    public String getMotDePasse();
    public void setMotDePasse(String motDePasse);
    public String getLogin();
    public void setLogin(String login);
    public String getLog();


}
