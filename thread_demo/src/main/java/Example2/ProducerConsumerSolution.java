package Example2;

/**
 * 生产者——消费者
 * @author yudong
 * @create 2019-11-07 19:22
 */
public class ProducerConsumerSolution {


    public static void main(String[] args) {
        Product product = new Product();
        Thread producer = new Thread(new Producer(product));
        Thread consumer = new Thread(new Consumer(product));
        producer.start();
        consumer.start();
    }
}
