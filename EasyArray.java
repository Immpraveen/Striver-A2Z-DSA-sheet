import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyArray {
    public static void main(String[] args) {
        // int[] arr = new int[] { 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 4, 5, 6 };
        // System.out.println("Largest Number: "+findLargest(arr));
        // System.out.println("Second Largest Number: "+secondLargest(arr));

        // int index = removeDuplicate(arr);
        // for (int i = 0; i < index; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int[] arr = { 1, 2, 0, 0, 0, 0, 3, 4, 0, 0, 5 };
        // System.out.println("Is sorted? "+ isSorted(arr));
        // leftRotate(arr);
        // leftRotateByN(arr, 2);
        // Moving Zeroes
        // moveZeroes(arr);
        // Linear Search
        // System.out.println("Element 4 is present at " + (linearSearch(arr, 4) + 1) +
        // " positions.");
        // print(arr);

        // Array Union
        // int[] arr1 = { 1, 2, 3, 4, 5 };
        // int[] arr2 = { 2, 3, 4, 4, 5 };
        // ArrayList<Integer> result = union(arr1, arr2);
        // for (int num : result) {
        // System.out.print(num + " ");
        // }

        // int[] arr = {1,2,4,5};
        // //find missing number in an array where number is between 1 to N
        // System.out.println("Missing number : "+ findMissing(arr, 5));

        // int[] arr = {5,4,3,2,1};
        // print(arr);
        // Arrays.sort(arr);
        // System.out.println();
        // print(arr);

        // int[] arr = { 1, 0, 1, 1, 0, 1 ,5};
        // // System.out.println("Consecutive ones: " + consecutiveOnes(arr));
        // System.out.println("Occur ones: "+occurOnes(arr));

        // Subarray Sum K
        // int[] arr = { 2, 3, 5, 1, 9 };
        // System.out.println(subarraySum(arr, 10));

        //Longest subarray with sum K
        int[] arr = {-1,1,1};
        System.out.println(LongestSubarray(arr, 1));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int secondLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int secondmax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }
        return secondmax;
    }

    private static int removeDuplicate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[arr.length - 1];
        return j;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void leftRotate(int[] arr) {
        // int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            swap(arr, i - 1, i);
        }
    }

    private static void leftRotateByN(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < arr.length; j++) {
                swap(arr, j - 1, j);
            }
        }
    }

    private static void moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                arr[j++] = arr[i];
        }
        while (j < arr.length) {
            arr[j++] = 0;
        }
    }

    private static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static ArrayList<Integer> union(int[] arr1, int[] arr2) {
        Map<Integer, Integer> result = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            result.put(arr1[i], result.getOrDefault(arr1[i], 0) + 1);
            if (result.get(arr1[i]) == 1)
                union.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            result.put(arr2[i], result.getOrDefault(arr2[i], 0) + 1);
            if (result.get(arr2[i]) == 1)
                union.add(arr2[i]);
        }
        return union;
    }

    private static int findMissing(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != (i + 1))
                return (i + 1);
        }
        return -1;
    }

    private static int consecutiveOnes(int[] arr) {
        int prevcount = 0;
        int currcount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                currcount++;
            else
                currcount = 0;

            if (prevcount < currcount)
                prevcount = currcount;
        }

        return prevcount;
    }

    private static int occurOnes(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    private static int subarraySum(int[] arr, int sum) {
        int prevCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = sum;
            int currCount = 0;
            int j = i;
            while (temp > 0 && j < arr.length) {
                temp = temp - arr[j++];
                currCount++;
                if (temp <= 0)
                    break;

            }
            if (prevCount < currCount && temp == 0)
                prevCount = currCount;
        }
        return prevCount;
    }

    // Longest Subarray with sum K
    private static int LongestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int startIndex = -1;
        int endIndex = -1;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (map.containsKey(s - k)) {
                int len = i - map.get(s - k);
                if (maxlen < len) {
                    maxlen = len;
                    startIndex = map.get(s - k) + 1;
                    endIndex = i;
                }
            } else {
                map.put(s, i);
            }
        }
        return (endIndex - startIndex + 1);
    }

}