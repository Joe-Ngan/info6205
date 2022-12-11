package Final.FinalQuestion4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][] obstacleGrid1 = {{0,0,0},{0,1,0},{0,0,0}};
        int n1 = numOfUniquePath(obstacleGrid1);
        System.out.println(n1);
        int[][] obstacleGrid2 = {{0,1},{0,0}};
        int n2 = numOfUniquePath(obstacleGrid2);
        System.out.println(n2);
        System.out.println("Time complexity: O(m*n). m is the length of n obstacleGrid while is the length of the obstacleGrid[0]");
        System.out.println("Space complexity: O(m*n). m is the length of n obstacleGrid while is the length of the obstacleGrid[0]");
    }

    private static int numOfUniquePath(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1)continue;
                if(i==0&&j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = i-1>=0?dp[i-1][j]:0;
                int left = j-1>=0?dp[i][j-1]:0;
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
