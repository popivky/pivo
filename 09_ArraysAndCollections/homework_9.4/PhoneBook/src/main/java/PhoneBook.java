import java.util.*;

public class PhoneBook {
    public HashMap<String, String> book = new HashMap<>();
    public TreeSet<String> digits = new TreeSet<>();
    public TreeSet<String> contacts = new TreeSet<>();


    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if ((name.equals(name.replaceAll("[^аА-яЯ]", "")) && phone.equals(phone.replaceAll("[^0-9]", ""))) && (!name.isEmpty() && !phone.isEmpty()) || phone.contains("; ")) {

            if (book.containsValue(phone)) {

                String text = String.valueOf((book.toString()));
                String[] arr = text.split(",\\s");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].replaceAll("[^0-9]", "").equals(phone)) {
                        book.remove(arr[i].replaceAll("[^аА-яЯ]", ""));
                    }
                }
            }

            book.put(name, phone);
            System.out.println("Контакт сохранён!");


        } else System.out.println("Неверный формат ввода");

    }


    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String info = "" + book;
        String[] arr = info.split(",\\s+");
        String name = "";
        String number = "";

        for (int i = 0; i <= arr.length - 1; i++) {
            number = arr[i].replaceAll("[^0-9]", "");
            name = arr[i].replaceAll("[^аА-яЯ]", "");
            if (number.equals(phone)) {
                break;
            }

        }
        return name + " - " + number;
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        if (book.containsKey(name)) {
            digits.clear();

            name = name + " - " + book.get(name);

            digits.add(name);


            //           System.out.println(digits.toString().replace("[", "").replace("]", ""));

        }
        return digits;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        if (!book.isEmpty()) {

            for (String s : book.keySet()) {

                contacts.add(s + " - " + book.get(s));
            }

        }

        return contacts;

    }

}