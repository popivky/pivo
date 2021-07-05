public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        String word;

        for(int i = 0; i < strings.length / 2; i++){

            word = strings[strings.length-i-1];
            strings[strings.length-i-1] = strings[i];
            strings[i] = word;


        }

        return strings;
    }
}
