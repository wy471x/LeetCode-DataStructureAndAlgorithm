package cn.dunkwan.problems.problem370;

public class Problem370 {
    public static void main(String[] args) {
        int length = 5;
        int[][] array = {{1, 3, 2},{2, 4, 3},{0, 2, -2}};
        Solution solution = new Solution();
        int[] result = solution.getModifiedArray(length, array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
