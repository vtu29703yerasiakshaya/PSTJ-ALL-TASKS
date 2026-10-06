class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int k = 0; // Pointer for the last known unique element
        
        for (int i = 1; i < nums.length; i++) {
            // Found a new unique element
            if (nums[i] != nums[k]) {
                k++;             // Move unique pointer forward
                nums[k] = nums[i]; // Update the position with the unique element
            }
        }
        
        // k is an index, so the number of unique elements is k + 1
        return k + 1;
    }
}
