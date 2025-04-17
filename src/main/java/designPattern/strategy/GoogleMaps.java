package designPattern.strategy;

public class GoogleMaps {
    public void findPath(String from, String to, Mode mode) {
//       if(mode == "Bike"){
//            ...
//       }else if(mode == "Car"){
//          ...
//       }
       //Above if-else condition violates SRP and OCP
       PathCalculatorStrategy pathCalculatorStrategy = PathCalculatorFactory.getPathCalculatorByMode(mode);
       pathCalculatorStrategy.findPath(from, to);
    }

}
