class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;
        for (int g : gain) {
            currentAltitude += g; // Update the current altitude
            maxAltitude = Math.max(maxAltitude, currentAltitude); // Track the highest altitude
        }
        
        return maxAltitude;
    }
}
