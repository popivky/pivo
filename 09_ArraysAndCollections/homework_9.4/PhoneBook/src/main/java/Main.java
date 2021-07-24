import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static PhoneBook contacts = new PhoneBook();

    public static void main(String[] args) {
        String temp = " ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду: ");


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }


            if (input.equals("LIST")) {
                contacts.getAllContacts();
                System.out.println(contacts.getAllContacts());
                continue;

            }

            if (Character.isAlphabetic(temp.charAt(0))) {
                contacts.addContact(input, temp);
                temp = " ";
                continue;
            }

            if (Character.isDigit(temp.charAt(0))) {
                if (contacts.book.containsKey(input)) {
                    String secondNumber = contacts.book.get(input);
                    String allNum = secondNumber + "; " + temp;
                    contacts.addContact(allNum, input);
                    temp = " ";
                    continue;
                }

                contacts.addContact(temp, input);
                temp = " ";
                continue;
            }

            String[] arr = input.split("\\s");
            for (int i = 0; i < arr.length; i++) {

                for (int j = 0; j < arr[i].length(); j++) {

                    char a = arr[i].charAt(j);

                    if (!Character.isAlphabetic(a) && !Character.isDigit(a)) {

                        System.out.println("Неверный формат ввода");
                        break;

                    }


                    if (input.replaceAll("[^аА-яЯ]", "").equals(input) && temp.equals(" ")) {
                        if (contacts.book.containsKey(input)) {
                            contacts.getPhonesByName(input);
                            System.out.println(contacts.getPhonesByName(input).toString().replace("[", "").replace("]", ""));
                            break;
                        } else {
                            System.out.println("Такого имени в телефонной книге нет." + System.lineSeparator() + "Введите номер телефона для абонента " + input + ":");
                            temp = input;
                            break;
                        }
                    }

                    if (input.replaceAll("[^0-9]", "").equals(input) && temp.equals(" ") && !contacts.book.containsValue(input)) {

                        String bookString = contacts.book.toString();

                        if (bookString.contains(input)) {

                            for (Map.Entry<String, String> entry : contacts.book.entrySet()) {

                                if (entry.getValue().contains(input)) {
                                    System.out.println((entry.getKey() + " - " + entry.getValue()));
                                    break;
                                }
                            }

                        } else
                            System.out.println("Такого номера нет в телефонной книге." + System.lineSeparator() + "Введите имя абонента для номера " + input + ":");
                        temp = input;
                        break;
                    }
                }
                if (input.replaceAll("[^0-9]", "").equals(input) && temp.equals(" ") && contacts.book.containsValue(input)) {
                    contacts.getNameByPhone(input);
                    System.out.println(contacts.getNameByPhone(input));
                    break;

                }
            }
        }
    }
}





