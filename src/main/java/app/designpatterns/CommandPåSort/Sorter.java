package app.designpatterns.CommandPåSort;

import java.util.Arrays;

public class Sorter {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Bubble sort: " + Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        System.out.println("Quick sort:  " + Arrays.toString(arr));
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotValue = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivotValue) {
                    i++;
                    int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
                }
            }
            int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
            int pivot = i + 1;

            quickSortHelper(arr, low, pivot - 1);
            quickSortHelper(arr, pivot + 1, high);
        }
    }

    public void mergeSort(int[] arr) {
        mergeSortHelper(arr);
        System.out.println("Merge sort:  " + Arrays.toString(arr));
    }

    private void mergeSortHelper(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSortHelper(left);
            mergeSortHelper(right);

            int i = 0, l = 0, r = 0;
            while (l < left.length && r < right.length) {
                arr[i++] = (left[l] <= right[r]) ? left[l++] : right[r++];
            }
            while (l < left.length) arr[i++] = left[l++];
            while (r < right.length) arr[i++] = right[r++];
        }
    }
}
