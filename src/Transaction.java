import java.util.Date;

public class Transaction {
    private int from;
    private int to;
    private String narration;
    private double amount;
    private String type;
    private String date;

    /**
     * Generates a narrative description of account performing transaction which are
     * the recieving account and the sending account
     * 
     * @param from the account to transfer from
     * @param to   the account that a transfer should be made to
     */
    public Transaction(int from, int to, String type) {
        setAccountFrom(from);
        setAccountTo(to);
        setType(type);
        this.date = new Date().toString();
    }

    private void setType(String type) {
        this.type = type;
    }

    /**
     * sets the overall description of the transaction
     * 
     * 
     * @param description
     */
    public void setNarration(String narration) {
        this.narration = narration;
    }

    /**
     * 
     * sets the account from which transaction should be made from
     * 
     * @param from
     */
    public void setAccountFrom(int from) {
        this.from = from;
    }

    /**
     * sets the account from which transaction should be made to
     * 
     * @param to
     */
    public void setAccountTo(int to) {
        this.to = to;
    }

    /**
     * retrieves the overall description of the transaction
     * 
     * @param description
     */
    public String getNarration() {
        return narration;
    }

    /**
     * Retreieve the overall account from which transaction should be made
     * 
     * @param description
     */
    public int getFrom() {
        return from;
    }

    /**
     * Retrieve the account to which transaction should be made to
     * 
     * @return account to which transaction is made to
     */

    public int getTo() {
        return to;
    }

    /**
     * Retireive the type of transaction
     * 
     * @return type of transaction
     */
    public String getType() {
        return type;
    }

    /**
     * Get the amount of transaction
     * 
     * @return the amount of transaction
     */
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amountToUseInTransaction) {
        this.amount = amountToUseInTransaction;
    }

    public void transact(Account accountFrom, Account accountTo) {
        System.out.println("Transaction from " + from + " to " + to + " with amount " + amount + " and type " + type);
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
        String msg = String.format(
                "Transaction [type : %s] from account : %d to account : %d -> \n { Account %d has a balance of :%.2f \n Account %d has a balance of :%.2f \n  Date: %s}",
                getType(), from, to, accountFrom.getId(), accountFrom.getBalance(), accountTo.getId(),
                accountTo.getBalance(), date);
        setNarration(msg);
        System.out.println("**********************************************");
        System.out.println("Transaction from " + from + " to " + to + " with amount " + amount + " and type " + type);
        System.out.println("**********************************************");
    }

}
