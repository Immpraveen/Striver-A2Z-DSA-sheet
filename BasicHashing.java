import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,3,4,5,6};
        // countOccurance(arr);
        // MaxMinOccurance(arr);
        sc.close();
      
    }
    private static void countOccurance(int[] arr){
        Map<Integer,Integer> mapp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mapp.containsKey(arr[i])){
            mapp.put(arr[i], mapp.get(arr[i])+1);
            }
            else{
                mapp.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: mapp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    private static void MaxMinOccurance(int[] arr){
        Map<Integer,Integer> mapp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mapp.containsKey(arr[i])){
            mapp.put(arr[i], mapp.get(arr[i])+1);
            }
            else{
                mapp.put(arr[i],1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxkey = 0;
        int min = Integer.MAX_VALUE;
        int minkey = 0;
        for(Map.Entry<Integer,Integer> entry: mapp.entrySet()){
            if(max < entry.getValue()){
            max = entry.getValue();
            maxkey = entry.getKey();
            }
            if(min > entry.getValue()){
            min = entry.getValue();
            minkey = entry.getKey();
            }
        }
        System.out.println("Maximum occuring Key : "+maxkey+"\nMinimun occuring Key : "+ minkey);
    }
}
