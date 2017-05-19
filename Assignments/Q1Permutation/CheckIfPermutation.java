package Q1Permutation;

public class CheckIfPermutation {

    public static boolean arePermutations(String s1, String s2) {

        /* Assuming that there exists a permutation of an empty string */
        if (s1.length() != s2.length()) return false;

        int[] counts = new int[256];

        for (char letter : s1.toLowerCase().toCharArray()) {
            counts[letter]++;
        }

        for (char letter : s1.toLowerCase().toCharArray()) {
            counts[letter]--;
            /* If some counts are higher than 0 then some have to less than 0, thus can check for one of the options only */
            if (counts[letter] < 0) return false;
        }

        return true;
    }
}
