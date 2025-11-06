package src;

public class QuickSort {
    private static long steps;

    public static SortResult sort(int[] arr) {
        steps = 0;
        int[] data = arr.clone();
        long start = System.nanoTime();
        quickSort(data, 0, data.length - 1);
        long end = System.nanoTime();
        double timeTaken = (end - start) / 1_000_000.0;
        return new SortResult("Quick Sort", data, steps, timeTaken);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}