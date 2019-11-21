package pattern.bridge;

public class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("RefineAbstraction operation.");
        implementor.operation();
    }
}
