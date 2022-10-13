import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, temp, list);
        return list;
    }

    public static void bt(int[] nums, List<Integer> temp, List<List<Integer>> list){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i]))continue;
            temp.add(nums[i]);
            bt(nums, temp, list);
            temp.remove(temp.size()-1);
        }
    }
}
