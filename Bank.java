import java.util.Scanner;

class Bank {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            bank.deposit(initialBalance);

            System.out.println("Bank Account Operations");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("0. Exit");

            int choice;
            do {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(depositAmount);
                        System.out.println("Amount deposited: " + depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        bank.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Current Balance: " + bank.getBalance());
                        break;
                    case 0:
                        System.out.println("Thank you for using the Bank Account system.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 0);
        }
    }
}
