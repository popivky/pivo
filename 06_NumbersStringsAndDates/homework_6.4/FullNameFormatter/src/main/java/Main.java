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
      String name =  !input.contains(" ") ? input : input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" "));
      String patronymic = input.substring(input.lastIndexOf(" ") + 1);


      if( input.equals(surname)){
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      int i;
      for (i = 0; i < input.length(); i++){
       char a = input.charAt(i);
      if( Character.isDigit(a)){
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