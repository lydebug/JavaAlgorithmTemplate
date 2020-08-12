package datastructure.graph.union_find;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 19:40
 * @Description:被包围的区域
 */
public class Leetcode130 {
    boolean[][] visited;

    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0] == null || board[0].length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
