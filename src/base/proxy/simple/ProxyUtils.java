package base.proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUtils implements InvocationHandler {

    private Object target;


    public void setTarget(Object target){
        this.target = target;
    }

    public Object getTarget(){
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do before " + proxy.getClass().getSimpleName());
        Object result = method.invoke(target, args);
        System.out.println("do after" + proxy.getClass().getSimpleName());
        return result;
    }
}
