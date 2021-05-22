public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator (int minFloor, int maxFloor){
        this.minFloor = this.minFloor + minFloor;
        this.maxFloor = this.maxFloor + maxFloor;
    }
    private int getCurrentFloor() {
        return currentFloor;
    }
    private void moveDown (){
        currentFloor = currentFloor - 1;
    }
    private void moveUp(){
        currentFloor = currentFloor + 1;
    }
    public void move(int floor){
        if (floor < minFloor || floor > maxFloor){
            System.out.println("Неверный номер этажа");
            return;
        }
        if (floor == currentFloor){
            return;
        }
        for (int i = floor; i > currentFloor; moveUp()){
            System.out.println("Этаж " + currentFloor);
        }
        for (int i = floor; i < currentFloor; moveDown()){
            System.out.println("Этаж " + currentFloor);
        }
        System.out.println("Этаж " + currentFloor);
    }
}
