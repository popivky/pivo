import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Movements {

    private String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }


    public double getExpenseSum() {

        double expense = 0.0;

        try {
            List<String> lines = Files.readAllLines(Path.of(pathMovementsCsv));
            for (String line : lines){
                if (line.replaceAll("[^0-9]","").length() == 0){
                    continue;
                }
                if (line.substring(line.lastIndexOf('"') + 1).length() == 0){
                  Double numDouble = Double.parseDouble((line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'))).replace(',','.'));
                  expense += numDouble;
                } else {
                    Double num = Double.parseDouble(line.substring(line.lastIndexOf(',') + 1).replaceAll("[^0-9]", ""));
                    expense += num;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expense;
    }

    public double getIncomeSum() {

        double income = 0.0;

        try {
            List<String> lines = Files.readAllLines(Path.of(pathMovementsCsv));
            for (String line : lines){
                if (line.replaceAll("[^0-9]","").length() == 0){
                    continue;
                }
                char c = '"';
                if(!line.contains(Character.toString(c))){
                    String half = line.substring(line.lastIndexOf(" ") + 1, line.lastIndexOf(','));
                    Double numHalf = Double.parseDouble(half.substring(half.indexOf(',') + 1));
                    income += numHalf;

                }
                if (line.substring(line.lastIndexOf('"') + 1).length() == 0) {
                    String half = line.substring(line.lastIndexOf(" ") + 1, line.indexOf('"'));
                    Double numHalf = Double.parseDouble(half.substring(half.indexOf(',') + 1, half.lastIndexOf(',')));
                    income +=numHalf;

                }
                    if (line.substring(line.lastIndexOf('"') + 1).length() > 0 && line.contains(Character.toString(c))){
                    Double numDouble = Double.parseDouble((line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'))).replace(',','.'));
                    income += numDouble;
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return income;
    }
}
