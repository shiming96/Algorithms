public class SelectionSort {

    public SelectionSort() {

    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);

        }
    }

    private static void swap(Object[] arr, int i, int j) {

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
