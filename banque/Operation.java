package banque;

import java.time.LocalDateTime;

public final class Operation {
  final private int numeroCompteDebiteur;
  final private int numeroCompteCrediteur;
  final private float montant;
  final private LocalDateTime dateTime;
  public Operation(int numeroCompteDebiteur,int numeroCompteCrediteur,float montant,LocalDateTime dateTime){
   this.numeroCompteDebiteur=numeroCompteDebiteur;
   this.numeroCompteCrediteur=numeroCompteCrediteur;
   this.montant=montant;
   this.dateTime=dateTime;
  }

 @Override
 public String toString() {
  return "\n"+"Operation{" +
          "numeroCompteDebiteur=" + numeroCompteDebiteur +
          ", numeroCompteCrediteur=" + numeroCompteCrediteur +
          ", montant=" + montant +
          ", dateTime=" + dateTime +
          '}';
 }

}
