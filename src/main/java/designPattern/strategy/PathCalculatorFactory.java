package designPattern.strategy;

public class PathCalculatorFactory {
    public static PathCalculatorStrategy getPathCalculatorByMode(Mode mode){
        if(mode.equals(Mode.CAR)){
            return new CarPathCalculatorStrategy();
        }else if(mode.equals(Mode.BIKE)){
            return new BikePathCalculatorStrategy();
        }else if(mode.equals(Mode.WALK)){
            return new WalkPathCalculatorStrategy();
        }else{
            return null;
        }
    }
}
