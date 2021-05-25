public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 30, 2, 400);
        basket.add("Water", 20, 10);
        basket.add("IceCream", 15, 3, 40);
        basket.print("Milk");

        Printer printer = new Printer();
        printer.append("товары", "Документ1", 30);
        printer.append("канцелярия", "Документ2");
        printer.append("расходы",27);


    }

}
