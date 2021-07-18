import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static PhoneBook contacts = new PhoneBook();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду: ");



        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            contacts.addContact("99999", "natasha");

            if (input.equals("LIST")) {
                contacts.getAllContacts();

                }
            if(Character.isAlphabetic(Integer.parseInt(input))){

                contacts.getPhonesByName(input);
            }



            }


        }

//    private static void printList (HashMap<String, String> map){
//        for(String key : map.keySet()){
//            System.out.println(key);
        }
