import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Versions {

    public void treeSetExample() {
        // Create a TreeSet (automatically sorts elements)
        TreeSet<String> names = new TreeSet<>();

        // Add elements (order of adding doesn't affect sorting)
        names.add("Charlie");
        names.add("Bob");
        names.add("Alice");

        // Print elements (will be in alphabetical order)
        System.out.println("Names in the TreeSet:");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public void java6FeaturesExample() {
        // 1. String Builder (StringBuilder class for mutable strings)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        System.out.println("StringBuilder: " + sb.toString());

        // 2. NavigableSet and NavigableMap (introduced in Java 5)
        // These were new collection interfaces in Java 5, but they were
        // further enhanced in Java 6.
        // you can add implementations like TreeSet)
        treeSetExample();
        
        // 3. Scanner class (for parsing text input)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        // 4. System.nanoTime() (for more accurate timing)
        long startTime = System.nanoTime();
        // ... some code to time ...
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        // 5. Compiler API (for programmatically compiling Java code)
        // (Example omitted for brevity - it's a more advanced feature)

        // 6. JDBC 4.0 support (for database connectivity)
        // (Example omitted - requires database setup and drivers)

        // 7. Java API for XML Processing (JAXP) 1.4
        // (Example omitted - involves XML parsing and manipulation)

        // 8. Java Architecture for XML Binding (JAXB) 2.0
        // (Example omitted - involves mapping XML to Java objects)
    }

    public void iterationExamples() {
        // Java 6 and earlier (using Iterator)
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Java 6 Iteration:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Java 8 (using forEach with Lambda)
        System.out.println("\nJava 8 Iteration:");
        names.forEach(name -> System.out.println(name));

        // Java 11 (using forEach with var in Lambda)
        System.out.println("\nJava 11 Iteration:");
        names.forEach((var name) -> System.out.println(name)); 

        // Java 17 (Enhanced for loop with var - no significant change from Java 8)
        System.out.println("\nJava 17 Iteration:");
        for (var name : names) {
            System.out.println(name);
        }
    }

    //create an example of Generics in Java:
    public void genericsExample() {
        // Using generics with List
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println("String List: " + stringList);

        // Using generics with a custom class
        Box<Integer> intBox = new Box<>(10);
        intBox.setItem(20);
        System.out.println("Integer Box Value: " + intBox.getItem());

        Box<String> stringBox = new Box<>("Generics");
        System.out.println("String Box Value: " + stringBox.getItem());

        // Demonstrating type safety
        // This would cause a compile-time error:
        // Box<Integer> invalidBox = new Box<>("This won't work"); 
    }

    //create an example of all java 8 features:
    public void java8FeaturesExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Lambda expressions
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Functional interfaces
        Consumer<Integer> printSquare = n -> System.out.print(n * n + " ");
        numbers.forEach(printSquare);
        System.out.println();

        // Method references
        numbers.forEach(System.out::println);

        // Stream API
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Default methods in interfaces
        MyInterface myInterface = () -> System.out.println("Default method called");
        myInterface.doSomething();

        // Optional class
        String str = null;
        String result = Optional.ofNullable(str).orElse("Default value");
        System.out.println(result);
    }

    //create an example of all java 11 features:
    public void java11FeaturesExample() throws IOException, InterruptedException {
        // String API enhancements
        String multilineString = "This is a \n multiline string.";
        System.out.println(multilineString.isBlank()); // false
        System.out.println(multilineString.lines().collect(Collectors.joining())); // This is a multiline string.

        // Local-variable syntax for lambda parameters
        List<String> names = List.of("John", "Jane", "Doe");
        names.forEach((var name) -> System.out.println("Hello, " + name + "!"));

        // HTTP/2 Client API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        if(response.body().length()>1)System.out.println("OK");

        // Not covered in this example:
        // - New String methods: isBlank(), lines(), strip(), stripLeading(), stripTrailing(), repeat()
        // - Files.readString() and Files.writeString() for reading and writing strings to files
        // - Optional.isEmpty()
        // - The Epsilon garbage collector
        // - New cryptographic algorithms
        // - Flight Recorder
    }

    //create an example of all java 17 features:
    public void java17FeaturesExample() throws IOException, InterruptedException {
        // Sealed classes and interfaces
        Shape shape = new Circle(5);
        System.out.println("Area of shape: " + shape.calculateArea());

        // Pattern matching in switch expressions
        String day = "MONDAY";
        int numLetters = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            default -> day.length();
        };
        System.out.println("Number of letters in " + day + ": " + numLetters);

        // Text blocks
        String html = """
              <html>
                  <body>
                      <p>Hello, world!</p>
                  </body>
              </html>
              """;
        System.out.println(html);

        // Records
        Point point = new Point(10, 20);
        System.out.println("Point: " + point);

        // Not covered in this example:
        // - Enhanced pseudo-random number generators
        // - New macOS rendering pipeline
        // - Deprecation and removal of features
    }
}

interface MyInterface {
    void doSomething();

    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}

sealed interface Shape permits Circle, Square {
    double calculateArea();
}

record Point(int x, int y) {}

// Generic class example
class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

final class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}


    

