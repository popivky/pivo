import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static ArrayList<String> numberBase = new ArrayList<>();
    public static HashSet<String> numberBaseHashSet = new HashSet<>();
    public static TreeSet<String> numberBaseTreeSet = new TreeSet<>();
    public static final String NUMBER = "Е444ЕЕ150";


    public static void main(String[] args) {


        for (int i = 0; i <= 2000000; i++) {

            int indexLetters = new Random().nextInt(12);
            int digits = new Random().nextInt(10);
            int region = new Random().nextInt((199 - 1) + 1) + 1;
            String letters = "АВЕКМНОРСТУХ";
            char oneLetter = letters.charAt(indexLetters);
            String number = oneLetter + "" + digits + "" + digits + "" + digits + "" + oneLetter + "" + oneLetter + "" + region;

            numberBase.add(number);
            numberBaseHashSet.add(number);
            numberBaseTreeSet.add(number);
        }

        long start1 = System.nanoTime();
        if (numberBase.contains(NUMBER)) {

            System.out.println("Поиск перебором в списке. Наличие номера " + NUMBER + ": найден. Поиск занял: " + (System.nanoTime() - start1) + " нс.");
        } else
            System.out.println("Поиск перебором в списке. Наличие номера " + NUMBER + ": не найден. Поиск занял: " + (System.nanoTime() - start1) + " нс.");

        Collections.sort(numberBase);
        long start2 = System.nanoTime();
        if ((Collections.binarySearch(numberBase, NUMBER)) >= 0) {

            System.out.println("Бинарный поиск в списке. Наличие номера " + NUMBER + ": найден. Поиск занял: " + (System.nanoTime() - start2) + " нс.");
        } else
            System.out.println("Бинарный поиск в списке. Наличие номера " + NUMBER + ": не найден. Поиск занял: " + (System.nanoTime() - start2) + " нс.");


        long start3 = System.nanoTime();
        if (numberBaseHashSet.contains(NUMBER)) {

            System.out.println("Поиск в HashSet. Наличие номера " + NUMBER +": найден. Поиск занял: " + (System.nanoTime() - start3) + " нс.");
        } else
            System.out.println("Поиск в HashSet. Наличие номера " + NUMBER + ": не найден. Поиск занял: " + (System.nanoTime() - start3) + " нс.");


        long start4 = System.nanoTime();
        if (numberBaseTreeSet.contains(NUMBER)) {

            System.out.println("Поиск в TreeSet. Наличие номера " + NUMBER + ": найден. Поиск занял: " + (System.nanoTime() - start4) + " нс.");
        } else
            System.out.println("Поиск в TreeSet. Наличие номера " + NUMBER + ": не найден. Поиск занял: " + (System.nanoTime() - start4) + " нс.");


    }

}
