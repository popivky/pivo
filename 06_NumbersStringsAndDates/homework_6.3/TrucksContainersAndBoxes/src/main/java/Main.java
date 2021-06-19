import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int box = Integer.parseInt(boxes);
            int container;
            int i;
            int a = 0;
            int truck = (box/ 324) + 1;
            truck = truck == 0 ? (truck + 1) : truck;
            container = (int) Math.ceil(((double) box / 27));
            if ( box == 0){
                System.out.println("Необходимо:" + System.lineSeparator() +
                        "грузовиков - "  + "0 шт." +   System.lineSeparator() +
                        "контейнеров - " + "0 шт. ");
                return;
            }
            for ( i = 1; i <= box; i++, a++){

                if (a == Math.round(a / (27 * 12) * 27 * 12)){
                    System.out.println("Грузовик: " + (Math.round(i / (27 * 12)) + 1));
                }

                if (a == Math.round(a / 27) * 27 ){
                    System.out.print("\tКонтейнер: " + (Math.round(i / 27) + 1) + System.lineSeparator());
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


