package parkingLot.repositories;

import parkingLot.models.Gate;
import parkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    //private Map<Long, Vehicle> gateMap = new HashMap<>();

    public Optional<Vehicle> findVehicleByNumber(String vehicleNo) {

       /* if (gateMap.containsKey(vehicleNo)) {
            return Optional.of(gateMap.get(vehicleNo));//wrap it using Optional
        }*/
        return Optional.empty();
    }

    public void save() {

    }
}
