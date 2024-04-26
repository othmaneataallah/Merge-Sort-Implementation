public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = { 5, 3, 8, 6, 2, 7, 1, 4 };
        int[] sortedArraySingleThread = SingleThreadedMergeSorter.mergeSort(unsortedArray);
        System.out.println("Single Threaded Merge Sort:");
        for (int i = 0; i < sortedArraySingleThread.length; i++) {
            System.out.print(sortedArraySingleThread[i] + " ");
        }
    }
}