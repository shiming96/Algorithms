
public class Main {

    public static void main(String[] args) {
        Integer[] arr1 = SortTestHelper.generateRandomArray(100000, 1, 1000);
        Integer[] arr2 = SortTestHelper.generateRandomArray(100000, 1, 1000);
        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("MergeSort", arr2);
    }
}
