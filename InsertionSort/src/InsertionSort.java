public class InsertionSort {

    public InsertionSort() {
    }

    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置
            Comparable e = arr[i];
            int j;  //j保存元素应该插入的位置
            for(j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {

        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
