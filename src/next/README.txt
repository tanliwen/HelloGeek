wait 和 sleep区别 https://www.jianshu.com/p/25e959037eed

1.wait只能在同步（synchronize）环境中被调用，而sleep不需要

2. 进入wait状态的线程能够被notify和notifyAll线程唤醒，但是进入sleeping状态的线程不能被notify方法唤醒。

3.wait通常有条件地执行，线程会一直处于wait状态，直到某个条件变为真。但是sleep仅仅让你的线程进入睡眠状态。

4.wait方法在进入wait状态的时候会释放对象的锁，但是sleep方法不会。

5.wait方法是针对一个被同步代码块加锁的对象，而sleep是针对一个线程。更详细的讲解可以参考《Java核心技术卷1》，里面介绍了如何使用wait和notify方法。

Java线程池实现原理及其在美团业务中的实践

https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html