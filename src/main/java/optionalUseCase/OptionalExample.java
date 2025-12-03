package optionalUseCase;

import java.util.Optional;

public class OptionalExample {
    public Optional<String> findByName(String name) {
        // Simulate fetching data from a database
        if ("John".equals(name)) {
            return Optional.of("John Doe");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        OptionalExample example = new OptionalExample();

        Optional<String> result1 = example.findByName("John");
        if (result1.isPresent()) {
            System.out.println("Found: " + result1.get());
        } else {
            System.out.println("Not found");
        }

        Optional<String> result2 = example.findByName("Jane");
        result2.ifPresentOrElse(
                value -> System.out.println("Found: " + value),
                () -> System.out.println("Not found")
        );
    }
}
/*public class OptionalExample {
    public String findByName(String name) {
        // Simulate fetching data from a database
        if ("John".equals(name)) {
            return "John Doe";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        OptionalExample example = new OptionalExample();

        String result1 = example.findByName("John");
        if (result1 != null) {
            System.out.println("Found: " + result1.toString() );
        } else {
            System.out.println("Not found" );
        }

        String result2 = example.findByName("Jane");
        if (result2 != null) {
            assert result1 != null;
            System.out.println("Found: " + result1.toString());
        } else {
            System.out.println("Not found");
        }
    }
}*/


