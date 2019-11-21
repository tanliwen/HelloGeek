package pattern.proxy;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(subject);
        proxySubject.request();
    }
}
