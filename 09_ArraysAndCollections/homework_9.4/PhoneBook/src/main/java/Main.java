import java.util.HashMap;
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
                System.out.println("Контакт сохранён!");
                temp = " ";
                continue;
            }

            if (Character.isDigit(temp.charAt(0))) {

                contacts.addContact(temp, input);
                System.out.println("Контакт сохранён!");
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


                    if (input.replaceAll("[^aA-zZ]", "").equals(input) && temp.equals(" ")) {
                        if (contacts.book.containsKey(input)) {
                            contacts.getPhonesByName(input);
                            System.out.println(contacts.getPhonesByName(input));
                        } else {
                            System.out.println("Такого имени в телефонной книге нет." + System.lineSeparator() + "Введите номер телефона для абонента " + input + ":");
                            temp = input;
                            break;
                        }
                    }

                    if (input.replaceAll("[^0-9]", "").equals(input) && temp.equals(" ")) {
                        if (contacts.book.containsValue(input)) {
                            contacts.getNameByPhone(input);
                            System.out.println(contacts.getNameByPhone(input));

                        } else {
                            System.out.println("Такого номера нет в телефонной книге." + System.lineSeparator() + "Введите имя абонента для номера " + input + ":");
                            temp = input;
                            break;
                        }
                    }
                }
            }
        }
    }
}
