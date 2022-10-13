package hw3;

import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode78 {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[]{1,2,3});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n==0)return list;
        bt(0, nums, new ArrayList<>(), list);
        return list;
    }

    public static void bt(int idx, int[] nums, List<Integer> temp, List<List<Integer>> list){
        if(idx==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        bt(idx+1, nums, temp, list);
        temp.remove(temp.size()-1);
        bt(idx+1, nums, temp, list);
    }
}
