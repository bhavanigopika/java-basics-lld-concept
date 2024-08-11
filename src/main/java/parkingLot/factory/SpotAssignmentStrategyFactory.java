package parkingLot.factory;

import parkingLot.models.SpotAssignmentStrategyType;
import parkingLot.strategies.BalancedSpotAssignmentStrategy;
import parkingLot.strategies.CheapestSpotAssignmentStrategy;
import parkingLot.strategies.NearestSpotAssignmentStrategy;
import parkingLot.strategies.OptimalSpotAssignmentStrategy;
import parkingLot.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType){
        if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.BALANCED)) {
            return new BalancedSpotAssignmentStrategy();
        }else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        }else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.OPTIMAL)){
            return new OptimalSpotAssignmentStrategy();
        }else{
            return null;
        }
    }
}
