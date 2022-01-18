import junit.framework.TestCase;

import java.util.*;

public class BankTest extends TestCase {

   public static Bank bank = new Bank();


    @Override
    protected void setUp() throws Exception {

        for (int i = 1; i <= 10; i++){

            long money = new Random().nextInt(1000000) + 150000;

            StringBuilder num = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                num.append((int) (Math.random()*9));
            }

            StringBuilder accNickName = new StringBuilder("Account");
            accNickName.append(i);

            Account account = new Account(money, num.toString());
            bank.addNewClient(accNickName.toString(), account);
        }



    }

    public static void newTransaction(){
        String fromAcc = (String) bank.getAccountDataBase().get(new Random().nextInt(bank.getAccountDataBase().size()));
        String toAcc = (String) bank.getAccountDataBase().get(new Random().nextInt(bank.getAccountDataBase().size()));
        long monyeRandom = new Random().nextInt(100000);
       long beforeFrom = bank.getBalance(fromAcc);
       long beforeTo =  bank.getBalance(toAcc);
        bank.transfer(fromAcc,toAcc,monyeRandom);
        long afterFrom= bank.getBalance(fromAcc);
        long afterTo = bank.getBalance(toAcc);

    }

    public void testGetSumAllAccounts(){
        long amountBeforeTransfer = bank.getSumAllAccounts();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20000 ; i++) {
            threads.add(new Thread(BankTest::newTransaction));

        }


        threads.forEach(Thread::start);
        long actual = bank.getSumAllAccounts();
        long expected = amountBeforeTransfer;
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
