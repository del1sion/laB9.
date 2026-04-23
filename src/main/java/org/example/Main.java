interface AccountStrategy {
    double calculate(double balance);
}
class SavingsAccountStrategy implements AccountStrategy {
    public double calculate(double balance) {
        return balance * 1.1;
    }
}
class CurrentAccountStrategy implements AccountStrategy {
    public double calculate(double balance) {
        return balance;
    }
}

class Account {

    private String number;
    private double balance;
    private AccountStrategy strategy;

    public Account(String number, double balance, AccountStrategy strategy) {
        this.number = number;
        this.balance = balance;
        this.strategy = strategy;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return strategy.calculate(balance);
    }

    public void showInfo() {
        System.out.println("Number: " + number);
        System.out.println("Balance: " + getBalance());
    }
}

public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account("111", 1000, new SavingsAccountStrategy());
        acc1.deposit(500);
        acc1.showInfo();

        System.out.println();

        Account acc2 = new Account("222", 1000, new CurrentAccountStrategy());
        acc2.withdraw(200);
        acc2.showInfo();
    }
}