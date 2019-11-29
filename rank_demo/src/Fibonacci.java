import java.util.Scanner;

/**
 * 斐波那契数列
 * 菲波那切数列长这个样子：{1 1 2 3 5 8 13 21 34 55..... n }
 * @author yudong
 * @create 2019-11-18 12:00
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else {
            return (fibonacci(n-1) + fibonacci(n-2));
        }
    }

    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(fibonacci(n));
        }

    }
}
