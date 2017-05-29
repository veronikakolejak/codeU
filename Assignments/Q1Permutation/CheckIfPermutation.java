package Q1Permutation;

import java.util.HashMap;

public class CheckIfPermutation {

    public static boolean arePermutations(String s1, String s2) {

        /* Assuming that there exists a permutation of an empty string */
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> counts = new HashMap<>();

        for (char letter : s1.toLowerCase().toCharArray()) {
            counts.put(letter, counts.getOrDefault(letter, 0) + 1);
        }

        for (char letter : s1.toLowerCase().toCharArray()) {
            counts.put(letter, counts.getOrDefault(letter, 0) - 1);
            /* If some counts are higher than 0 then some have to be less than 0, thus can check for one of the options only */
            if (counts.get(letter) < 0) {
                return false;
            }
        }

        return true;
    }
}
