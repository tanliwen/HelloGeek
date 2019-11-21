package pattern.decorator;

public class ConcreteComponent implements Component {

    public ConcreteComponent() {
        System.out.println("ConcreteComponent create.");
    }

    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation.");
    }
}
