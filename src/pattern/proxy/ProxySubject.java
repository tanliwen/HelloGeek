package pattern.proxy;

public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        callPre();
        subject.request();
        callAfter();
    }

    private void callAfter() {
        System.out.println("ProxySubject callAfter");
    }

    private void callPre() {
        System.out.println("ProxySubject callPre");
    }
}
