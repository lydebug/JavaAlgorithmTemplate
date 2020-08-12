package algorithm.floodFill;

import java.util.Arrays;

/**
 * @Author: liyang27
 * @Date: 2020/7/27 19:10
 * @Description:图像渲染
 */
public class Leetcode733 {
    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        Leetcode733 A = new Leetcode733();
        int[][] image = A.floodFill(img, sr, sc, newColor);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] f = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, oldColor, newColor, f);
        return image;
    }

    public void dfs(int[][] img, int sr, int sc, int oldColor, int color, boolean[][] f) {
        if (isValid(img, sr, sc, oldColor, f)) {
            img[sr][sc] = color;
            f[sr][sc] = true;
            dfs(img, sr + 1, sc, oldColor, color, f);
            dfs(img, sr, sc + 1, oldColor, color, f);
            dfs(img, sr - 1, sc, oldColor, color, f);
            dfs(img, sr, sc - 1, oldColor, color, f);
        }
    }

    public boolean isValid(int[][] img, int sr, int sc, int oldColor, boolean[][] f) {
        if (sr >= 0 && sr < img.length && sc >= 0 && sc < img[0].length && img[sr][sc] == oldColor && !f[sr][sc]) {
            return true;
        }
        return false;
    }
}
    /*void fill(int[][] image, int x, int y,
              int origColor, int newColor) {
        // 出界：超出数组边界
        if (!inArea(image, x, y)) return;
        // 碰壁：遇到其他颜色，超出 origColor 区域
        if (image[x][y] != origColor) return;
        // 已探索过的 origColor 区域
        if (image[x][y] == -1) return;

        // choose：打标记，以免重复
        image[x][y] = -1;
        fill(image, x, y + 1, origColor, newColor);
        fill(image, x, y - 1, origColor, newColor);
        fill(image, x - 1, y, origColor, newColor);
        fill(image, x + 1, y, origColor, newColor);
        // unchoose：将标记替换为 newColor
        image[x][y] = newColor;
    }*/
