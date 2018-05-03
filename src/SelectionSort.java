public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {1, 34, 756, 8, 9, 12353, 7, 76, 57};
        doSort(a);
    }


    public static void doSort(int[] a) {
        int i, j, minIndex;

        for (i = 0; i < a.length - 1; i++) {
            System.out.println(i + "번쨰 === ");
            minIndex = i;

            for (j = i + 1; j < a.length; j++) {

                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
    }

    // swapping min or max value
    static void swap(int[] a, int min, int i) {
        int temp = a[min];
        a[min] = a[i];
        a[i] = temp;
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + ", ");
        }
    }
}
