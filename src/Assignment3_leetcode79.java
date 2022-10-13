public class Assignment3_leetcode79 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board, word);
    }
    public static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int len = word.length();
        if(len>m*n)return false;
        if(len==0)return true;
        boolean[][] seen = new boolean[m][n];
        char first = word.charAt(0);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == first){
                    seen[i][j] = true;
                    if(bt(board, i, j, word, 0, seen))return true;
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean bt(char[][] board, int i, int j, String word, int idx, boolean[][] seen){
        if(idx==word.length()-1)return true;
        int m = board.length, n = board[0].length;

        for(int[] dir : dirs){
            int x = dir[0]+i;
            int y = dir[1]+j;
            if(x<0 || x>=m || y<0 || y>=n)continue;
            if(seen[x][y])continue;
            if(board[x][y] == word.charAt(idx+1)){
                seen[x][y] = true;
                if(bt(board, x, y, word, idx+1, seen))return true;
                seen[x][y] = false;
            }
        }
        return false;
    }
}
