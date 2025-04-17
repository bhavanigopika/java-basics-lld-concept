package designPattern.strategy;

public class WalkPathCalculatorStrategy implements PathCalculatorStrategy {
    @Override
    public void findPath(String from, String to) {
        System.out.println("Walk Path calculator strategy");
    }
}
