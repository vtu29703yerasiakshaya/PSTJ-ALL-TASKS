class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        // Track variables for standard Kadane (Maximum Subarray)
        int maxFar = nums[0];
        int currentMax = nums[0];
        
        // Track variables for inverted Kadane (Minimum Subarray)
        int minFar = nums[0];
        int currentMin = nums[0];
        
        totalSum += nums[0];
        
        // Single pass execution
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;
            
            // Standard Kadane to find max subarray
            currentMax = Math.max(num, currentMax + num);
            maxFar = Math.max(maxFar, currentMax);
            
            // Inverted Kadane to find min subarray
            currentMin = Math.min(num, currentMin + num);
            minFar = Math.min(minFar, currentMin);
        }
        
        // Edge Case: If all numbers are negative, maxFar holds the largest single element.
        // totalSum - minFar would result in 0 (empty subarray), which is invalid since the subarray must be non-empty.
        if (maxFar < 0) {
            return maxFar;
        }
        
        // Return the larger of the non-circular and circular results
        return Math.max(maxFar, totalSum - minFar);
    }
}
