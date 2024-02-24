import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] data = new int[] { -5, -1, 3, 7, 1 };

        mergeSort(data, 0, data.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(data)); // Print the sorted array using
                                                                      // Arrays.toString(data)
    }

    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1]; // Create a temporary array to hold merged elements

        int i = start, j = mid + 1, k = 0; // Initialize indices for left subarray, right subarray, and temp array

        // Merge elements from left and right subarrays into temp array
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++]; // If element from left subarray is smaller or equal, add it to temp and move
                                       // indices
            } else {
                temp[k++] = data[j++]; // If element from right subarray is smaller, add it to temp and move indices
            }
        }

        // Copy remaining elements from left subarray to temp
        while (i <= mid) {
            temp[k++] = data[i++];
        }

        // Copy remaining elements from right subarray to temp
        while (j <= end) {
            temp[k++] = data[j++];
        }

        // Copy elements from temp back to data
        for (i = start; i <= end; i++) {
            data[i] = temp[i - start]; // Copy elements from temp to data starting from index 'start'
        }

    }
}
