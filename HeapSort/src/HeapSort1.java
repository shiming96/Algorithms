public class HeapSort1 {

    public HeapSort1() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort1", arr);

    }

}
