package pattern.bridge;

public class ConcreteImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA operation.");
    }
}
