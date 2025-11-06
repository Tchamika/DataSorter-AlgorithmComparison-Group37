package src;

public class BubbleSort {
    public static SortResult sort(int[] arr) {
        int[] data = arr.clone();
        int n = data.length;
        long steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        double timeTaken = (end - start) / 1_000_000.0; // milliseconds
        return new SortResult("Bubble Sort", data, steps, timeTaken);
    }
}

