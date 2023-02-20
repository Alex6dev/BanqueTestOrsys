import banque.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner in= new Scanner(System.in);
    public static List<Banque> listeBanque= new ArrayList<Banque>();
    public static Registre registre=new Registre();
    public static boolean continuer= true;
    public static boolean continuerBis= true;
    public static void main(String[] args) {
        Banque banque=new Banque("toto","1 rue",java.time.LocalDate.now());
        Banque banque2=new Banque("titi","2 rue",java.time.LocalDate.now());
        listeBanque.add(banque);
        listeBanque.add(banque2);
        Client client = new Client("testClient","test");
        Client client2 = new Client("testClient2","test");

        CompteCourant compteCourant= new CompteCourant(5000,client);
        client.addCompteList(compteCourant);
        CompteCourant compteCourant2= new CompteCourant(1500,client2);
        client2.addCompteList(compteCourant2);
        CompteCourant compteCourant3= new CompteCourant(2500,client);
        client.addCompteList(compteCourant3);
        CompteEpargne compteEpargne= new CompteEpargne(2500,client);
        client.addCompteList(compteEpargne);
        CompteEpargne compteEpargne2= new CompteEpargne(2000,client2);
        client2.addCompteList(compteEpargne2);
        CompteEpargne compteEpargne3= new CompteEpargne(3000,client2);
        client2.addCompteList(compteEpargne3);
        CompteEpargne compteEpargne4= new CompteEpargne(1000,client);
        client.addCompteList(compteEpargne4);
        banque.addCompte(compteCourant);
        banque.addCompte(compteCourant2);
        banque.addCompte(compteCourant3);
        banque.addCompte(compteEpargne);
        banque.addCompte(compteEpargne2);
        banque.addCompte(compteEpargne3);
        banque.addCompte(compteEpargne4);
        banque.addClient(client);
        banque.addClient(client2);
        banque2.addClient(client);

        // loooop du programme du menu principal
        do{
            menuPrincipal();
        }while (continuer);


    }

    public static int choix(int min , int max){
        int choix;
        boolean out;
        do {
            choix=in.nextInt();
            if(choix<min || choix>max ){
                out=true;
                System.out.println("Erreur dans la saisie, merci de donner un chiffre entre " +min+" et "+max);
            }
            else
                out=false;

        }while (out);
        return choix;
    }
    public static void menuPrincipal(){
        System.out.println("");
        System.out.println("----------------Menu principal------------------------------");
        System.out.println("1-Création d'une banque");
        System.out.println("2-Gérer une banque ");
        System.out.println("3-Voir mes banques");
        System.out.println("4-Quitter");
        System.out.println("");

        // loooop pour vérifier que tu donnes le bon chiffre du menu
        int choixUtilisateur=choix(1,4);

        switch (choixUtilisateur) {

            case (1):
                System.out.println("Le nom de votre banque:");
                String nomBanque= in.nextLine();
                System.out.println("L'adresse de votre banque:");
                String adresseBanque= in.nextLine();

                Banque newBanque = new Banque(nomBanque,adresseBanque,java.time.LocalDate.now());
                listeBanque.add(newBanque);
                displayListeBanque();
                break;

            case (2):
                menuChoisirGereBanque();
                break;
            case (3):
                displayListeBanque();
                break;
            case (4):
                continuer=false;
                return;

        }


    }
    public static void displayListeBanque(){
        int i=0;
        for (Banque banque: listeBanque){
            System.out.println(i+"-"+banque);
            i++;
        }

    }
    public static void menuChoisirGereBanque(){
        System.out.println("----------Quelle banque veux-tu gerer ?-------------");
        displayListeBanque();

        // loooop pour vérrifier que tu choisis le bon chiffre en correspondance de la liste de banque
        int choixUtilisateur= choix(0,listeBanque.size()-1);
        menuGereBanque(choixUtilisateur);
    }
    public static void menuGereBanque(int indexBanqueChoisie){
        Banque banqueChoisie= listeBanque.get(indexBanqueChoisie);

        //looopp gere ta banque
        do {
            System.out.println("");
            System.out.println("------------------Menu gérer une banque--------------------");
            System.out.println("1-Ajouter un compte");
            System.out.println("2-Faire un transfert ");
            System.out.println("3-Voir les comptes");
            System.out.println("4-Voir les clients");
            System.out.println("5-Recherche d'un compte");
            System.out.println("6-Recherche d'un client");
            System.out.println("7-Quitter");
            System.out.println("");

            // loooop verifier le chiffre qu'il soit bien un chifffre du menu
            int choixUtilisateur= choix(1,6);

            switch (choixUtilisateur){
                case (1):
                    ajouterUnNouveauCompte(banqueChoisie);
                    break;
                case (2):
                    faireTransfert(banqueChoisie);
                    break;
                case (3):
                    banqueChoisie.displayCompte();
                    break;
                case (4):
                    banqueChoisie.displayClient();
                    break;
                case (5):
                    wantedCompte(banqueChoisie);
                break;
                case (6):
                    wantedClient(banqueChoisie);
                    break;
                case (7):
                    continuerBis=false;
                    return;

            }
        }while (continuerBis);


    }

    public static void ajouterUnNouveauCompte(Banque banqueChoisie){
        // loooop verifier le chiffre qu'il soit bien un chifffre demandé
        System.out.println("Voulais vous utiliser un client existant (1) ou créer un nouveau (2) ?");
        int choixUtilisateur=choix(1,2);

        switch (choixUtilisateur){
            case (1):
                banqueChoisie.displayClient();

                System.out.println("");
                System.out.println("Quelle client veux un nouveau compte ?");
                int choixUtilisateurBis=choix(0,banqueChoisie.getListeClient().size()-1);
                Client client=banqueChoisie.getListeClient().get(choixUtilisateurBis);

                System.out.println("");
                System.out.println("De combien on credite son compte ?");
                float choixMontant=(float)choix(0,1000000000);
                CompteCourant compteCourant= new CompteCourant(choixMontant,client);
                banqueChoisie.addCompte(compteCourant);
                break;
            case (2):
                System.out.println("");
                System.out.println("Quelle est le nom du client ?");
                String nomClient= in.nextLine();

                System.out.println("");
                System.out.println("Quelle est le prenom du client ?");
                String prenomClient=in.nextLine();
                Client newClient = new Client(nomClient,prenomClient);
                banqueChoisie.addClient(newClient);

                System.out.println("");
                System.out.println("De combien on credite son compte ?");
                float choixMontantBis=(float)choix(0,1000000000);
                CompteCourant compteCourantBis = new CompteCourant(choixMontantBis,newClient);
                banqueChoisie.addCompte(compteCourantBis);
                break;
        }
    }
    public static void faireTransfert(Banque banqueChoisie){
        System.out.println("");
        banqueChoisie.displayCompte();

        System.out.println("");
        System.out.println("Quel est le compte Débiteur ?");
        int choixCompteDebiteur= choix(0,banqueChoisie.getListeCompte().size()-1);
        System.out.println("");

        banqueChoisie.displayCompte();
        System.out.println("");
        System.out.println("Quel est le compte Créditeur ?");
        System.out.println("");
        int choixCompteCrediteur=choix(0,banqueChoisie.getListeCompte().size()-1);

        System.out.println("");
        System.out.println("Quel est le montant du transfert ?");
        float montant=choix(0,100000000);
        int result =banqueChoisie.transfert(choixCompteDebiteur,choixCompteCrediteur,montant);
        System.out.println("");
        switch (result){
            case 1:
                registre.addOperation(new Operation(choixCompteDebiteur,choixCompteCrediteur,montant,java.time.LocalDateTime.now()));

                System.out.println("Transfert effectuer");
                break;
            case 2:
                System.out.println("Transfert de fond d'un Compte d'Epargne vers un compte d'un autre propriétaire est interdit !");
                break;
            case 3:
                System.out.println("Tranfert non possible car on dépasse le plafond de découvert");
                break;
            default:
                System.out.println("Erreur dans transfert");
                break;
        }
        System.out.println("");
        System.out.println(registre);
        System.out.println("");
        banqueChoisie.displayCompte();
    }
    public static void wantedCompte(Banque banqueChoisie){
        System.out.println("Merci de donner le numero du compte");
        long numeroCompte= (long)in.nextInt();
        Compte compte= banqueChoisie.wantedCompte(numeroCompte);
        if (compte!=null)
            System.out.println(compte);
        else
            System.out.println("aucun resultat pour ce numéro");
    }
    public static void wantedClient(Banque banqueChoisie){
        System.out.println("Merci de donner le nom du client");
        String nomClient= in.nextLine();
        List<Client> listClient= banqueChoisie.wantedClient(nomClient);
        if (listClient.size()>0)
            for (Client client:listClient)
                System.out.println(client);
        else
            System.out.println("aucun resultat pour ce nom");
    }
}
