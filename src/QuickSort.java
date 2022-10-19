import java.util.Comparator;
import java.util.Random;

public class QuickSort {
    public static final Random RND = new Random();

    public void sort(Object[] arr, Comparator cmp) {
        qSort(arr, 0, arr.length-1, cmp);
    }

    private void qSort(Object[] arr, int low, int high, Comparator cmp) {
        if (low > high) {
            return;
        }
        int pivot = partition(arr, low, high, cmp);
        qSort(arr, low, pivot - 1, cmp);
        qSort(arr, pivot + 1, high, cmp);
    }

    private int partition(Object[] arr, int low, int high, Comparator cmp) {
        int index = low + RND.nextInt(high - low + 1);
        Object pivot = arr[index];
        swap(arr, index, high);
        for (int i = index = low; i < high; ++i) {
            if (cmp.compare(arr[i], pivot) <= 0) {
                swap(arr, index++, i);
            }
        }
        swap(arr, index, high);
        return index;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

