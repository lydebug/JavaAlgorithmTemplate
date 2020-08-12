package datastructure.graph.union_find;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 21:16
 * @Description:冗余连接
 */
public class Leetcode684 {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length < 1 || edges[0] == null || edges[0].length < 1) {
            return new int[0];
        }
        parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (connected(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            } else {
                union(edges[i][0], edges[i][1]);
            }
        }
        return new int[0];
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp != rootq) {
            parent[rootp] = rootq;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        return rootp == rootq;
    }
}
