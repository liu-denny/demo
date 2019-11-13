package Example1;

/** 10个线程顺序打印0-9
 * @author yudong
 * @create 2019-11-07 14:31
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread[] threadPrinters = new MyThread[10];
        //初始化线程并且启动，
        //为了证明线程琐的作用，线程从后面开始启动
        for (int i = LockObject.endNum-1; i >= 0; i--) {
            threadPrinters[i] = new MyThread(i);
            threadPrinters[i].start();
        }
    }
}
