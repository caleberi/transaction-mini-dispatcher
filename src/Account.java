
import java.util.Random;

/**
 * @author hebronace
 * @apiNote This api represent the basic UML of an account for a user cco
 *          ntNumber , id and balance
 * 
 */

public class Account {
    private int id;
    private int accountNumber;
    private double balance;

    /**
     * This represent the user account details
     * 
     * @param accountNumber the account unique id
     * @param balance       the account balance of the user
     */
    public Account(int accountNumber, double balance) {
        deposit(balance);
        setAccountNumber(accountNumber);
        this.id = new Random().nextInt(100);
    }

    /**
     * This sets the users account number
     * 
     * @param accountNumber the account number
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Retrieves the account number of the user
     * 
     * @return account number
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Retrieves the account balance
     * 
     * @return get the current balance on an account
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Retrieves the account ID
     * 
     * @return
     */
    public int getId() {
        return this.id;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("amount cannot be greater than balance");
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
