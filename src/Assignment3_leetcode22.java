import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(0, 0, n, "", list);
        return list;
    }

    public static void dfs(int l, int r, int n, String s, List<String> list){
        if(l==n && r==n){
            list.add(s);
            return;
        }
        if(l<n)dfs(l+1, r, n, s+"(", list);
        if(r<l)dfs(l, r+1, n, s+")", list);
    }
}
