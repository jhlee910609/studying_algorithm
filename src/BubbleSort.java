import javax.sound.midi.SysexMessage;

public class BubbleSort {

    int[] a;

    public BubbleSort(int[] a) {
        this.a = a;
    }

    public void doSort() {
        int i, j, temp, size;
        size = a.length;
        for (i = size - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < size; k++) {
            sb.append(a[k]);

            if (k != size - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
