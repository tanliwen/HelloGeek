package base.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    /*持有的真实对象*/
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /*通过Proxy获得动态代理对象*/
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    /*通过动态代理对象方法进行增强*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        doBefore();
        Object result = method.invoke(target, args);
        doEnd();
        return result;
    }

    private void doBefore() {
        System.out.println("doBefore");
    }

    private void doEnd() {
        System.out.println("doEnd");
    }
}
