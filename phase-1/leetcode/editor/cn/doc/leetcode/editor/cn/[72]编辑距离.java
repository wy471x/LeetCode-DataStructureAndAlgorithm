//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 2073 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return dp(word1, word2, word1.length()-1, word2.length()-1);
    }
    private int dp(String s1, String s2, int i, int j){
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(memo[i][j] != 0) return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1,s2,i-1,j-1);
        }else{
            int a = dp(s1,s2,i,j-1) + 1;
            int b = dp(s1,s2,i-1,j) + 1;
            int c = dp(s1,s2,i-1,j-1) + 1;
            memo[i][j] = Math.min(a, Math.min(b, c));
        }
        return memo[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
