import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BankAccount {
    private String name;
    private double balance;
    protected ArrayList<String> history = new ArrayList<>();

    protected DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    protected String getDateTime() {
        return LocalDateTime.now().format(formatter);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount.");
        } else {
            balance += amount;
            history.add("[" + getDateTime() + "] Deposited: " + amount);
            System.out.println("✅ Deposit successful! (" + getDateTime() + ")");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            history.add("[" + getDateTime() + "] Withdraw: " + amount);
            System.out.println("✅ Withdrawal successful! (" + getDateTime() + ")");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void showHistory() {
        System.out.println("📜 Transaction History:");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String h : history) {
                System.out.println("- " + h);
            }
        }
    }
}


class SavingsAccount extends BankAccount {

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    public void addSavings(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid savings amount.");
        } else {
            deposit(amount);
            history.add("[" + getDateTime() + "] Added to savings: " + amount);
            System.out.println("✅ Added to savings: " + amount + " (" + getDateTime() + ")");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctPIN = "0425";

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (!pin.equals(correctPIN)) {
            System.out.println("❌ Wrong PIN. Access denied.");
            return;
        }

        System.out.println("✅ Login successful!");

        SavingsAccount account = new SavingsAccount("Student", 0);
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Add to Savings");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Enter valid choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.print("Amount to add to savings: ");
                    account.addSavings(sc.nextDouble());
                    break;

                case 5:
                    account.showHistory();
                    break;

                case 6:
                    System.out.println("exiting");
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }

        } while (choice != 6);

        sc.close();
    }
}
