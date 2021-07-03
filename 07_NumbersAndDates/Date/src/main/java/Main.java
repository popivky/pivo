import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate today = LocalDate.now();
        LocalDate birthDay = LocalDate.of(year, month, day);
        int yearOld = 0;

        for(int i = year; i < today.getYear(); i++ ){

//            if (birthDay.until(today, ChronoUnit.YEARS) <= 1){
//                break;
//            }

            System.out.print(yearOld++ + " - " + birthDay.getDayOfMonth() + "." + birthDay.getMonthValue() + "." + birthDay.getYear() + " - " + birthDay.getDayOfWeek() + System.lineSeparator());

            birthDay = birthDay.plusYears(1);

              if (birthDay.isAfter(today)) {
                  break;
           }
        }

        return "";
    }
}
