package me.syrym.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = 0;
        int left = 0;
        while(right < s.length()) {
            if (set.add(s.charAt(right))) {
                right++;
                max = Math.max(right - left, max);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
}
