package core36.day06;

public class HelloImpl implements Hello, IFly{
    @Override
    public void sayHello() {
        System.out.println("hello impl");
    }

    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
