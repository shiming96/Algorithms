import java.util.Arrays;

public class MergeSortBU {
    public MergeSortBU() {
    }
    /**
     * 自底向上
     */

    public static void sort(Comparable[] arr, int n) {

        //第一重循环决定步长size
        for(int sz = 1; sz <= n; sz += sz)
            //第二重循环进行归并
            for(int i = 0; i + sz < n; i += sz + sz)
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n-1));
    }
    //将arr[l...mid]和arr[mid+1......r]两部分归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = new Comparable[r-l+1];

        for(int i = l; i <= r; i++){
            aux[i-l] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        for(int k = l; k <= r; k++) {

            if(i > mid) {
                arr[k] = aux[j-l];
                j++;
            }
            else if( j > r) {
                arr[k] = aux[i-l];
                i++;
            }
            else if(aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l];
                i++;
            }
            else {
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

}
