class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        // Base case validation
        if (M > N || M == 0) {
            return result;
        }

        // Initialize and build the KMP LPS array
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; // Text scanner pointer
        int j = 0; // Pattern scanner pointer

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                // Store the 0-based pattern matching starting index
                result.add(i - j);
                // Roll back using lps to accommodate potential overlapping matches
                j = lps[j - 1];
            } 
            // Mismatch condition handling
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // Computes the Longest Prefix Suffix mapping array
    private void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; 
        int i = 1;
        lps[0] = 0; 

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
