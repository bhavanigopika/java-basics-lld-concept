package strategy;

public class Client {

    public static void main(String[] args) {

        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.getPath("Vellore", "Kanchipuram", "Car");
        googleMaps.getPath("Hyderabad", "Chennai", "Bike");
        googleMaps.getPath("Bangalore", "Mysore", "Walk");

    }
}
