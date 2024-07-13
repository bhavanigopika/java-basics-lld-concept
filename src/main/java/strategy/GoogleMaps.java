package strategy;

public class GoogleMaps {
    public void getPath(String from, String to, String mode){
        //PathCalculatorStrategy is interface
        PathCalculatorStrategy pathCalculatorStrategy = PathCalculatorFactory.getPathCalculatorForMode(mode);
        pathCalculatorStrategy.findPath(from, to);
    }
}
