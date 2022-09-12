// Реализовать алгоритм пирамидальной сортировки (HeapSort)

package HomeWork3;

public class HomeWork32 {
    public static void main(String[] args) {
        int[] mas = new int[] {1, 50, 20, 6, 8, 10, 59, 11};
        int masLen = mas.length;
        int i = masLen / 2 - 1;
        while (i >= 0) {
            heapSort(mas, i--, masLen);
        }

        for (int j = masLen - 1; j >= 0; j--) {
            swapVal(mas, 0, j);
            heapSort(mas, 0, j);
        }
        printArr(mas);
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    static void swapVal(int[] arr, int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    static void heapSort(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int res = i;
        if (left < size && arr[left] > arr[i]) {
            res = left;
        }

        if (right < size && arr[right] > arr[res]) {
            res = right;
        }

        if (res != i) {
            swapVal(arr, i, res);
            heapSort(arr, res, size);
        }
    }
}
