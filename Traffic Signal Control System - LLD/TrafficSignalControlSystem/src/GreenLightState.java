public class GreenLightState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight trafficLight) throws InterruptedException {
        System.out.println("🟢 Green Light - GO ---- "+ trafficLight.getRoadName());
        Thread.sleep(trafficLight.getGreenLightDuration() * 1000L);
        // Change the state to yellow
        trafficLight.setState(new YellowLightState());
    }
}
