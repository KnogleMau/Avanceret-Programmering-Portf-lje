package app.bigOExamples;
import java.io.*;

public class SearchAndSort {

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90, 12, 31, 99, 63, 23, 1, 6, 87, 65 };
        bubbleSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
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


}
