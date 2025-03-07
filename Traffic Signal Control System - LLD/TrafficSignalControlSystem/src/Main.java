//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
            System.out.println("🚦Traffic Control System 🚸");

            Road road1 = new Road(1, "Main Road");
            Road road2 = new Road(2, "Downtown");
            Road road3 = new Road(3, "N.H 8");
            Road road4 = new Road(4, "Grain Market Road");

            TrafficLight light1 = new TrafficLight(road1.getRoadName(), 10, 10, 3);
            TrafficLight light2 = new TrafficLight(road2.getRoadName(), 10, 10, 3);
            TrafficLight light3 = new TrafficLight(road3.getRoadName(), 10, 10, 3);
            TrafficLight light4 = new TrafficLight(road4.getRoadName(), 10, 10, 3);

            // Assign the traffic lights to the roads
            road1.setTrafficLight(light1);
            road2.setTrafficLight(light2);
            road3.setTrafficLight(light3);
            road4.setTrafficLight(light4);

            // Run each traffic light in a separate thread
            Thread t1 = new Thread(light1);
            Thread t2 = new Thread(light2);
            Thread t3 = new Thread(light3);
            Thread t4 = new Thread(light4);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            // Simulate the emergency condition
            Thread.sleep(1000);
            light2.activateEmergencyMode();
    }
}