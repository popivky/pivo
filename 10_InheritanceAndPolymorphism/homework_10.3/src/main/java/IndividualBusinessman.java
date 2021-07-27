public class IndividualBusinessman extends Client {


    public void put(double amountToPut) {
        double onePercentOfAmountToPut = amountToPut / 100;
        double halfOnePercentOfAmountToPut = onePercentOfAmountToPut / 2.0;

        if (amountToPut > 0 && amountToPut < 1000) {
            money += amountToPut - onePercentOfAmountToPut;
        }
        if (amountToPut > 0 && amountToPut >= 1000)
        money += amountToPut - halfOnePercentOfAmountToPut;

    }

    @Override
    public String getInfo() {
        return "Пополнение с комиссией 1%, если сумма меньше 1 000 рублей. И пополнение с комиссией 0,5%, если сумма больше либо равна 1 000 рублей." + System.lineSeparator() + "Снятие со счёта без комиссии" + System.lineSeparator() + "Остаток на счёте: " + getAmount();
    }
}
