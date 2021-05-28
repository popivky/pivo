public class Main {

    public static void main (String [] args){

        ArithmeticCalculator numbers = new ArithmeticCalculator(10,4);

        numbers.calculate(Operation.ADD);
        numbers.calculate(Operation.MULTIPLY);
        numbers.calculate(Operation.SUBTRACT);


    }

    }
