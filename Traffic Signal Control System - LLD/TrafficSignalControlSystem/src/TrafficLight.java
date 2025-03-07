public class TrafficLight implements Runnable{
    private TrafficLightState currentState;
    private final int redLightDuration, yellowLightDuration, greenLightDuration;
    private volatile boolean isEmergencyActivated = false; // 🚨 Emergency Mode
    private final String roadName;

    public TrafficLight(String roadName, int redLightDuration, int yellowLightDuration, int greenLightDuration) {
        this.roadName = roadName;
        this.redLightDuration = redLightDuration;
        this.yellowLightDuration = yellowLightDuration;
        this.greenLightDuration = greenLightDuration;
        this.currentState = new RedLightState();
    }

    public void setState(TrafficLightState newState){
        this.currentState = newState;
    }

    public int getRedLightDuration(){
        return redLightDuration;
    }

    public int getGreenLightDuration(){
        return greenLightDuration;
    }

    public int getYellowLightDuration(){
        return yellowLightDuration;
    }

    public String getRoadName(){
        return roadName;
    }

    public void activateEmergencyMode(){
        isEmergencyActivated = true;
        // change the state to GREEN for 10s
        setState(new GreenLightState());
    }

    public void deactivateEmergencyMode(){
        isEmergencyActivated = false;
        setState(new RedLightState());
    }

    @Override
    public void run() {
        while(true){
            if(!isEmergencyActivated){
                try {
                    currentState.changeState(this);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println("🚨 Emergency Mode: " + roadName + " gets priority GREEN light!");
                activateEmergencyMode();
                try {
                    Thread.sleep(5000); // Hold green light for 10 sec (emergency clearance)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                deactivateEmergencyMode();
            }
        }
    }
}
