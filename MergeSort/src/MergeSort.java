public class MergeSort {

    public MergeSort() {
    }

    /**
     * 自顶向下
     */

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);

    }

    //递归使用归并排序, 对arr[l.....r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

//        if (l >= r)
//            return;
        //数量小到一定程度时,使用插入排序
        if( r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
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
