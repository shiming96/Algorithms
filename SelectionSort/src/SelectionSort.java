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

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 1, 10000);
        String[] arr1 = {"sm", "ss", "dd", "ff"};
        Student stu1 = new Student("张三", 2);
        Student stu2 = new Student("李四", 88);
        Student stu3 = new Student("王五", 55);
        Student stu4 = new Student("赵六", 33);
        Student[] stu = {stu1, stu2, stu3, stu4};
        SelectionSort.sort(arr);
        SelectionSort.sort(arr1);
        SelectionSort.sort(stu);
        for (Student student : stu) {
            System.out.println(student);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }

}
