package hw3;

import java.util.ArrayList;
import java.util.List;

public class Assignment3_leetcode797 {
    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(0, graph, temp, list);
        return list;
    }

    public static void dfs(int idx, int[][] graph, List<Integer> temp, List<List<Integer>> list){
        if(idx==graph.length-1){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int g: graph[idx]){
            temp.add(g);
            dfs(g, graph, temp, list);
            temp.remove(temp.size()-1);
        }
    }
}
