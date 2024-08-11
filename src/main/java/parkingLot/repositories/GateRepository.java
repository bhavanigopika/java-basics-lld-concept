package parkingLot.repositories;

import parkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    //we have to use the in-memory database...so we have to store the data in map
    private Map<Long, Gate> gateMap = new HashMap<>();
    //find out by id
    public Optional<Gate> findGateById(Long id){
        //search gate id in gateMap...if it is actualDB(MySQL), then we have to try using searchQuery as "select id from Gate where gate_id = 3;"
        //but here we are using the Map
        if(gateMap.containsKey(id)){
            return Optional.of(gateMap.get(id));//wrap it using Optional
        }
        //if gate id is not present
        return Optional.empty();

    }

}
