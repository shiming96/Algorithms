public class Main {
    public static void main(String[] args) {

        assert 1>2;
        Integer[] arr = SortTestHelper.generateRandomArray(100000, 1, 10000);

        SortTestHelper.testSort("SelectionSort", arr);
    }
}
