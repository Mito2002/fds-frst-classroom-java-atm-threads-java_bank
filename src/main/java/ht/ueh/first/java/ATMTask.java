package ht.ueh.first.java;

public class ATMTask implements Runnable{
    public enum Action {
        DEPOSIT,WITHDRAW,BALANCE
    }
    private BankAccount account;
    private Action action;
    private double amount;

    public ATMTask(BankAccount account,Action action,double amount){
        this.account =account;
        this.action= action;
        this.amount = amount;
    }
    public ATMTask(BankAccount account,Action action){
        this(account,action,0.0);
    }
    @Override
    public void  run(){
        switch( action){
            case DEPOSIT: account.deposit(amount);
                break;
            case WITHDRAW: account.Withdraw(amount);
                break;
            case BALANCE: System.out.println(Thread.currentThread().getName() + "consulter le solde: " + account.getBalance() + "euro");
        }
    }
}
