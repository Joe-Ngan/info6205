package hw3;

import java.util.HashSet;
import java.util.Set;

public class Assignment3_leetcode967 {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> list = new HashSet<>();
        for(int i=1; i<=9; i++){//不包含前导零
            bt(0, i, list, 1, n, k);
        }
        int len = list.size();
        int[] ans = new int[len];
        int i = 0;
        for(int l : list){
            ans[i++] = l;
        }
        return ans;
    }
    public void bt(int curSum, int curNum, Set<Integer> list, int curIdx, int n, int k){
        if(curIdx==n+1){
            list.add(curSum);
            return;
        }

        curSum = curSum * 10 + curNum;
        if(k==0){
            bt(curSum, curNum, list, curIdx+1, n, k);
        }else{
            int nex1 = curNum + k;
            int nex2 = curNum - k;
            if(0<=nex1 && nex1<=9){
                bt(curSum, nex1, list, curIdx+1, n, k);
            }
            if(0<=nex2 && nex2<=9){
                bt(curSum, nex2, list, curIdx+1, n, k);
            }
        }

        return;
    }
}
