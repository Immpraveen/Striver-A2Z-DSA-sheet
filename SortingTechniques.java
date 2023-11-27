public class SortingTechniques {
    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Given Array");
        printArray(arr);
        // Selection sort array
        selectionSort(arr);
        System.out.println("\nSorted array");
        printArray(arr);
        //Bubble sort array
        bubbleSort(arr);
        System.out.println("\nSorted array");
        printArray(arr);
        //Insertion sort array
        insertionSort(arr);
        System.out.println("\nSorted array");
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
}
