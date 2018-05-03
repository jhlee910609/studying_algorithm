import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
//        new BubbleSort(a).doSort();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +", ");
        }
        Arrays.sort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +", ");
        }
//        new QuickSort().doSort(a, 0, 7);

    }
}
