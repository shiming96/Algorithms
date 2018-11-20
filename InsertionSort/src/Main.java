public class Main {

    public static void main(String[] args) {
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(10000, 100);
        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(10000, 100);
        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);
    }
}
