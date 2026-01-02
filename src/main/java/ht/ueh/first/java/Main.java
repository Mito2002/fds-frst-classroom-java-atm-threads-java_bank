package ht.ueh.first.java;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("partie test  simple ");

        BankAccount account = new BankAccount(123456, 1000.0);
        System.out.println("solde initial: " + account.getBalance() + "euro");

        account.deposit(200);
        account.Withdraw(150);

        System.out.println("solde final : " + account.getBalance() + "euro");


        System.out.println("\n Partie 3 — Mise en évidence d’une Race Condition ");

        BankAccount sharedAccount = new BankAccount(234567, 1000);

        System.out.println("solde initial :" + sharedAccount.getBalance() + "euro");
        System.out.println("Deux Threads tentent chacun de retirer 700 euros");

        Thread t1 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.WITHDRAW, 700), "Client : 1");
        Thread t2 = new Thread(new ATMTask(sharedAccount, ATMTask.Action.WITHDRAW, 700), "Client : 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Solde final: " + sharedAccount.getBalance() + " euro");

       // reponse des questions
        System.out.println("Quel solde attend-on théoriquement ? reponse: -400 euros");
        System.out.println("Quel solde observez-vous parfois ? reponse: 2) -400 euros ");
        System.out.println("Pourquoi les deux retraits peuvent-ils réussir ? reponse: 3) car par definiton du Thread c'est son role permet d'executer deux taches en parallele o peut dire aussi que le lecteur du solde n'est pa atomique");
        System.out.println("Comment appelle-t-on ce type de problème? reponse: 4) Race condition");

    }
}
       /** System.out.println("\n======= Partie 4 —Synchronisation avec synchronized=======");

        BankAccountSynchronized safeAccount = new BankAccountSynchronized(498765, 1000.0);

        System.out.println("solde initial :" + safeAccount.getBalance() + "euro");

        Thread t3 = new Thread(() -> {
            safeAccount.withdraw(700);
        }, "Client:3");
        Thread t4 = new Thread(() -> {
            safeAccount.withdraw(700);
        }, "Client:4");

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("solde final avec synchronized:" + safeAccount.getBalance() + "euro");

        System.out.println("\n Questions/reponses");

        System.out.println("parcequ'un seul Thread a la fois peut executer les methodes synchronisee");
        System.out.println("ils sont mis en attente dans une file jusqu'a ce que le verrou soit libere");

        System.out.println("\n Partie 5 - simulation multi-clients");

        BankAccountSynchronized multiAccount = new BankAccountSynchronized(23456, 5000.0);

        Random random = new Random();
        Thread[] clients = new Thread[10];

        System.out.println("solde initial" + multiAccount.getBalance() + "euro");
        System.out.println("10 clients  effectuent chacun 5 operations aleatoires... ");

        // on va creer les Threads
        for (int i = 0; i< 10; i++) {
            final int clientId = 1 + i;
            clients[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        // Simulation d'attente a l'ATM
                        Thread.sleep(random.nextInt(100));
                        int operation = random.nextInt(3);
                        double amount = random.nextDouble() * 500;

                        switch (operation) {
                            case 0: // Depot
                                multiAccount.deposit(amount);
                                break;
                            case 1://Retrait
                                multiAccount.withdraw(amount);
                                break;
                            case 2:// Consultation
                                System.out.println("Client-" + clientId + " cobsulte: " + multiAccount.getBalance() + "euro");
                                break;
                        }
                        Thread.sleep(50);//Temps entre les operations
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Client-" + (i + 1));
        }
        //Lancement des threads
        for (Thread client : clients) {
            client.start();
        }

        for (Thread client : clients) {
            client.join();
        }

        System.out.println("Simulation terminee. Solde final: " + multiAccount.getBalance() + "euro");

        System.out.println("\n =======Partie 6 Gestion des Exceptions=======");

        BankAccountRobuste robustAccount = new BankAccountRobuste(33333, 1000.0);

        System.out.println("Solde initial: " + robustAccount.getBalance() + "€");

        // Création des scénarios de test
        Thread[] testThreads = new Thread[4];

        // 1. Retrait valide
        testThreads[0] = new Thread(
                new ATMTaskRobuste(1, robustAccount, ATMTaskRobuste.Action.WITHDRAW, 200), "Client-Valide");

        // 2. Retrait trop grand (fonds insuffisants)
        testThreads[1] = new Thread(
                new ATMTaskRobuste(2, robustAccount, ATMTaskRobuste.Action.WITHDRAW, 1500), "Client-FondsInsuffisants");

        // 3. Dépôt négatif
        testThreads[2] = new Thread(
                new ATMTaskRobuste(3, robustAccount, ATMTaskRobuste.Action.DEPOSIT, -50), "Client-DepotNegatif");

        // 4. Consultation du solde
        testThreads[3] = new Thread(
                new ATMTaskRobuste(4, robustAccount, ATMTaskRobuste.Action.BALANCE), "Client-Consultation");

        // Lancement des tests
        for (Thread t : testThreads) {
            t.start();
        }

        // Attente
        for (Thread t : testThreads) {
            t.join();
        }

        System.out.println("Scénarios de test terminés. Solde final: " +
                String.format("%.2f", robustAccount.getBalance()) + "€");

    **/