import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    LocalDate lastIncome;

    public void take(double amountToTake) {

        if (amountToTake <= money && lastIncome.plusMonths(1).isBefore(LocalDate.now())) {
            money = money - amountToTake;
        }
    }
}
