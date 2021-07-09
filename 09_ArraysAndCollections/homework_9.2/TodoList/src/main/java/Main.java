import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        System.out.println("Введите команду");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String command = scanner.nextLine();
            String[] arr = command.split(",?\\s+");
            String text = "";

            if (arr.length < 2 && !arr[0].equals("LIST")){
                continue;
            }

            if (command.contains("ADD")) {
                todoList.add(command.substring(command.indexOf(" ")));
                System.out.println("Добавлено дело" + command.substring(command.indexOf(" ")));
            }

            if (command.contains("LIST")) {
                for (int i = 0; i < todoList.deals.size(); i++) {
                        System.out.println(i + " " + todoList.deals.get(i));
                    }
                }

            if(command.contains("EDIT")) {

                System.out.print("Дело " + todoList.deals.get(Integer.parseInt(arr[1])) + " заменено");

                for (int i = 2; i < arr.length; i++) {

                    text = text + " " + arr[i];
                }

                todoList.edit(text, Integer.parseInt(arr[1]));

                System.out.println(" на " + text);
            }

            if (command.contains("DELETE")){
                if( Integer.parseInt(arr[1]) > todoList.deals.size() - 1){
                    System.out.println("Дело с таким номером не существует");
                    continue;
                }

                System.out.println("Дело" + todoList.deals.get(Integer.parseInt(arr[1])) + " удалено");
                todoList.delete((Integer.parseInt(arr[1])));
            }
            }

        }

    }

