//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 770 👎 0


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Character, Integer> targetMap;
    private Map<Character, Integer> windowMap;
    public List<Integer> findAnagrams(String s, String p) {
        targetMap = new HashMap<>();
        windowMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            // 窗口右边界移动
            Character c = s.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                //
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            // 窗口左边界移动条件
            // 当窗口内元素个数大于等于p串时，可进行左边界移动
            while (right - left >= p.length()) {
                // 有效个数等于targetMap大小时，直接添加起始下标
                if (valid == targetMap.size()) {
                    start = left;
                    res.add(start);
                }
                Character d = s.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (targetMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
