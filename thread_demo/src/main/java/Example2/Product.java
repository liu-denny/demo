package Example2;

/**
 * @author yudong
 * @create 2019-11-07 19:50
 */
public class Product {
    //最大产品数
    private static final int MAX_PRODUCT = 20;

    //最小产品数
    private static final int MIN_PRODUCT = 0;

    //默认为0个产品
    private int product = 0;

    public synchronized void addProduct(){
        if(this.product >= MAX_PRODUCT){
            try{
                wait();
                System.out.println("产品已满");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return;
        }
        this.product++;
        System.out.println("生产者生产第" + this.product + "个产品");
        notifyAll();
    }

    public synchronized void getProduct(){
        if(this.product <= MIN_PRODUCT){
            try {
                wait();
                System.out.println("无货");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return;
        }
        System.out.println("消费第 " + this.product + "个产品");
//        this.product--;
        notifyAll();
    }
}
