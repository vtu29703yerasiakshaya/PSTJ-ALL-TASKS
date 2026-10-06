class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        java.util.Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen[current] >= left) {
                left = lastSeen[current] + 1;
            }

            lastSeen[current] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
