package pattern.decorator;

public class Decorator implements Component {

    private Component compoent;


    public Decorator(Component compoent) {
        this.compoent = compoent;
    }

    @Override
    public void operation() {
        compoent.operation();
    }
}
