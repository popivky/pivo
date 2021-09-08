import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Неверный формат команды. Верный формат команды: 'add Василий Петров vasily.petrov@gmail.com +79215637722'");
        }
        if (!components[INDEX_PHONE].equals("+" + components[INDEX_PHONE].replaceAll("[^0-9]",""))){
            throw new IllegalArgumentException("Неверный формат номера телефона. Верный формат: +79215637722");
        }
        if  (!components[INDEX_EMAIL].contains("@") || !components[INDEX_EMAIL].contains(".") || components[INDEX_EMAIL].indexOf("@") != components[INDEX_EMAIL].lastIndexOf("@") || components[INDEX_EMAIL].substring(components[INDEX_EMAIL].indexOf("@"),components[INDEX_EMAIL].lastIndexOf(".")).contains(".")) {
            throw new IllegalArgumentException("Неверный формат электронной почты. Верный формат: vasily.petrov@gmail.com");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}