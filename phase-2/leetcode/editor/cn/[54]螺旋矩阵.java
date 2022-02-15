//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 982 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, upper = 0, lower = m - 1;
        List<Integer> res = new LinkedList<>();

        while (res.size() < m * n) {
            // 上侧从左往右遍历
            if (upper <= lower) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[upper][i]);
                }
                upper++;
            }
            // 右侧从上往下遍历
            if (right >= left) {
                for (int i = upper; i <= lower; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 下侧从右往左遍历
            if (lower >= upper) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[lower][i]);
                }
                lower--;
            }
            // 左侧从下往上遍历
            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
