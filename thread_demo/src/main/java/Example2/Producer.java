package Example2;

/**
 * @author yudong
 * @create 2019-11-07 19:14
 */
public class Producer implements Runnable{

    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品.");
        while(true){
            try{
                Thread.sleep((int)(Math.random() * 10) * 100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            product.addProduct();
        }
    }
}
