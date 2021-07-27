import java.util.*;

public class CoolNumbers {

    public static ArrayList<String> numberBase = new ArrayList<>();

    public static List<String> generateCoolNumbers() {

        for (int i = 0; i <= 2000000; i++) {

            int indexLetters = new Random().nextInt(12);
            int digits = new Random().nextInt(10);
            int region = new Random().nextInt((199 - 1) + 1) + 1;
            String letters = "АВЕКМНОРСТУХ";
            char oneLetter = letters.charAt(indexLetters);
            String number = oneLetter + "" + digits + "" + digits + "" + digits + "" + oneLetter + "" + oneLetter + "" + region;

            numberBase.add(number);
        }

        return numberBase;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        return list.contains(number);

    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        Collections.sort(sortedList);
        int indexNumber = Collections.binarySearch(sortedList, number);
        return indexNumber >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
