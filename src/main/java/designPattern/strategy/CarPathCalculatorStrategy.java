package designPattern.strategy;

public class CarPathCalculatorStrategy implements PathCalculatorStrategy {
    @Override
    public void findPath(String from, String to) {
        System.out.println("Car Path calculator strategy");
    }
}
