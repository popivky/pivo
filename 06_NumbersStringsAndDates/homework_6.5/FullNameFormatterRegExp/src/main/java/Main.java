import java.util.Scanner;

public class Main {

  final static int NAME_SURNAME_PATRONYMIC = 3;
  final static int NAME_INDEX = 1;
  final static int SURNAME_INDEX = 0;
  final static int PATRONYMIC_INDEX = 2;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      String[] words = input.split("\\s+");

      if (words.length != NAME_SURNAME_PATRONYMIC) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }

      String surname = words[SURNAME_INDEX];
      String name = words[NAME_INDEX];
      String patronymic = words[PATRONYMIC_INDEX];
      String tire = "-";

      for (int z = 0; z < name.length(); z++) {

        char codeLettersName = name.charAt(z);

        if (!Character.isAlphabetic(codeLettersName)) {
          if (name.indexOf("-") != name.lastIndexOf("-")) {
            System.out.println("Введенная строка не является ФИО");
            return;
          }
          if (codeLettersName == tire.charAt(0)) {
            continue;
          }

          System.out.println("Введенная строка не является ФИО");
          return;
        }
        for (int x = 0; x < surname.length(); x++) {

          char codeLettersSurname = surname.charAt(x);

          if (!Character.isAlphabetic(codeLettersSurname)) {
            if (surname.indexOf("-") != surname.lastIndexOf("-")) {
              System.out.println("Введенная строка не является ФИО");
              return;
            }
            if (codeLettersSurname == tire.charAt(0)) {
              continue;
            }

            System.out.println("Введенная строка не является ФИО");
            return;
          }
          for (int y = 0; y < patronymic.length(); y++) {

            char codeLettersPatronymic = patronymic.charAt(z);

            if (!Character.isAlphabetic(codeLettersPatronymic)) {
              if (patronymic.indexOf("-") != patronymic.lastIndexOf("-")) {
                System.out.println("Введенная строка не является ФИО");
                return;
              }
              if (codeLettersPatronymic == tire.charAt(0)) {
                continue;
              }

              System.out.println("Введенная строка не является ФИО");
              return;
            }
          }
        }
      }
      System.out.println("Фамилия: " + surname + System.lineSeparator() + "Имя: " + name + System.lineSeparator() + "Отчество: " + patronymic);
    }
  }
}


