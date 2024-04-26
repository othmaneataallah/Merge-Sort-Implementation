public class SingleThreadedMergeSorter extends Thread {
    public static int[] mergeSort(int[] unsortedArray) {
        if (unsortedArray.length <= 1) {
            return unsortedArray;
        }
        int middle = unsortedArray.length / 2;
        int[] left = new int[middle];
        int[] right = new int[unsortedArray.length - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = unsortedArray[i];
        }
        for (int i = middle; i < unsortedArray.length; i++) {
            right[i - middle] = unsortedArray[i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                mergedArray[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                mergedArray[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
        while (leftIndex < left.length) {
            mergedArray[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }
        while (rightIndex < right.length) {
            mergedArray[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
        return mergedArray;
    }
}