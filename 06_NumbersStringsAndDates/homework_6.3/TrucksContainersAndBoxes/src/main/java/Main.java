import java.util.Scanner;

public class Main {
    final static int BOXES_IN_CONTAINER = 27;
    final static int CONTAINERS_IN_TRUCK = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int box = Integer.parseInt(boxes);
            int container;
            int i;
            int a = 0;
            int truck = (box/(CONTAINERS_IN_TRUCK * BOXES_IN_CONTAINER)) + 1;
            container = (int) Math.ceil(((double) box / BOXES_IN_CONTAINER));
            if ( box == 0){
                System.out.println("Необходимо:" + System.lineSeparator() +
                        "грузовиков - "  + "0 шт." +   System.lineSeparator() +
                        "контейнеров - " + "0 шт. ");
                return;
            }
            for ( i = 1; i <= box; i++, a++){

                if (a == Math.round(a / (BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK) * BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK)){
                    System.out.println("Грузовик: " + (Math.round(i / (BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK)) + 1));
                }

                if (a == Math.round(a / BOXES_IN_CONTAINER) * BOXES_IN_CONTAINER ){
                    System.out.print("\tКонтейнер: " + (Math.round(i / BOXES_IN_CONTAINER) + 1) + System.lineSeparator());
                }

                System.out.println("\t\tЯщик: " + i);

            }
            System.out.println("Необходимо:" + System.lineSeparator() +
                    "грузовиков - " + truck + " шт." +   System.lineSeparator() +
                    "контейнеров - " + container + " шт. ");



        }



        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

    }


