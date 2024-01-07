import java.util.ArrayList;

public interface LiftMetod {
    void liftDown(int floor) throws InterruptedException;

    void liftUp(int floor) throws InterruptedException;

    void liftInit(ArrayList<Integer> array, ArrayList<Integer> array2) throws InterruptedException;

    void moveLift(ArrayList<Integer> array2) throws InterruptedException;

    void startingFloor(int floor) throws InterruptedException;
}
// 