import java.util.ArrayList;

public class SortingTechniques {
    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Given Array");
        printArray(arr);
        // // Selection sort array
        // selectionSort(arr);
        // System.out.println("\nSorted array");
        // printArray(arr);
        // //Bubble sort array
        // bubbleSort(arr);
        // System.out.println("\nSorted array");
        // printArray(arr);
        // //Insertion sort array
        // insertionSort(arr);
        // System.out.println("\nSorted array");
        // printArray(arr);

        // // merge sort array
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println("\nSorted array");
        // printArray(arr);

        // // Recursive bubble sort array
        // recursiveBubbleSort(arr, arr.length);
        // System.out.println("\nSorted array");
        // printArray(arr);

        // //Recursive insertionSort array
        // recursiveInsertionSort(arr, arr.length,0);
        // System.out.println("\nSorted array");
        // printArray(arr);

        // QuickSort Array
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nsorted array");
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int small = arr[i];
            int pos = i;
            for (int j = i; j < arr.length; j++) {
                if (small >= arr[j]) {
                    small = arr[j];
                    pos = j;
                }
            }
            swap(arr, i, pos);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            {
                temp.add(arr[right]);
                right++;
            }
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    private static void recursiveBubbleSort(int[] arr, int n) {

        if (n == 1)
            return;
        int flag = 0;
        for (int i = 0; i <= n - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                flag = 1;
            }
        }
        if (flag == 0) {
            return;
        }
        recursiveBubbleSort(arr, n - 1);
    }

    private static void recursiveInsertionSort(int[] arr, int n, int i) {
        if (i == n) {
            return;
        } else {
            int j = i;
            while (j > 0 && j < arr.length) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                j--;
            }
            recursiveInsertionSort(arr, n, i + 1);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            do {
                i++;
            } while (arr[i] <= pivot && i<=high-1);
            do {
                j--;
            } while (arr[j] > pivot && j>=low+1);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int j = partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);
        }
    }
}
