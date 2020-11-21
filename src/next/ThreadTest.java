package next;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false, false);

        for (ThreadInfo info: threadInfos) {
            System.out.println("[thread id = " + info.getThreadId() + ", name = "  + info.getThreadName() + "]");
        }
    }
}
