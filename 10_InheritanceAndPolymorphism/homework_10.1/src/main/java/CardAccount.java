public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        double onePercentOfAmountToTake = amountToTake / 100;
        if ((amountToTake + onePercentOfAmountToTake) <= money) {
            money -= (amountToTake + onePercentOfAmountToTake);
        }
    }
}

