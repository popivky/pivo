public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int allPrice = 0;
    private static int allItemCount = 0;
    private static int averagePrice;
    private static int averageBasketCost;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public static void setAllPrice (int price){
    allPrice = allPrice + price;
    }
    public static int getAllPrice(){
    return allPrice;
    }

    public static void setItemCount (int count){
        allItemCount = allItemCount + count;
    }

    public static int getAllItemCount(){
        return allItemCount;
    }

    public static int averagePrice (){
        averagePrice = allPrice / allItemCount;
        return averagePrice;
    }

    public static int averageBasketCost(){
        averageBasketCost = allPrice / count;
        return averageBasketCost;
    }





    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }
    public void add(String name, int price, int count, double weight){
        if (weight > 0) {
            items = items + "\n" + name + " - " + count + " шт. - " + price + " - " + weight + " г.";}
        else {
            items = items + "\n" + name + " - " + count + " шт. - " + price;
        }
        totalWeight = totalWeight + count * weight;}

    public double getTotalWeight() {
        return totalWeight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }



    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
