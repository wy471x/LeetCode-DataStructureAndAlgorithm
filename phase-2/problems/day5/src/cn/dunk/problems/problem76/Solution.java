package cn.dunk.problems.problem76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 目标字符串字符哈希表
    private Map<Character, Integer> targetMap;
    // 窗口字符哈希表
    private Map<Character, Integer> windowMap;

    public String minWindow(String s, String t) {
        targetMap = new HashMap<>();
        windowMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            Character c = s.charAt(right);
            // 窗口右边界右移
            right++;
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            while (valid == targetMap.size()) {
                // 更新字串起始下标，字符串长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 要删除的字符
                Character d = s.charAt(left);
                // 窗口左边界右移
                left++;
                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
