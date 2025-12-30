package ht.ueh.first.java;
//Partie 1 sans Thread
public class BankAccount {
    private  int accountNumber;
    private double balance;

    //Constructeur
    public BankAccount(int accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance= balance;
    }
    //Methodes
    public void deposit(double amount){
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " depose" + amount);
    }
    public void Withdraw (double amount){
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "retire"+ amount );
    }
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }

}
