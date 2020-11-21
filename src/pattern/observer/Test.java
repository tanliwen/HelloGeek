package pattern.observer;

public class Test {
    EventBus eventBus = new EventBus();

    void init(){
        eventBus.register(this);
    }
    @Subscribe
    void loginSucceed(Long uid){
        System.out.println("I am loginSucceed");
    }

    void release(){

    }

    public static void main(String[] args) {
        Test test = new Test();

        test.init();
        test.eventBus.post(123L);
    }
}
