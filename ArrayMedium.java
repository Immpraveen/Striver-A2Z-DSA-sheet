import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ArrayMedium {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 8, 11 };
        // System.out.println(pairSum(arr, 14));
        // ArrayList<Integer> result = pairSumIndex(arr, 14);
        // for(Integer value: result){
        // System.out.print(value+" ");
        // }

        // Optimal pair sum -
        // System.out.println(optimalPairSum(arr, 11));

        // Optimal pair sum indexes
        // int[] ans = optimalPairSumIndex(arr, 10);
        // for(int i=0;i<ans.length;i++){
        // System.out.print(ans[i]+" ");
        // }

        // Sorting Zeroes ones and twos
        int[] ar = { 2, 0, 2, 1, 1, 0, 2, 2, 2 };
        // sortZerosOnesTwos(ar);
        // for (int i = 0; i < ar.length; i++) {
        // System.out.print(ar[i] + " ");
        // }

        System.out.println(majorityElement(ar));
    }

    private static boolean pairSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList pairSumIndex(int[] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum && i != j) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }

    private static boolean optimalPairSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = sum - arr[i];
            map.put(arr[i], value);
            if (map.containsKey(value))
                return true;
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] optimalPairSumIndex(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = { -1, -1 };
        for (int i = 0; i < arr.length; i++) {
            int value = sum - arr[i];
            if (map.containsKey(value)) {
                ans[0] = map.get(value);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }

    private static void sortZerosOnesTwos(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static int majorityElement(int[] arr) {
        int majority_element = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], val);
        }
        int maxCount = -1;
        int key = -1;
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            if (element.getValue() > maxCount){
                maxCount = element.getValue();
                key = element.getKey();
            }
            System.out.println("Key: " + element.getKey() + " Value: " +
                    element.getValue());
        }
        if (maxCount > arr.length / 2)
            return key;
        else
            return -1;
    }

    
}
