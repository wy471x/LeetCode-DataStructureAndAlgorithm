//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。 
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... 
//endIndex]（包括 startIndex 和 endIndex）增加 inc。 
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
// Related Topics 数组 前缀和 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] diff;

    int[] nums;

    public int[] getModifiedArray(int length, int[][] updates) {
        nums = new int[length];
        diff = initDiffArray(nums);

        for (int i = 0; i < updates.length; i++) {
            diff[updates[i][0]] += updates[i][2];
            // index greater than length of array
            if (updates[i][1] + 1 < length) {
                diff[updates[i][1] + 1] -= updates[i][2];
            }
        }

        return recoverNums();

    }

    // initializing difference array
    int[] initDiffArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] - nums[i - 1];
        }
        return result;
    }

    // recoverred by difference array
    int[] recoverNums() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
