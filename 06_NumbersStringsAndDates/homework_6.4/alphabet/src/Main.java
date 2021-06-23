public class Main {

    public static void main(String[] args) {
        System.out.println("Английский алфавит");
        String alphabet = "abcdefghijklmnopqrstyvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i;
        for (i = 0; i < 52; i++) {

            int codeLetter = alphabet.charAt(i);
            System.out.println("Буква " + alphabet.charAt(i) + " - " + codeLetter);
        }
        System.out.println("Русский алфавит");
        String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        int a;
        for (a = 0; a < 66; a++){

            int codeLetterRus = rusAlphabet.charAt(a);
            System.out.println("Буква " + rusAlphabet.charAt(a) + " - " + codeLetterRus);

        }

    }
}