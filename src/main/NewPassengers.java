import java.util.ArrayList;

public class NewPassengers {
    public void PassengerAdd() {
        Lift lift = new Lift("Жемчужина", 340);
        PassengerInit passenger1 = new PassengerInit(87, 5);
        PassengerInit passenger2 = new PassengerInit(58, 9);
        PassengerInit passenger3 = new PassengerInit(112, 3);
        PassengerInit passenger4 = new PassengerInit(25, 7);
        ArrayList<Integer> totalWeight = new ArrayList<>();
        ArrayList<Integer> requiredFloor = new ArrayList<>();
        totalWeight.add(passenger1.getWeight());
        totalWeight.add(passenger2.getWeight());
        totalWeight.add(passenger3.getWeight());
        totalWeight.add(passenger4.getWeight());
        requiredFloor.add(passenger1.getFloor());
        requiredFloor.add(passenger2.getFloor());
        requiredFloor.add(passenger3.getFloor());
        requiredFloor.add(passenger4.getFloor());
        try {
            lift.liftInit(totalWeight, requiredFloor);
        } catch (InterruptedException e) {
            System.out.println("Лифт сломан, придётся идти пешком");
        }
    }
}
