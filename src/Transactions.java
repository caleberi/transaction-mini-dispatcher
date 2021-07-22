//create transactio object - id, date, debit, credit, amout, date, nnarration

import java.util.ArrayList;

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
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

}
