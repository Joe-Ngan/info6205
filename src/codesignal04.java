import java.util.*;

public class codesignal04 {
    public static void main(String[] args) {
        int[] a = {2,4,7,5,3,5,8,5,1,7};
        int m = 4;
        int k = 10;
        System.out.println(solution(a, m, k));
    }
    public static int solution(int[] a, int m, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++){
            int cur = a[i];
            if(i>=m-1){
                List<Integer> curList = map.getOrDefault(cur, new ArrayList<>());
                if(curList.size()>0){
                    int dis = i-curList.get(curList.size()-1)+1;
                    if(m-dis>=0){
                        for(int j=i; j<=i+m-dis; j++)set.add(j);
                    }
                }
            }
            List<Integer> curList = map.getOrDefault(k-cur, new ArrayList<>());
            curList.add(i);
            map.put(k-cur, curList);
        }
        return set.size();
    }
}
