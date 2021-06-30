import java.util.Scanner;

public class Main {

  final static int SMALL_NUMBERS = 9;
  final static int CURRENT_NUMBERS = 11;
  final static int NUMBERS_WITH_OUT_CODE_COUNTRY = 10;
  final static String EIGHT = "8";
  final static String SEVEN = "7";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.

      String numbers = input.replaceAll("[^0-9]","");

      if(numbers.length() == CURRENT_NUMBERS){

      if (Character.toString(numbers.charAt(0)).equals(EIGHT)) {
        numbers = "7" + numbers.substring(1);
        System.out.println(numbers);
        break;
      }
         if (Character.toString(numbers.charAt(0)).equals(SEVEN)){
           System.out.println(numbers);
           break;
         }
       System.out.println("Неверный формат номера");
         break;

    }

      if ( numbers.length() == NUMBERS_WITH_OUT_CODE_COUNTRY){
        numbers = "7" + numbers;
        System.out.println(numbers);
        break;
      }

      if (numbers.length() <= SMALL_NUMBERS){
        System.out.println("Неверный формат номера");
        break;
      }

      if (numbers.length() > CURRENT_NUMBERS){
        System.out.println("Неверный формат номера");
        break;
      }

        System.out.println(numbers);
    }
  }

}
