public class HeapSort {

    public HeapSort() {
    }

    // 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1)/2; i < n; i++) {
            shiftDown(arr, n, i);
        }

        for( int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        } 
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        while( 2*k + 1 < n ) {
            int j = 2*k + 1; // 在此轮循环中,data[k]和data[j]交换位置
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 )
                j ++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if( arr[k].compareTo(arr[j]) >= 0 ) break;
            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort", arr);

        return;
    }
}
