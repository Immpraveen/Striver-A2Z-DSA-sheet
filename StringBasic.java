import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringBasic {
    public static void main(String[] args) {
        //int[] nums = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
        //System.out.println(uniqueNumberOccurances(nums));
        //String str = "(()())(())";
        //System.out.println(maxNestedDepth(str));
        //System.out.println(removeOuterParathesis(str));
        
        String s = "7542351161";
        System.out.println(largestOddNumber(s));

        // String s = "  hello world  "; //"this is an amazing program"
        // System.out.println(reverseString(s));
    }
    //Coding Ninja String Question
    private static int maxNestedDepth(String str){
        char[] s = str.toCharArray();
        int count = 0,max_count=0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='('){
                count++;
                max_count = Math.max(max_count,count);
            }
            else if(s[i]==')'){
                count--;
            }
        }
        return max_count;
    }
    //Leetcode - Remove Outermost Parentheses
    private static String removeOuterParathesis(String str){
        // String ans = "";
        // char[] s = str.toCharArray();
        // Stack<Character> count = new Stack<>();
        // for(int i=0;i<s.length;i++){
        //     if(s[i]=='('){
        //         count.push(s[i]);
        //         if(count.size()>1 && count.peek()=='('){
        //             ans += s[i];
        //         }
        //     }
        //     else if(count.size()>1 && s[i]==')'&& count.peek()=='('){
        //         count.pop();
        //         ans += "()";   
        //     }
        //     else{
        //         count.pop(); 
        //     }
        // }
        // return ans;

        String ans = "";
        char[] s = str.toCharArray();
        Stack<Character> count = new Stack<>();
        for(int i=0;i<s.length;i++){
            if(s[i]=='('){
                count.push(s[i]);
                if(count.size()>1){
                    ans += s[i];
                }
            }
            else if(s[i]==')'){
                if(count.size()>1 ){
                    ans += s[i];
                    count.pop();
                }
                else if(count.size()==1){
                        count.clear();
                }
            }
        }
        return ans;
    }
    //Leetcode - Unique Number Occurances
    private static boolean uniqueNumberOccurances(int[] arr){
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> al = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            int count = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], count);   
        } 
        for(Map.Entry<Integer,Integer> items: map.entrySet()){
            al.add(items.getValue());
        }
        Collections.sort(al);
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i)==al.get(i+1)){
                return false;
            }
        }
        return true;
    }
    //Reverse the String
    private static String reverseString(String s){
        
        String ans = "";
        char[] str = s.toCharArray();
        String word = "";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(str[i]!=' '){
                word += str[i];    
            }
            else{
                if(word!=""){
                    stack.push(word);
                    word = "";
                }
            }
        }
        if(word!="")
        stack.push(word);
        while(!stack.empty()){
            word = stack.pop();
            ans += word;
            if(stack.size()!=0){
                ans += " ";
            }
        }
        return ans;
    }
    //Leetcode - Largest odd number in a String
    private static String largestOddNumber(String num) {
        double val = Double.parseDouble(num);
        double max_odd = Integer.MIN_VALUE;
        String ans = "";
        if(val%2!=0){
            ans += val;
            return ans;
        }
        else if(num==""){
            return num;
        }
        else{
            double temp = val;
            while(temp>0){
                temp = temp/10;
                if(temp%2!=0){
                    max_odd = Math.max(max_odd,temp);
                }
            }
            temp = val;
            while(temp>0){
                double rem = temp%10;
                if(rem%2!=0){
                    max_odd = Math.max(max_odd,rem);
                }
                
                temp = temp/10;
            }
        }
        ans += max_odd;
        return ans;
    } 
}
