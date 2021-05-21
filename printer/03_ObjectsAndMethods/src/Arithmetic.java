public class Arithmetic {
    public int x;
    public int y;


    public Arithmetic(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void sum(int x, int y) {
        int sum = x + y;
    }
    public void difference(int x, int y){
        int difference = x - y;
    }
    public void product (int x, int y) {
        int product = x * y;
    }
    public void middle(int x, int y){
        int middle = (x + y)/2;
    }
    public void max(int x, int y){
        int max = x > y ? x : y;
    }
    public void min(int x, int y){
        int min = x < y ? x : y;
    }


    }

