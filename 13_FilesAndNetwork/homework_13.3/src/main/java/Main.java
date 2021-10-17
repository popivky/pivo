import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String OPERATIONS_LIST = "data/movementList.csv";

    public static void main(String[] args) {

        Movements operation = new Movements(OPERATIONS_LIST);
        System.out.println("Общая сумма доходов: " + operation.getIncomeSum() + " руб.");
        System.out.println("Общая сумма расходов: " + operation.getExpenseSum() + " руб." + "\n");
        System.out.println("Суммы расходов по организациям: " + "\n");
        finalViewOperations(expenseDetails(OPERATIONS_LIST)).stream().forEach(System.out::println);


    }

    public static List <String> expenseDetails (String pathFileOperations){
        List<String> expenseOnly = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(pathFileOperations));
            for(String str : lines){
                if (str.replaceAll("[^0-9]","").length() == 0){
                    continue;
                }
                if(Integer.parseInt(str.substring(str.lastIndexOf(',')+1).replaceAll("[^0-9]","")) > 0 ){
                    expenseOnly.add(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenseOnly;
    }

    public static List<String> finalViewOperations (List<String> operations){

    List<String> readyList = new ArrayList<>();
        for(String operate: operations){

                String[]arr = operate.split(",");
                if (arr.length == 8) {
                    String[] op = arr[5].split("\\s{4,20}");
                    String line = op[1] + " ----------------- " + arr[7] + " руб";
                    readyList.add(line);
                }
                if (arr.length > 8){
                    String[] op = arr[5].split("\\s{4,20}");
                    String line = op[1] + " ----------------- " + operate.substring(operate.indexOf('"') + 1, operate.lastIndexOf('"')) + " руб";
                    readyList.add(line);
                }

        }
        return readyList;
    }

}
