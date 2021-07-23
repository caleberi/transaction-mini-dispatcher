//create transactio object - id, date, debit, credit, amout, date, nnarration

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @apiNote Transaction represent the overall information about the payment made
 *          ransaction representation
 * @param transactionType this represent the transaction information whether
 *                        "credit"/"debit"
 * @param amount          amount ti be either credited/debited
 * @param narration       summary narration representation object
 * 
 */
public class Transactions {
    private ArrayList<Transaction> transactionList;
    private HashMap<Integer, Account> table;

    /**
     * Generates a transaction representation
     * 
     * @param transactionType this represent the transaction information whether
     *                        "credit"/"debit"
     * @param amount          amount ti be either credited/debited
     * @param narration       summary narration representation object
     */
    public Transactions() {
        transactionList = new ArrayList<Transaction>();
        table = new HashMap<Integer, Account>();
    }

    public void addTransaction(Transaction transaction) {

        this.transactionList.add(transact(transaction));
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public HashMap<Integer, Account> getTable() {
        return table;
    }

    public Transaction transact(Transaction transaction) {
        Account accountTo = getTable().get(transaction.getTo());
        Account accountFrom = getTable().get(transaction.getFrom());

        System.out.println("Transaction from " + transaction.getFrom() + " to " + transaction.getTo() + " with amount "
                + transaction.getAmount() + " and type " + transaction.getType());
        accountFrom.withdraw(transaction.getAmount());
        accountTo.deposit(transaction.getAmount());
        String msg = String.format(
                "Transaction [type : %s] from account : %d to account : %d -> \n { Account %d has a balance of :%.2f \n Account %d has a balance of :%.2f \n  Date: %s}",
                transaction.getType(), accountFrom.getId(), accountTo.getId(), accountFrom.getId(),
                accountFrom.getBalance(), accountTo.getId(), accountTo.getBalance(), transaction.getDate());
        transaction.setNarration(msg);
        System.out.println("**********************************************");
        System.out.println("Transaction from " + accountFrom.getId() + " to " + accountTo.getId() + " with amount "
                + transaction.getAmount() + " and type " + transaction.getType());
        System.out.println("**********************************************");
        return transaction;
    }

}
