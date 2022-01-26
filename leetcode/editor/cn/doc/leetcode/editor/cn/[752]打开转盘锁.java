//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 436 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public final static String DEFAULT_VALUE = "0000";

    public int openLock(String[] deadends, String target) {
        // 临界情况
        if (DEFAULT_VALUE.equals(target)) {
            return 0;
        }
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        if (deads.contains(DEFAULT_VALUE)) {
            return -1;
        }
        // 初始化
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(DEFAULT_VALUE);
        visited.add(DEFAULT_VALUE);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (deads.contains(str)) {
                    continue;
                }
                if (str.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plusStr = plus(str, j);
                    if (!visited.contains(plusStr)) {
                        queue.offer(plusStr);
                        visited.add(plusStr);
                    }
                    String minusStr = minus(str, j);
                    if (!visited.contains(minusStr)) {
                        queue.offer(minusStr);
                        visited.add(minusStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 向上拨动
    private String plus(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    // 向下拨动
    private String minus(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
