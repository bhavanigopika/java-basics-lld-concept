package designPattern.strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.findPath("Vellore", "Katpadi", Mode.BIKE);
        googleMaps.findPath("Chennai", "Kanchipuram", Mode.CAR);
        googleMaps.findPath("KV Nagar", "SP Nagar", Mode.WALK);
    }
}
