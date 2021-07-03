import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) {
    LocalDate birthday = LocalDate.of(1995,5, 23);

    System.out.println(getPeriodFromBirthday(birthday));

  }

  private static String getPeriodFromBirthday(LocalDate birthday) {

    LocalDate today = LocalDate.now();
    LocalDate howLong = today.minusDays(birthday.getDayOfMonth()).minusMonths(birthday.getMonthValue()).minusYears(birthday.getYear());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy MM dd");
      System.out.println((formatter.format(howLong)).substring(0, 2) + " years, " + (formatter.format(howLong)).substring(3, 5) + " months, " + (formatter.format(howLong)).substring(6) + " days");


    return "";
  }

}
