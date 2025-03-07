public class RedLightState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight trafficLight) throws InterruptedException {
        System.out.println("🔴 Red Light - STOP ---- "+ trafficLight.getRoadName());
        Thread.sleep(trafficLight.getRedLightDuration() * 1000L);
        // change the state to green after a specific duration
        trafficLight.setState(new GreenLightState());
    }
}
