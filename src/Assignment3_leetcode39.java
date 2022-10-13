import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        bt(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    public static void bt(int[] c, int idx, int t, List<Integer> temp, List<List<Integer>> list){
        if(t==0){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx; i<c.length; i++){
            int cur = c[i];
            if(t-cur>=0){
                temp.add(cur);
                bt(c, i, t-cur, temp, list);
                temp.remove(temp.size()-1);
            }
        }
    }
}
