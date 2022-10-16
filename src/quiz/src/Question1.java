public class Question1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums2 = new int[]{-1,-100,3,99};
        int[] ans = rotateArray(nums2, 8);
        for(int a : ans){
            System.out.println(a);
        }
    }
    public static int[] rotateArray(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        if(k==0)return nums;
        int idx = (n-k);
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            if(idx>=n)idx-=n;
            res[i] = nums[idx];
            idx++;
        }
        return  res;
    }

}
