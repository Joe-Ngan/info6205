package Final.FinalQuestion2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        char[][] grid = {{'1','1','1','1','0'},
                           {'1','1','0','1','0'},
                           {'1','1','0','0','0'},
                           {'0','0','0','0','0'}};
        
        char[][] grid1 = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};
        int cntIsland = countIsland(grid);
        System.out.println(cntIsland);
        System.out.println("Time complexity: O(n*m). m is the length of the grid while n is the length of grid[0]");
        System.out.println("Space complexity: O(1).");
    }

    private static int countIsland(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0')return;

        grid[i][j]  = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
