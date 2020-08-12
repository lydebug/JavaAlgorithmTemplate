package datastructure.graph;

/**
 * @Author: liyang27
 * @Date: 2020/8/2 15:14
 * @Description:判断二分图
 */
public class Leetcode785 {
    public static void main(String[] args) {
        int[][] graph = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
        Leetcode785 A = new Leetcode785();
        System.out.println(A.isBipartite(graph));
    }

    public int[] visited;
    boolean flag = true;

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 3 || graph[0] == null) {
            return true;
        }
        visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0 && visited[i] == 0 && flag) {
                visited[i] = 1;
                dfs(graph, i);
            }
        }
        return flag;
    }

    public void dfs(int[][] graph, int index) {
        if (!flag) {
            return;
        }
        for (int e : graph[index]) {
            if (!flag) {
                return;
            }
            if (visited[e] == 0) {
                visited[e] = visited[index] == 1 ? 2 : 1;
                dfs(graph, e);
            } else {
                flag = !(visited[e] == visited[index]);
            }
        }
    }
}
