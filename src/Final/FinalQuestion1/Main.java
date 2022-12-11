package Final.FinalQuestion1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] str = {"eat","tea","tan","ate","nat","bat"};
//        String[] str = {""};
//        String[] str = {"a"};
        List<List<String>> ans = GroupAnagram(str);
        System.out.println(ans.size());
        System.out.println("--------");
        for(List<String> an : ans){
            for(String a : an){
                System.out.println(a);
            }
            System.out.println("--------");
        }
        System.out.println("Time complexity: O(26*n*m)---> O(n*m). n is the length of the str while m is the length of str[0]");
        System.out.println("Space complexity: O(26*n)---> O(n). n is the length of the str");
    }

    private static List<List<String>> GroupAnagram(String[] str) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String s : str){
            String origin = getOrigin(s);
            Set<String> set = map.getOrDefault(origin, new HashSet<>());
            set.add(s);
            map.put(origin, set);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, Set<String>> entry: map.entrySet()){
            Set<String> set = entry.getValue();
            List<String> cur = new ArrayList<>();
            for(String s : set){
                cur.add(s);
            }
            ans.add(cur);
        }
        return ans;
    }

    private static String getOrigin(String s) {
        int[] cnt = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            cnt[c-'a']++;
        }
        String ans = "";
        for(int i=0; i<26; i++){
            if(cnt[i]==0)continue;
            int times = cnt[i];
            while (times-->0){
                ans += (char)(i+'a');
            }
        }
        return ans;
    }

}
