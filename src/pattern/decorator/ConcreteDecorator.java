package pattern.decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component compoent) {
        super(compoent);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    private void addedFunction() {
        System.out.println("ConcreteDecorator addedFunction");
    }
}
