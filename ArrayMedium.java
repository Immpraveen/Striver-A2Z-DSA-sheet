import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

        // Mojority Element
        // System.out.println(majorityElement(ar));

        // Maximum sum of a subarray
        // int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubarraySum(test));

        // Printing subarray with maximum sum
        // int[] test = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // int[] result = maxSumSubarray(test);
        // for (int i = result[0]; i <= result[1]; i++) {
        // System.out.print(test[i] + " ");
        // }

        // int[] test = {3,1,-2,-5,2,-4};
        // // ArrayList<Integer> result = rearrangeBySign(test);
        // int[] res = rearrangeBySign(test);
        // for(int i=0;i<res.length;i++){
        // System.out.print(res[i]+" ");
        // }

        /*
         * int[] nextarray = { 2, 3, 1 };
         * nextPermutation(nextarray);
         * for (int i = 0; i < nextarray.length; i++) {
         * System.out.print(nextarray[i] + " ");
         * }
         */

        /*
         * //Leader i.e all the elements in the right is smaller than it
         * int[] test = {10, 22, 12, 3, 0, 6};
         * leader(test);
         */

        /*
         * // LongestConsecutiveSubsequence
         * int[] test = { 100, 200, 1, 3, 2, 4 };
         * System.out.print(longConsecutiveSubsequence(test) + " ");
         */

        // //ZeroMatrix
        // int[][] test = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // zeroMatrix(test, 3, 4);
        // print2D(test,3,4);

        // Rotate the matrix by 90
        // int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        // int m=3,n=3;
        // int [][] res = rotateByNinty(nums, 3, 3);
        // for(int i=0;i<m;i++){
        // for(int j=0;j<n;j++){
        // System.out.print(res[i][j]+" ");
        // }
        // System.out.println( );
        // }

        // int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // rotateByNintyOptimal(nums, 3, 3);
        // int m = 3, n = 3;
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(nums[i][j] + " ");
        // }
        // System.out.println();
        // }

        // //Spiral of matrix
        // int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // spiral(nums);

        //Count of subarray with sum k
        int[] nums = {3,1,2};
        int res = countOfSubarrayWithSumK(nums, 3 );
        System.out.println(res);

    }

    private static void print2D(int[][] test, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println("");
        }
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
            if (element.getValue() > maxCount) {
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

    // Kadane Algorithm
    private static int maxSubarraySum(int[] arr) {
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum >= 0) {
                if (sum > res)
                    res = sum;
            } else
                sum = 0;
        }
        return res;
    }

    // Print indexes of subarray with maximum sum
    private static int[] maxSumSubarray(int[] arr) {
        int sum = 0;
        int res = 0;
        int[] indexes = { -1, -1 };
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum >= 0) {
                if (sum > res) {
                    res = sum;
                    indexes[1] = i;
                }
            } else {
                sum = 0;
                indexes[0] = i + 1;
            }
        }
        return indexes;
    }

    // Buy and Sell Stock to maximize the profit
    private static int result(int[] prices) {

        // Bruteforce Approach
        /*
         * int result = 0;
         * for(int i=0;i<prices.length;i++){
         * int j=prices.length-1;
         * while(j>i){
         * int profit = prices[j]-prices[i];
         * if(result<profit && profit > 0)
         * result = profit;
         * j--;
         * }
         * }
         * return result;
         */

        // Optimal Approach with time complexity O(n) -
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (maxPro < prices[i] - minPrice)
                maxPro = prices[i] - minPrice;
        }
        return maxPro;
    }

    private static int[] rearrangeBySign(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // result.add(pos,nums[i]);
                result[pos] = nums[i];
                pos += 2;
            } else {
                // result.add(neg,nums[i]);
                result[neg] = nums[i];
                neg += 2;
            }
        }
        return result;
    }

    private static void nextPermutation(int[] nums) {
        int breakpoint = -1;
        int flag = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                breakpoint = i - 1;
                flag = 1;
                break;
            }
        }
        if (breakpoint != -1) {
            int smallpos = -1, i;
            for (i = nums.length; i >= 0; i--) {
                if (nums[i] >= nums[i]) {
                    smallpos = i;
                    break;
                }
            }
            swap(nums, smallpos, breakpoint);
            sort(nums, breakpoint + 1);
        } else
            reverseSort(nums, 0);
    }

    private static void reverseSort(int[] nums, int breakpoint) {
        for (int i = breakpoint; i < nums.length; i++) {
            for (int j = breakpoint; j < nums.length - 1; j++) {
                if (nums[j] <= nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void sort(int[] nums, int breakpoint) {
        int i = breakpoint;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void leader(int[] nums) {

        /*
         * Bruteforce with complexity O(n2)
         * for(int i=0;i<nums.length;i++){
         * int flag = 0;
         * int max=nums[i];
         * int j = nums.length-1;
         * while(j>i){
         * if(nums[j]>max){
         * flag = 1;
         * break;
         * }
         * else j--;
         * }
         * if(flag==0){
         * System.out.print(nums[i]+" ");
         * }
         * }
         */

        // Optimal Solution with time complexity O(n)
        Stack<Integer> ans = new Stack<>();
        int max = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        for (Integer ele : ans) {
            System.out.print(ele + " ");
        }
    }

    private static boolean linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (key == nums[i])
                return true;
        }
        return false;
    }

    private static int longConsecutiveSubsequence(int[] nums) {

        // Bruteforce solution
        /*
         * int maxCount = 0;
         * for (int i = 0; i < nums.length; i++) {
         * int number = nums[i];
         * int currentcount = 0;
         * while (linearSearch(nums, number) != false) {
         * currentcount++;
         * if (currentcount > maxCount)
         * maxCount = currentcount;
         * number++;
         * }
         * }
         * return maxCount;
         */

        /*
         * // Better Solution
         * Arrays.sort(nums);
         * int max = 1;
         * int currentcount = 1;
         * for(int i=0;i<nums.length-1;i++){
         * if(nums[i]+1==nums[i+1]){
         * max++;
         * if(max>currentcount)
         * currentcount = max;
         * }
         * else{
         * max=1;
         * }
         * }
         * return currentcount;
         */

        // Optimal solution
        int maxCount = 1;
        Set<Integer> array = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
        }
        for (Integer it : array) {
            if (!array.contains(it - 1)) {
                int count = 1;
                int number = it;
                while (array.contains(number + 1)) {
                    number++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    // class pair{
    // public int num1;
    // public int num2;

    // public void getinput(int num1,int num2){
    // num1 = num1;
    // num2 = num2;
    // }
    // }
    private static void zeroMatrix(int[][] nums, int n, int m) {

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // ans.add(0,{1,2});
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer it : rows) {
            System.out.print(it + " ");
        }
        System.out.println("");
        for (Integer it : cols) {
            System.out.print(it + " ");
        }
        System.out.println("");
        for (Integer index : rows) {
            for (int i = 0; i < m; i++) {
                nums[index][i] = 0;
            }
        }
        for (Integer index : cols) {
            for (int i = 0; i < n; i++) {
                nums[i][index] = 0;
            }
        }
    }

    // Bruteforce method
    private static int[][] rotateByNinty(int[][] nums, int m, int n) {

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = nums[i][j];
            }
        }
        return res;
    }

    private static void rotateByNintyOptimal(int[][] nums, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[i][n - 1 - j];
                nums[i][n - 1 - j] = temp;
            }
        }
    }

    private static void spiral(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == 0 || i == nums.length - 1 || j == 0 || j == nums.length - 1)
                    System.out.print(nums[i][j] + " ");
                else {
                    System.out.print((nums[i + 1][j] + nums[i][j + 1] + nums[i + 1][j + 1] + nums[i][j]) / 4 + " ");
                }
            }
        }
    }

    private static int countOfSubarrayWithSumK(int[] nums, int k) {
        int sum = k;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum=k;
            int j=i;
            while (j < nums.length) {
                sum = sum - nums[j];
                j++;
                if (sum == 0)
                    count++;
            }
        }
        return count;
    }
}
