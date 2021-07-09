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

            if (command.contains("ADD")) {
                todoList.add(command.substring(command.indexOf(" ")));
                System.out.println("Добавлено дело" + command.substring(command.indexOf(" ")));
            }

            if (command.contains("LIST")) {
                for (int i = 0; i < todoList.deals.size(); i++) {
                        System.out.println(i + " " + todoList.deals.get(i));
                    }
                }

            if(command.contains("EDIT")){
                System.out.print("Дело " +  todoList.deals.get(Integer.parseInt((command.substring(command.indexOf(" ") + 1, command.indexOf(" ") + 2)))) + " заменено");
                todoList.edit((command.substring(command.indexOf(" ") + 2)), Integer.parseInt((command.substring(command.indexOf(" ") + 1, command.indexOf(" ") + 2))));
                System.out.println(" на " + command.substring(command.indexOf(" ") + 2));
            }

            if (command.contains("DELETE")){

                System.out.println("Дело" +todoList.deals.get(Integer.parseInt((command.substring(command.indexOf(" ") + 1, command.indexOf(" ") + 2)))) + " удалено");
                todoList.delete( Integer.parseInt((command.substring(command.indexOf(" ") + 1, command.indexOf(" ") + 2))));
            }
            }

        }

    }

