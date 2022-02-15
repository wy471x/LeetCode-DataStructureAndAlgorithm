//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 592 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, uppper = 0, lower = n - 1;
        // 起始值为1
        int count = 1;
        while (count <= n * n) {
            // 上侧从左往右遍历
            if (uppper <= lower) {
                for (int i = left; i <= right; i++) {
                    matrix[uppper][i] = count;
                    count++;
                }
                uppper++;
            }
            // 右侧从上往下遍历
            if (right >= left) {
                for (int i = uppper; i <= lower; i++) {
                    matrix[i][right] = count;
                    count++;
                }
                right--;
            }
            // 下侧从右往左遍历
            if (lower >= uppper) {
                for (int i = right; i >= left; i--) {
                    matrix[lower][i] = count;
                    count++;
                }
                lower--;
            }
            // 左侧从下往上遍历
            if (left <= right) {
                for (int i = lower; i >= uppper; i--) {
                    matrix[i][left] = count;
                    count++;
                }
                left++;
            }
        }
        return matrix;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
