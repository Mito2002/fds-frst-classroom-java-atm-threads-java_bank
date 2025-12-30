//package ht.ueh.first.java;

//public class BankAccountRobuste {
  //  private int accountNumber;
    //private double balance ;
//
   //  public BankAccountRobuste(int accountNumber, double initialBalance){
     //   this.accountNumber=accountNumber;
       // this.balance=initialBalance;
    //}
   // public synchronized void deposit(double amount){
    //    if(amount <=0) {
     //       throw new InvalidAmountException("Montant invalide pour depot:" + amount + "euro.Droit etre >0");
       // }
        //balance +=amount;
        //System.out.println(Thread.currentThread().getName() + "depose" + String.format("%.2f",amount) + "euro");
    //}
    //public synchronized void withdraw(double amount){
      //  if(amount <=0){
        //    throw new InvalidAmountException("Montant invalide pour retrait: " + amount + "euro.Doit etre >0");
        //}
        //if(balance<amount){
           // throw new InsufficientFundsException("Fond insuffisants.Solde: " + String.format("%2f",balance) + "euro,Retrait demande:" + String.format("%2f",amount) +"euro");
        //}
        //balance -=amount;
      //  System.out.println(Thread.currentThread().getName() + "retire" + String.format("%2f",amount) +"euro");
    //}
    //public synchronized double getBalance(){
      //  return balance;
    //}
    //public synchronized double getAccountNumber(){
     //   return accountNumber;
   // }
 //}