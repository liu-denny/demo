import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yudong
 * @create 2019-11-19 10:27
 */
public class Java8Time {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("localDateTime = " + localDateTime);
        LocalDate date1 = localDateTime.toLocalDate();
        System.out.println("date1: " + date1);
    }
}
