import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();


    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;


            }

            //TODO: write code here

            String[] arr = input.split(",?\\s+");

            if (arr.length < 2 && !arr[0].equals("LIST")){
                continue;
            }

            if (input.contains("ADD")){

                emailList.add(input.substring(input.indexOf(" ")));
            }


            if(input.contains("LIST")){

                System.out.println(emailList.getSortedEmails());
                continue;
            }
            if (!input.contains("@") || !input.contains(".") || input.indexOf("@") != input.lastIndexOf("@") || input.substring(input.indexOf("@"),input.lastIndexOf(".")).contains(".")) {


                System.out.println(WRONG_EMAIL_ANSWER);
            }


        }
    }
}
