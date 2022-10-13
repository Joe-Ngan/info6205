package hw3;

import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode17 {
    public static void main(String[] args) {
        letterCombinations("327978689");
    }
    public static String[] charList = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0)return list;
        bt(0, digits, new StringBuffer(), list);
        return list;

    }

    public static void bt(int idx, String digits, StringBuffer sb, List<String> list){
        if(idx==digits.length()){
            list.add(sb.toString());
            return;
        }
        String letters = charList[digits.charAt(idx)-'0'];
        for(char c : letters.toCharArray()){
            sb.append(c);
            bt(idx+1, digits, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
