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

      surname = surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase();
      name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
      patronymic = patronymic.substring(0,1).toUpperCase() + patronymic.substring(1).toLowerCase();

      if  ( input.indexOf(" ") == input.lastIndexOf(" ")){
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      if( input.equals(surname) || input.equals(name) || input.equals(patronymic)){
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      for (int i = 0; i < input.length(); i++){
        for (int y = 0; y < name.length(); y++){         // проверка имени на символы
          char b = name.charAt(y);
          if (!Character.isAlphabetic(b)){
            System.out.println("Введенная строка не является ФИО");
            return;
          }
        }
        for (int z = 0; z < patronymic.length(); z++){  // проверка отчества на символы
          char e = patronymic.charAt(z);
          if (!Character.isAlphabetic(e)){
            System.out.println("Введенная строка не является ФИО");
            return;
          }
        }
        char a = input.charAt(i);
        if( !Character.isAlphabetic(a)){
          if (Character.isSpaceChar(a)){
            continue;
          }
          if (surname.indexOf("-") != surname.lastIndexOf("-")){

            System.out.println("Введенная строка не является ФИО");
            return;
          }

          if (a == tire.charAt(0)){
            continue;
          }

          System.out.println("Введенная строка не является ФИО");
          return;
        }
      }
      if (name.contains(" ")){
        System.out.println("Введенная строка не является ФИО");
        return;
      }
      System.out.println("Фамилия: " + surname + System.lineSeparator() + "Имя: " + name + System.lineSeparator() + "Отчество: " + patronymic);

      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}