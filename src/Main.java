package src;

import java.util.*;

public class Main {
    private static int[] data = {};
    private static Map<String, SortResult> results = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter numbers separated by spaces: ");
                    try {
                        data = Arrays.stream(sc.nextLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        System.out.println("✅ Data loaded successfully!");
                    } catch (Exception e) {
                        System.out.println("❌ Invalid input! Enter only integers.");
                    }
                    break;

                case "2":
                    System.out.print("Enter dataset size: ");
                    try {
                        int size = Integer.parseInt(sc.nextLine());
                        data = generateRandom(size);
                        System.out.println("✅ Random Data: " + Arrays.toString(data));
                    } catch (Exception e) {
                        System.out.println("❌ Please enter a valid number.");
                    }
                    break;

                case "3":
                    runSort("Bubble Sort", BubbleSort.sort(data));
                    break;

                case "4":
                    runSort("Merge Sort", MergeSort.sort(data));
                    break;

                case "5":
                    runSort("Quick Sort", QuickSort.sort(data));
                    break;

                case "6":
                    displayResults();
                    break;

                case "7":
                    System.out.println("👋 Exiting program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid choice! Please enter 1–7.");
            }
        }
    }

    private static void runSort(String name, SortResult result) {
        if (data.length == 0) {
            System.out.println("❌ No data found! Enter or generate data first.");
            return;
        }
        System.out.println(name + " Output: " + Arrays.toString(result.sortedData));
        System.out.printf("Steps: %d | Time: %.6f ms%n", result.steps, result.timeMs);
        results.put(name, result);
    }

    private static int[] generateRandom(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(100) + 1;
        return arr;
    }

    private static void displayResults() {
        if (results.isEmpty()) {
            System.out.println("❌ No sorting results to compare yet!");
            return;
        }
        System.out.println("\n--- Algorithm Performance Summary ---");
        System.out.printf("%-12s %-15s %-15s%n", "Algorithm", "Steps", "Time (ms)");
        System.out.println("-------------------------------------------");
        for (SortResult r : results.values()) {
            System.out.printf("%-12s %-15d %-15.6f%n", r.algorithmName, r.steps, r.timeMs);
        }
        System.out.println("-------------------------------------------");
    }
}
