 class Database {

    private final int size;
    private final int weight;
    private final String address;
    private final boolean flippable;
    private final int number;
    private final boolean fragile;

     public Database(int size, int weight, String address, boolean flippable, int number, boolean fragile) {
         this.size = size;
         this.weight = weight;
         this.address = address;
         this.flippable = flippable;
         this.number = number;
         this.fragile = fragile;
     }

     public int getSize() {
         return size;
     }

     public int getWeight() {
         return weight;
     }

     public String getAddress() {
         return address;
     }

     public boolean isFlippable() {
         return flippable;
     }

     public int getNumber() {
         return number;
     }

     public boolean isFragile() {
         return fragile;
     }

     public Database setWeight(int weight){
         return new Database(size, weight, address, flippable, number, fragile);
     }

     public Database setAddress(String address){
         return new Database(size, weight, address, flippable, number, fragile);
     }
     public Database setSize(int size){
         return new Database(size, weight, address, flippable, number, fragile);
     }
 }
