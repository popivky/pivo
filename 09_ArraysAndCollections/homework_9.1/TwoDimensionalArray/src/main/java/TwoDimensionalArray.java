public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]


        char [] [] picture = new char[size][size];

        for ( int i = 0; i < picture.length; i++){

            for (int j = 0; j < picture.length; j++) {

                if (size == 1) {
                    picture[i][j] = symbol;
                    return picture;
                }

                picture[i][j] = ' ';
                if ((i + j) % (picture[i].length - 1) == 0) {
                    picture[i][j] = symbol;
                }
                if ((i - j) % (picture[i].length - 1) == 0) {
                    picture[i][j] = symbol;
                }

                System.out.print(picture[i][j]);
            }
            System.out.println();
        }

        return picture;
    }
}
