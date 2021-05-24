public class Dimensions {
    private final int length;
    private final int width;
    private final int height;

    public Dimensions(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void getVolume (){
        int volume = length * width * height;
        System.out.println("Объем груза = " + volume);
    }
}
