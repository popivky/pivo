import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.


      String surname = !input.contains(" ") ? input : input.substring(0, input.indexOf(" "));
      String name =  !input.contains(" ") ? input : ( input.indexOf(" ") == input.lastIndexOf(" ") ? input.substring(input.indexOf(" ") + 1) : input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" ")));
      String patronymic = !input.contains(" ") ? input : input.substring(input.lastIndexOf(" ") + 1);
      String tire = "-";

      if (surname.charAt(0) == tire.charAt(0) || surname.charAt(surname.length() - 1) == tire.charAt(0)){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      if (name.charAt(0) == tire.charAt(0) || name.charAt(name.length() - 1) == tire.charAt(0)){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      if (patronymic.charAt(0) == tire.charAt(0) || patronymic.charAt(patronymic.length() - 1) == tire.charAt(0)){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      surname = !surname.contains("-") ? (surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase()) : surname.substring(0,1).toUpperCase() + surname.substring(1, surname.indexOf("-")).toLowerCase() + "-" + surname.substring(surname.indexOf("-") + 1,surname.indexOf("-") + 2).toUpperCase() + surname.substring(surname.indexOf("-") + 2).toLowerCase();
      name = !name.contains("-") ? (name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase()) : name.substring(0,1).toUpperCase() + name.substring(1, name.indexOf("-")).toLowerCase() + "-" + name.substring(name.indexOf("-") + 1,name.indexOf("-") + 2).toUpperCase() + name.substring(name.indexOf("-") + 2).toLowerCase();
      patronymic = !patronymic.contains("-") ? (patronymic.substring(0,1).toUpperCase() + patronymic.substring(1).toLowerCase()) : patronymic.substring(0,1).toUpperCase() + patronymic.substring(1, patronymic.indexOf("-")).toLowerCase() + "-" + patronymic.substring(patronymic.indexOf("-") + 1,patronymic.indexOf("-") + 2).toUpperCase() + patronymic.substring(patronymic.indexOf("-") + 2).toLowerCase();

      if  ( input.indexOf(" ") == input.lastIndexOf(" ")){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      if( input.equals(surname) || input.equals(name) || input.equals(patronymic)){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      if (name.contains(" ")){
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      for (int i = 0; i < input.length(); i++){
        char a = input.charAt(i);
        if( !Character.isAlphabetic(a)) {

          if (Character.isSpaceChar(a)) {
            continue;
          }
          if (surname.indexOf("-") != surname.lastIndexOf("-") || name.indexOf("-") != name.lastIndexOf("-") || patronymic.indexOf("-") != patronymic.lastIndexOf("-")) {
            System.out.println("Введенная строка не является ФИО");
            break;
          }

          if (a == tire.charAt(0)) {
            continue;
          }

          System.out.println("Введенная строка не является ФИО");
          return;
        }
      }


        System.out.println("Фамилия: " + surname + System.lineSeparator() + "Имя: " + name + System.lineSeparator() + "Отчество: " + patronymic);

      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}