package Example1;

/**
 * @author yudong
 * @create 2019-11-07 14:24
 */
public class MyThread extends Thread {
    static LockObject object= new LockObject();

    private int printNum;

    public MyThread(int printNum){
        this.printNum = printNum;
    }

    @Override
    public void run() {
        synchronized (object) {
            while (LockObject.orderNum < LockObject.endNum) {
                if (LockObject.orderNum == printNum) {
                    System.out.print(printNum);
                    LockObject.orderNum++;
                    if (printNum == 10) {
                        System.out.println("打印结束");
                    }
                    //唤醒所有线程
                    object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        System.out.println("线程" + printNum + "被打断了");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
