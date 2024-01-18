import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Question {
    public static void main(String[] args) {
        int[] num = { 1, 2, 2, 1, 1, 3 };
        // int[] res = movingZeros(num);
        // for(int i=0;i<num.length;i++){
        // System.out.print(num[i]+" ");
        // }
        System.out.println(uniqueOccurrences(num));

    }

    private static int[] movingZeros(int[] nums) {
        int j = 0, k = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = nums.length - 1; i > j - 1; i--) {
            nums[i] = 0;
        }
        return nums;
    }
    //Leetcode - Unique Occurences of elements in an Array
    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int count = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], count);
        }
        
        for (Map.Entry<Integer, Integer> mapElement : map.entrySet()) {
            System.out.println(mapElement.getKey() + " : " + mapElement.getValue());
            al.add(mapElement.getValue());
        }
        Collections.sort(al);
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i)==al.get(i+1)){
                return false;
            }
        }
        return true;
        
    }
}
