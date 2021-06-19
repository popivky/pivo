public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double square;
        square = Math.PI * Math.pow(radius, 2);
        return square;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {

        double volume;

        volume = ((double) 4 / 3) * Math.PI * Math.pow(Math.abs(radius), 3);

        return volume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {

        return (a + b) > c && ((a + c) > b && (b + c) > a);
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
       if (!isTrianglePossible(a, b, c)){
           return -1;
       }
        double square;
        double halfPerimeter = (a + b + c) / 2;
        square = Math.sqrt( halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

        return square;
    }
}
