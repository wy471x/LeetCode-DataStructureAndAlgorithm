//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1779 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 1. 路径
    List<List<Integer>> res = new LinkedList<>();
    // 2. 选择列表
    // 3. 结束条件

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path) {
        // 结束条件
        if (nums.length == path.size()) {
            res.add(new LinkedList<>(path));
            return ;
        }

        for (int n : nums) {
            if (path.contains(n)) {
                continue;
            }
            path.add(n);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
