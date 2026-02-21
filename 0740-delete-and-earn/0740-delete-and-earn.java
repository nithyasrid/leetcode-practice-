class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 1. Build points array: index = number, value = total points from all occurrences
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // 2. House robber DP on points
        int prev1 = 0, prev2 = 0;
        for (int val : points) {
            int curr = Math.max(prev1, prev2 + val);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}