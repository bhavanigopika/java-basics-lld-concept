package scalerLambdas.Maths;

public class Main {
    public static void main(String[] args) {
        //No need to create addition class...Earlier we have to create addition class explicitly
        MathematicalOperation addition = (Integer o1, Integer o2) -> {
            return o1 + o2;
        };

        MathematicalOperation subtraction = (o1, o2) -> {
            return o1 - o2;
        };


    }
}
