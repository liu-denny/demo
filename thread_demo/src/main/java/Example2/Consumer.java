package Example2;

/**
 * @author yudong
 * @create 2019-11-07 19:14
 */
public class Consumer implements Runnable {
    private Product product;


    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println("开始消费");
        while (true){
            try {
                Thread.sleep((int)(Math.random() * 10) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.getProduct();
        }
    }


}
