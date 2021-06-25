public class Main {

    public static void main(String[] args) {
        System.out.println("Английский алфавит");
        String alphabet = "abcdefghijklmnopqrstyvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {

            int codeLetter = alphabet.charAt(i);
            System.out.println("Буква " + alphabet.charAt(i) + " - " + codeLetter);
        }
        System.out.println("Русский алфавит");
        String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        for (int a = 0; a < rusAlphabet.length(); a++){

            int codeLetterRus = rusAlphabet.charAt(a);
            System.out.println("Буква " + rusAlphabet.charAt(a) + " - " + codeLetterRus);

        }

    }
}