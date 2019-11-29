import java.util.Date;

/**
 * 冒泡排序
 * @author yudong
 * @create 2019-11-18 11:23
 */
public class BubbleSort {
    public static void main(String[] args) {
        Long startTime = new Date().getTime();
        int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};
        //置换变量
        int temp;
        //发生置换标识符
//        boolean falg;
        int falg;

        for(int i=0;i<arrays.length-1;i++){
//            falg = false;
            falg = 0;

            for (int j=0;j<arrays.length-i-1;j++){
                if(arrays[j] > arrays[j+1] ){
                    temp = arrays[j+1];
                    arrays[j+1] = arrays[j];
                    arrays[j] = temp;

                    falg = 1;
                }
            }

            if(falg == 0){
                break;
            }
        }

        Long time = new Date().getTime() - startTime;
        System.out.println("time = " + time);

        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
