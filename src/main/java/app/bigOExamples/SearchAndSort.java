package app.bigOExamples;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchAndSort {

    public static void main(String[] args) {
        int arr1[] = {64, 34, 25, 12, 22, 11, 90, 12, 31, 99, 63, 23, 1, 6, 87, 65 };
        List<Integer> arr = new ArrayList<>(List.of(64, 34, 25, 12, 22, 11, 90, 12, 31, 99, 63, 23, 1, 6, 87, 65 ));

       // bubbleSort(arr);
        mergeSortList(arr1);
        quickSort(arr,0, arr.size() - 1);

        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
    }

    private static void bubbleSort(int arr[]){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                  swap(arr, j,j + 1);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSortList(int[] arrays) {
        if (arrays.length > 1) {
            int mid = arrays.length / 2;

            // Opretter midlertidige arrays til venstre og højre side
            int[] left = new int[mid];
            int[] right = new int[arrays.length - mid];

            // Kopierer data over i de to arrays
            for (int i = 0; i < mid; i++) {
                left[i] = arrays[i];
            }
            for (int i = mid; i < arrays.length; i++) {
                right[i - mid] = arrays[i];
            }

            // Sorterer de to halvdele rekursivt
            mergeSortList(left);
            mergeSortList(right);

            // Fletter (merger) dem sammen i det oprindelige array
            merge(arrays, left, right);
        }
    }

    private static void merge(int[] input, int[] left, int[] right) {
        // Tre hjælpevariable der skal bruges som pointere i hver deres array
        int i = 0, l = 0, r = 0;

        // Så længe der er elementer i både venstre og højre array,
        // fortsætter vi sammenligningen
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                input[i] = left[l];
                l++;
            } else {
                input[i] = right[r];
                r++;
            }
            i++;
        }

        // Når det ene array er tomt, kopieres de resterende elementer fra det andet
        while (l < left.length) {
            input[i] = left[l];
            l++;
            i++;
        }

        while (r < right.length) {
            input[i] = right[r];
            r++;
            i++;
        }
    }
    public static void quickSort(List<Integer> arr, int low, int high) {
        // base case - vi hopper ud af rekursion hvis low er >=  high
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivotValue = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivotValue) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }
}

