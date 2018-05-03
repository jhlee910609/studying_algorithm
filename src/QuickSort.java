public class QuickSort {

    int i = 0;

    public QuickSort() {
    }

    public int partition(int a[], int begin, int end) {
        int pivot, temp, L, R;

        L = begin;
        R = end;
        pivot = (begin + end) / 2;
        System.out.printf("\n[퀵정렬 %d 단계 : pivot = %d]\n", ++i, a[pivot]);
        while (L < R) {
            if (a[L] <= a[pivot] && L <= R) L++;
            if (a[R] > a[pivot] && L <= R) R--;

            if (L < R) {
                temp = a[L];
                a[L] = a[R];
                a[R] = temp;

                if (L == pivot) {
                    for (int j = 0; j < a.length; j++) {
                        System.out.print(a[j] + "   ");
                    }
                    return R;
                }
            }
        }

        temp = a[pivot];
        a[pivot] = a[R];
        a[R] = temp;

        for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + "   ");
        }
        return R;

    }

    public void doSort(int[] a, int begin, int end) {
        if (begin < end) {
            int p = partition(a, begin, end);
            doSort(a, begin, p - 1);
            doSort(a, p + 1, end);
        }
    }


}
