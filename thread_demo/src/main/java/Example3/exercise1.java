package Example3;

/**
 * 经典面试题——两个线程交替打印奇数和偶数
 * @author yudong
 * @create 2019-11-08 12:24
 */
public class exercise1 {
    private static volatile int i = 1;

    public static void main(String[] args) {
        final Object obj = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    for(;i<100;){
                        System.out.println(Thread.currentThread().getName()+":"+i++);
                        try{
                            obj.notifyAll();//唤醒
                            obj.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    obj.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(runnable, "打印偶数的线程 ");
        Thread t2 = new Thread(runnable, "打印奇数的线程 ");
        t2.start();
        t1.start();
    }

}
