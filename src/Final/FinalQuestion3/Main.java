package Final.FinalQuestion3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String res1 = removeParentheses("lee(t(c)o)de)");
        System.out.println(res1);
        String res2 = removeParentheses("a)b(c)d");
        System.out.println(res2);
        String res3 = removeParentheses("))((");
        System.out.println(res3);
        System.out.println("--------");
        System.out.println("Time complexity: O(n). n is the length of the s");
        System.out.println("Space complexity: O(n). n is the length of the s");

    }

    private static String removeParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            char c = cs[i];
            if(c==')'){
                if(stack.isEmpty()){
                    cs[i] = '?';
                }else{
                    stack.removeLast();
                }
            }else if(c=='('){
                stack.addLast(i);
            }
        }
        while(!stack.isEmpty()){
            cs[stack.pollLast()] = '?';
        }
        String res = "";
        for(int i=0; i<cs.length; i++){
            if(cs[i]!='?')res+=cs[i];
        }
        return res;
    }
}
