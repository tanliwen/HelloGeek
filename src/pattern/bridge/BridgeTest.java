package pattern.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(implementor);
        abs.operation();
    }
}