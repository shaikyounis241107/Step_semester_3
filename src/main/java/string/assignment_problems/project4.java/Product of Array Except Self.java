class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int left = 1;

        // Left products
        for (int i = 0; i < n; i++) {
            answer[i] = left;
            left = left * nums[i];
        }

        int right = 1;

        // Right products
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }
}