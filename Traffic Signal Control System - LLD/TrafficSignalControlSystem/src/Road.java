public class Road {
    private int id;
    private String roadName;
    private TrafficLight trafficLight;

    public Road(int id, String roadName) {
        this.id = id;
        this.roadName = roadName;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public int getId() {
        return id;
    }

    public String getRoadName(){
        return roadName;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
}
