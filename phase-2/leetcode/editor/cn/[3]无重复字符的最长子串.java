//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6897 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> windowMap;

    public int lengthOfLongestSubstring(String s) {
        windowMap = new HashMap<>();
        int right = 0, left = 0, len = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            while (windowMap.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                windowMap.put(d, windowMap.get(d) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
