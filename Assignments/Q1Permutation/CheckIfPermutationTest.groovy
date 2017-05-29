package Q1Permutation

class CheckIfPermutationTest extends GroovyTestCase {
    void testArePermutations() {
        assertTrue(CheckIfPermutation.arePermutations("Silent", "Listen"));
        assertTrue(CheckIfPermutation.arePermutations("", ""));
        assertTrue(CheckIfPermutation.arePermutations("siLEnt", "liSteN"));
        assertFalse(CheckIfPermutation.arePermutations("hello", "helo"));
        assertFalse(CheckIfPermutation.arePermutations("helo", "hello"));
        assertFalse(CheckIfPermutation.arePermutations("", "listen"));
        assertFalse(CheckIfPermutation.arePermutations("listen", ""));
    }
}
