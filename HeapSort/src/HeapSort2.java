public class HeapSort2 {

    public HeapSort2() {
    }

    public static void sort(Comparable[] arr) {

        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    // 测试 HeapSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("HeapSort2", arr);

    }
}
