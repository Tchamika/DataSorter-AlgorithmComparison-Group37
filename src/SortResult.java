package src;

public class SortResult {
    String algorithmName;
    int[] sortedData;
    long steps;
    double timeMs;

    public SortResult(String algorithmName, int[] sortedData, long steps, double timeMs) {
        this.algorithmName = algorithmName;
        this.sortedData = sortedData;
        this.steps = steps;
        this.timeMs = timeMs;
    }
}
