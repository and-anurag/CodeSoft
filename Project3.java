import java.util.Scanner;
//Project3.java

public class Project3 {
    public static void main(String[] args) {
        double initialBalance = 5000;
        ATM atm = new ATM(initialBalance);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your Option : ");
            int option = scanner.nextInt();
            atm.processOption(option);
            System.out.println();
        }
    }
}


//ATM.java

import java.util.Scanner;
class ATM {
    private double balance;
    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }
    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }
    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.print("Invalid Option");
        }
    }
    private void checkBalance() {
        System.out.print("Current Balance : $" + balance);
    }
    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Amount to Withdraw : $");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient Balance..");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful !!");
            System.out.print("Remaining Balance : $" + balance);
        }
    }
    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Amount to Deposit : $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful !!");
        System.out.print("Current Balance : $" + balance);
    }
}





