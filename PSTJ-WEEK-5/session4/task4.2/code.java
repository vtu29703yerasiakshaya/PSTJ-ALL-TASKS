import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] patternToWord = new int[26];
        int[] wordToPattern = new int[26];

        Arrays.fill(patternToWord, -1);
        Arrays.fill(wordToPattern, -1);

        for (int i = 0; i < pattern.length(); i++) {
            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            // Pattern character already maps to another character
            if (patternToWord[p] != -1 && patternToWord[p] != w) {
                return false;
            }

            // Word character already maps from another pattern character
            if (wordToPattern[w] != -1 && wordToPattern[w] != p) {
                return false;
            }

            patternToWord[p] = w;
            wordToPattern[w] = p;
        }

        return true;
    }
}
