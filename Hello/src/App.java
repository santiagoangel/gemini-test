import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println("Hello, World!");
        Versions versions = new Versions();
        versions.genericsExample();
        versions.java6FeaturesExample();
        versions.java8FeaturesExample();
        versions.java11FeaturesExample();
        versions.java17FeaturesExample();
    }
}
