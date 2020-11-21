package pattern.single;

public class SingleInstance1 {
    private static volatile SingleInstance1 instance;

    private SingleInstance1() {

    }

    public static SingleInstance1 getInstance2() {
        if (instance == null) {
            //B线程等待
            synchronized (SingleInstance1.class) { //A线程进入                                      //B线程进入
                instance = new SingleInstance1();  //A线程创建                                     //B线程创建
            }
            //A创建完毕
        }
        return instance;
    }

    public static SingleInstance1 getInstance() {
        if (instance == null) {
            synchronized (SingleInstance1.class) {
                if (instance == null) {  //A线程 结束创建后， B线程进入这里 A已经创建了， 非空，就不会二次创建了
                    instance = new SingleInstance1();
                }
            }
        }
        return instance;
    }

}
