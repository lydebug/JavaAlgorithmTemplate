package datastructure.graph.union_find;

/**
 * @Author: liyang27
 * @Date: 2020/7/28 19:18
 * @Description:union find
 */
public class UF {
    private int count;
    private int[] parent;
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) {
            return;
        }
        int sizep = size[p];
        int sizeq = size[q];
        if (sizep < sizeq) {
            parent[rootp] = rootq;
            size[rootq] = size[rootp] + size[rootq];
        } else {
            parent[rootq] = rootp;
            size[rootp] = size[rootp] + size[rootq];
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

    public int count() {
        return count;
    }
}
