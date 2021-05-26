public class ArithmeticCalculator {

    private int x;
    private int y;
    private int add;
    private int multiply;
    private int subtract;

    public Operation operation;

    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArithmeticCalculator(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void calculate(Operation operation) {
        if (operation == Operation.ADD) {
            this.add = x + y;
            System.out.println("Сумма = " + add);

        }
        if (operation == Operation.MULTIPLY) {
            this.multiply = x - y;
            System.out.println("Разность = " + multiply);

        }
        if (operation == Operation.SUBTRACT) {
            this.subtract = x / y;
            System.out.println("Частное = " + subtract);
        }
    }

}

