package core36.day06;

import java.lang.reflect.Proxy;

public class AOPTest {
    public static void main(String[] args) {
        Hello helloImpl = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(helloImpl);

        Class[] interfaces = HelloImpl.class.getInterfaces();
        for (Class interfaceItem: interfaces) {
            System.out.println("interface: " + interfaceItem.getSimpleName());
        }
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), interfaces, handler);
        proxyHello.sayHello();

        System.out.println("----------------------");
        IFly proxyFly = (IFly) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), interfaces, handler);
        proxyFly.fly();
    }
}
