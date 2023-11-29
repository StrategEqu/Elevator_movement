import java.util.*;

public class Lift implements LiftMetod {
    private int weight;
    private String model;
    private int currentFloorLift = 1;

    public int getCurrentFloorLift() {
        return currentFloorLift;
    }

    public Lift(int weight) {
        this.weight = weight;
    }

    public Lift(String model, int weight) {
        this.weight = weight;
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void liftDown(int floor) throws InterruptedException {
        for (int i = currentFloorLift; ; i--) {
            if (i > floor) {
                System.out.println(i);
                Thread.sleep(1000);
            } else if (i == floor) {
                Thread.sleep(1000);
                System.out.println(floor + " этаж. Лифт приехал");
                Thread.sleep(1500);
                System.out.println("Двери открываются");
                Thread.sleep(5000);
                System.out.println("Двери закрываются");
                Thread.sleep(1500);
                this.currentFloorLift = floor;
                break;
            }
        }
    }

    @Override
    public void liftUp(int floor) throws InterruptedException {
        for (int i = currentFloorLift; i <= floor; i++) {
            if (i < floor) {
                System.out.println(i);
                Thread.sleep(1000);
            } else if (i == floor) {
                Thread.sleep(1000);
                System.out.println(floor + " этаж. Лифт приехал");
                Thread.sleep(1500);
                System.out.println("Двери открываются");
                Thread.sleep(5000);
                System.out.println("Двери закрываются");
                Thread.sleep(1500);
                this.currentFloorLift = floor;
                break;
            }
        }
    }

    @Override
    public void startingFloor(int floor) throws InterruptedException {
        for (int i = floor; ; i--) {
            if (i > 1) {
                System.out.println(i);
                Thread.sleep(1000);
            } else if (i == 1) {
                Thread.sleep(1000);
                System.out.println(i);
                Thread.sleep(1000);
                System.out.println("Лифт на первом этаже");
                break;
            }
        }
    }

    @Override
    public void moveLift(ArrayList<Integer> requiredFloor) throws InterruptedException {
        int floor;
        for (int checkFloor : requiredFloor) {
            floor = checkFloor;
            if (currentFloorLift < floor) {
                liftUp(floor);
            } else if (currentFloorLift > floor) {
                liftDown(floor);
            } else if (currentFloorLift == floor) {
                System.out.println("Лифт на " + floor + " этаже");
            }
        }
    }

    @Override
    public void liftInit(ArrayList<Integer> array, ArrayList<Integer> requiredFloor) throws InterruptedException {
        int sum = 0;
        System.out.println("Проверка грузоподъемности...");
        Thread.sleep(2000);
        for (int ar : array) {
            sum = sum + ar;
        }
        if (this.weight > sum) {
            System.out.println("Двери закрываются");
            Thread.sleep(1000);
//                Collections.sort(requiredFloor);
            moveLift(requiredFloor);
        } else {
            System.out.println("Лифт перегружен");
        }
        System.out.println("Проверяем наличие людей в кабине лифта...");
        Thread.sleep(2000);
        if (sum > 15 && currentFloorLift != 1) {
            System.out.println("В лифте нет людей, возвращаемся на 1 этаж");
            Thread.sleep(1000);
            startingFloor(currentFloorLift);
        }
        Thread.sleep(1000);
    }
}
