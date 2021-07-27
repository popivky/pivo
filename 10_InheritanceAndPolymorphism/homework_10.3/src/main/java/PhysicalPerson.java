public class PhysicalPerson extends Client {
    @Override
    public String getInfo() {
        return "Поплнение счета без комиссии" + System.lineSeparator() + "Снятие со счёта без комиссии" + System.lineSeparator() + "Остаток на счёте: " + getAmount();
    }
}
