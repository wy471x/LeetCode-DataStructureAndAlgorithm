//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 567 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, Integer> targetMap;
    private Map<Character, Integer> windowMap;

    public boolean checkInclusion(String s1, String s2) {
        targetMap = new HashMap<>();
        windowMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            targetMap.put(s1.charAt(i), targetMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            Character c = s2.charAt(right);
            // 右边界右移
            right++;
            if (targetMap.containsKey(c)) {
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            }

            while (right - left >= s1.length()) {
                if (valid == targetMap.size()) {
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (targetMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
//                    windowMap.put(d, windowMap.get(d) == null ? 0 : (windowMap.get(d) - 1));
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
