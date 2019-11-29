/**
 * 快速排序
 * @author yudong
 * @create 2019-11-18 14:11
 */
public class QuickSort {

    /**
     * @param arr 排序数组
     * @param L 数组第一个元素
     * @param R 数组最后一个元素
     */
    public static void quickSort(int[] arr,int L,int R){
        int i = L;
        int j = R;

        int k = arr[(L+R)/2];

        while(i<=j){
            while (k>arr[i]) {i++;}
            while (k<arr[j]) {j--;}

            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(i<R){
            quickSort(arr,i,R);
        }

        if(j>L){
            quickSort(arr,L,j);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
