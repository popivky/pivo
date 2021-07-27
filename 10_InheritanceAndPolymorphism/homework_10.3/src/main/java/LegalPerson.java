public class LegalPerson extends Client {

    public void take(double amountToTake) {
        double onePercentOfAmountToTake = amountToTake / 100;
        if((amountToTake + onePercentOfAmountToTake) <= money){
            money -=(amountToTake + onePercentOfAmountToTake);
        }
    }

    @Override
    public String getInfo() {
        return "Дополнительная комиссия за снятие со счета - 1%" + System.lineSeparator() + "Пополнение счета без комиссии" + System.lineSeparator() + "Остаток на счёте: " + getAmount();
    }
}
