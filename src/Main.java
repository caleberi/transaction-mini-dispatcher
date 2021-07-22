
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Start the app by generating random but same length numbers to create accou
        //
        // objects.
        HashMap<Integer, Account> table = new HashMap<Integer, Account>();
        ArrayList<Integer> accs = new ArrayList<>();
        Transactions t = new Transactions();
        for (int i = 0; i < 5; i++) {
            // Store your accounts i hashmap for easier lookup using account number as key
            // Yes. Each account should also have random number as balance;
            Account nAccount = new Account(new Random().nextInt(100), new Random().nextDouble() * 100000);
            int nos = nAccount.getAccountNumber();
            accs.add(nos);
            table.put(nos, nAccount);
        }
        // . run multiple transaction to send mone from 1 a/c to the other. Test
        // balances after each transaction. Test for account with balace < amount. Test
        // for zero or negative amount transfer
        int sz = accs.size();
        String[] transType = new String[] { "CR", "DR" };
        for (int i = 0; i < sz; i++) {
            int randOne = new Random().nextInt(sz);
            int randTwo = new Random().nextInt(sz);
            if (randOne != randTwo) {
                Account from = table.get(accs.get(randTwo));
                Account to = table.get(accs.get(randOne));
                String selectedTransaction = transType[new Random().nextInt(2)];
                Transaction transaction = new Transaction(from.getId(), to.getId(), selectedTransaction);
                double amountToUseInTransaction = new Random().nextDouble() * 10_000;
                transaction.setAmount(amountToUseInTransaction);
                transaction.transact(from, to);
                t.addTransaction(transaction);
            }
        }
        System.out.println();
        for (int i = 0; i < t.getTransactionList().size(); i++) {
            System.out.println(t.getTransactionList().get(i).getNarration());
        }
    }
}
