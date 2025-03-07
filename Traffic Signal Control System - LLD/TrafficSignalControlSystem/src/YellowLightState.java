public class YellowLightState implements TrafficLightState{
    @Override
    public void changeState(TrafficLight trafficLight) throws InterruptedException {
        System.out.println("🟡 Yellow Light - SLOW DOWN ---- "+ trafficLight.getRoadName());
        Thread.sleep(trafficLight.getYellowLightDuration() * 1000L);
        // Change the state to Red
        trafficLight.setState(new RedLightState());
    }
}
