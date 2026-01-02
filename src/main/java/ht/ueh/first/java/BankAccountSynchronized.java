package ht.ueh.first.java;

import com.sun.source.tree.SynchronizedTree;

public class BankAccountSynchronized {
    private int accountNumber;
    private  double balance;

    public BankAccountSynchronized(int accountNumber, double balance){
        this.accountNumber= accountNumber;
        this.balance= balance;
    }
    public synchronized void deposit(double amount){
        balance +=amount;

        System.out.println(Thread.currentThread().getName() + "depose" + amount + "euro");
    }
    public synchronized void withdraw(double amount){
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "retire" + amount + "euro");
    }
    public synchronized double getBalance(){
        return balance;
    }
    public synchronized  int getAccountNumber(){
        return getAccountNumber();

    }
}
