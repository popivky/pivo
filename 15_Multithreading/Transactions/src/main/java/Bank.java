import java.util.*;

public class Bank {

    private final long checkedAmount = 50000;

//    public Bank(Map<String, Account> accounts) {
//        this.accounts = accounts;
//    }

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void  transfer(String fromAccountNum, String toAccountNum, long amount) {

        if(accounts.get(fromAccountNum).getIsBlocked() ){
            System.out.println("Счет: " + accounts.get(fromAccountNum).getAccNumber() + " заблокирован. Операция невозможна.");
          //  return;
        }
        if(accounts.get(toAccountNum).getIsBlocked() ){
            System.out.println("Счет: " + accounts.get(toAccountNum).getAccNumber() + " заблокирован. Операция невозможна.");
          //  return;
        }
        if (accounts.get(fromAccountNum).getMoney() < amount){
            System.out.println("Недостаточно средств на счете " + accounts.get(fromAccountNum).getAccNumber() + " для перевода.");
          //  return;
        }

       accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
       accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
       if(amount > checkedAmount){
           try {
              if(isFraud(fromAccountNum, toAccountNum, amount)){
                  accounts.get(fromAccountNum).setBlocked(true);
                  System.out.println("Подозрительная операция! Счет: " + accounts.get(fromAccountNum).getAccNumber() + " заблокирован!");
                  accounts.get(toAccountNum).setBlocked(true);
                  System.out.println("Подозрительная операция! Счет: " + accounts.get(toAccountNum).getAccNumber() + " заблокирован!");
              }

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {

        long sumAllAccounts = 0;

        for(Account account : accounts.values()){
            sumAllAccounts += account.getMoney();
        }

        return sumAllAccounts;
    }

    public List getAccountDataBase(){
        ArrayList<String> base = new ArrayList<>();
        base.addAll(accounts.keySet());
        return base;
    }
    public List getAccounts(){
        ArrayList<Account> baseAccounts = new ArrayList<>();
        baseAccounts.add((Account) accounts.values());
        return baseAccounts;
    }

    public void addNewClient(String nickName, Account account){
        accounts.put(nickName,account);
    }
}
