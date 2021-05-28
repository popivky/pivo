public class ArithmeticCalculator {

    private int x;
    private int y;
    private int add;
    private int multiply;
    private int subtract;



    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void calculate(Operation operation) {
        if (operation == Operation.ADD) {
            add = x + y;
            System.out.println("Сумма = " + add);

        }
        if (operation == Operation.MULTIPLY) {
            multiply = x - y;
            System.out.println("Разность = " + multiply);

        }
        if (operation == Operation.SUBTRACT) {
            subtract = x / y;
            System.out.println("Частное = " + subtract);
        }
    }

}

