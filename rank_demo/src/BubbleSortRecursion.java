/**
 * 冒泡排序——递归实现
 * @author yudong
 * @create 2019-11-18 11:42
 */
public class BubbleSortRecursion {

    public static void recursionSort(int[] arrays,int L,int R){
        int temp;

        if(L == R);

        else {
            for(int i=L;i<R;i++){
                if(arrays[i] > arrays[i+1] ){
                    temp = arrays[i+1];
                    arrays[i+1] = arrays[i];
                    arrays[i] = temp;
                }
            }
            recursionSort(arrays,L,R-1);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 4, 5,7, 10, 9, 6, 8, 1};
        recursionSort(arrays,0,arrays.length-1);

        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
