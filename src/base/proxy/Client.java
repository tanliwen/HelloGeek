package base.proxy;



import base.proxy.dynamic.InvocationHandlerImpl;
import base.proxy.dynamic.ProxyUtils;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        InvocationHandlerImpl handlerImpl = new InvocationHandlerImpl();

        ILogin loginImpl = new LoginImpl();
        handlerImpl.setTarget(loginImpl);

        ILogin loginService = (ILogin)handlerImpl.getProxyInstance();
        loginService.doLogin("tlw", "123");

        ILogout logoutImpl = new LogoutImpl();
        handlerImpl.setTarget(logoutImpl);

        ILogout logoutService = (ILogout) handlerImpl.getProxyInstance();
        logoutService.logout("tlw", "123");

        System.out.println();

        Method[] methods = loginService.getClass().getMethods();
        for(Method method:methods) {
            System.out.println(method.getName());//打印方法名称
        }

        ProxyUtils.generateClassFile(loginImpl.getClass(), loginService.getClass().getSimpleName());
        ProxyUtils.generateClassFile(logoutImpl.getClass(), logoutService.getClass().getSimpleName());


    }

}
