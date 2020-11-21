package base.proxy.simple;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        Object proxyObject = new UserServiceImpl();

        ProxyUtils proxyUtils = new ProxyUtils();
        proxyUtils.setTarget(proxyObject);


        IUserService userService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                UserServiceImpl.class.getInterfaces(), proxyUtils);

        userService.login("tlw", "123456");
        System.out.println("\n");

        userService.logout("1");
    }
}
