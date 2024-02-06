import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Question {
    public static void main(String[] args) {
        int[] num = { 1, 2, 2, 1, 1, 3 };
        // int[] res = movingZeros(num);
        // for(int i=0;i<num.length;i++){
        // System.out.print(num[i]+" ");
        // }
        // System.out.println(uniqueOccurrences(num));

        // String[] strs = {"flotter","flow","flight"};
        // System.out.println(longestCommonPrefix(strs));

        // String s = "Praveen";
        // char letter = 'e';
        // System.out.println(percentageLetter(s,letter));

        // String s = "LeetEcharm";
        // System.out.println(greatestLetter(s));

        // List<List<Integer>> res = generate(14);
        // for (List<Integer> items : res) {
        //     System.out.println(items);
        // }

        // String s1 = "abc";
        // String s2 = "cba";
        // System.out.println(isIsomorphic(s1, s2));

        // System.out.println(romanToInt("MCMXCIV"));

        // System.out.println(isValid("{]}"));

        String[] str = {};
        System.out.println(evalRPN(str));
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

    // Leetcode - Unique Occurences of elements in an Array
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
        for (int i = 0; i < al.size() - 1; i++) {
            if (al.get(i) == al.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    // Leetcode - Longest Common Prefix
    private static String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    // Leetcode - Percentage of Letter in String
    private static int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        int percentage = ((count * 100) / s.length());
        return percentage;
    }

    // Greatest Letter in a String with Upper and lowercase presence
    private static String greatestLetter(String s) {
        char res = ' ';
        String alpha = "";
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (s.indexOf(Character.toLowerCase(s.charAt(i))) != -1)
                    if (s.charAt(i) > res) {
                        res = s.charAt(i);
                    }
            }
        }
        if (res != ' ') {
            alpha += res;
            return alpha;
        } else
            return " ";
    }

    // Pascal Triangle - Leetcode
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ls = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ls.add(1);
                } else {
                    ls.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(ls);
        }
        return res;
    }

    // Isomorphic String - Leetcode
    public static boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }

    //Roman to Number
    public static int romanToVal(char ch){
        switch(ch){
        case 'I':   return 1;
        case 'V':  return 5;
        case 'X':  return 10;
        case 'L':  return 50;
        case 'C':  return 100;
        case 'D':  return 500;
        case 'M':  return 1000;
        default: return 0;
        }
    }
        
    public static int romanToInt(String s) {
        int val = 0,i=0;
        if(s.length()==1)
        return romanToVal(s.charAt(0));
        else val = romanToVal(s.charAt(0));
    
        for(i=1;i<s.length()-1;i++){
            if(romanToVal(s.charAt(i))<romanToVal(s.charAt(i+1))){
                val += (romanToVal(s.charAt(i+1))-romanToVal(s.charAt(i)));
                if(i!=s.length()-2){
                    i++;
                }
            }
            else{
                val += romanToVal(s.charAt(i));
            }
            
        }
        if(s.charAt(s.length()-1)<s.charAt(s.length()-2)){
            val += romanToVal(s.charAt(i));
        }
        return val;
    }
    // Check whether expression have correct order and number of opening and closing brackets
    public static boolean isValid(String s) {

        Stack<Character> stk = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']'){
                if(stk.size()==0){
                    return false;
                }
                else if(stk.peek()=='{' && s.charAt(i)=='}'){
                    stk.pop();
                }
                else if(stk.peek()=='[' && s.charAt(i)==']'){
                    stk.pop();
                }
                else if(stk.peek()=='(' && s.charAt(i)==')'){
                    stk.pop();
                }
                else return false;
            }
        }
        if(stk.size()==0){
                return true;
        }
        else{
            return false;
        }  

    }

    //Reverse polish notation - Leetcode
    public static boolean isNumeric(String str) {
        try {  
            Double.parseDouble(str);  
            return true;
          } catch(NumberFormatException e){  
            return false;  
          }  
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        if(tokens.length==0){
            return 0;
        }
        for(int i=0;i<tokens.length;i++){
    
            if(isNumeric(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i]=="+"){
                    res = num2 + num1;
                }
                else if(tokens[i]=="-"){
                    res = num2 -  num1;
                }
                else if(tokens[i]=="*"){
                    res = num2 * num1;
                }
                else if(tokens[i]=="/"){
                    res = num2/num1;
                }
                stack.push(res);
            }     
        }
        return stack.pop();
    }
}