package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int idx = 0; // indice to know where to add the transaction, incremented each time a transaction succeed

    public BankAccount(String name, int startingBalance){
        this.name = name;
        currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount to deposit");
            return;
        }
        currentBalance += amount;
        transactions[idx] = amount;
        idx++;
        System.out.println("Transaction success : +" + amount);
    }

    public void withdraw(double amount){
        if(amount <= 0 || amount > currentBalance){
            System.out.println("Invalid amount to withdraw");
            return;
        }
        currentBalance -= amount;
        transactions[idx] = -amount;
        idx++;
        System.out.println("Transaction success : -" + amount);
    }

    public void displayTransactions(){
        System.out.println("Transactions done: ");
        for(int i = 0; i < idx; i++){
            if(transactions[i] > 0) System.out.println("+"+transactions[i]);
            else System.out.println(transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("Current balance: "+ currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
