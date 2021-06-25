import algos.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*;
import java.lang.StringBuilder

class AllUniqueChars {

    @Test
    fun `test it against the string aba`() {
        val testVal = "aba"
        assertThat(allUniqueChars(testVal)).isFalse
        assertThat(allUniqueAsciis(testVal)).isFalse
    }

    @Test
    fun `test it against a unique chars string`() {
        val value = "abcdefghijk"
        assertThat(allUniqueChars(value)).isTrue
        assertThat(allUniqueAsciis(value)).isTrue
    }

    @Test
    fun `test that it works on empty`() {
        assertThat(allUniqueChars("")).isTrue
        assertThat(allUniqueAsciis("")).isTrue
    }

    @Test
    fun `with all asciis`() {
        val longArr = allAscii()
        assertThat(allUniqueChars(longArr)).isTrue
        assertThat(allUniqueAsciis(longArr)).isTrue
    }

    @Test
    fun `Test with all asciis plus some more characters`() {
        val longArr = allAscii()
        val value = longArr + "avbcd"
        assertThat(allUniqueChars(value)).isFalse
        assertThat(allUniqueAsciis(value)).isFalse
    }

    fun allAscii(): String {
        val builder = StringBuilder()
        for (i in 0..127) {
            val char = Char(i)
            builder.append(char)
        }
        return builder.toString()
    }

}

class IsPermutation {

    @Test
    fun `are permutations of each other`() {
        val  (value, that) = "abcdE" to "Edcab"
        assertThat(isPermutationOfOther(value, that)).isTrue
    }

    @Test
    fun `different lengths`() {
        val (value, that) = "superstring" to "supernot"
        assertThat(isPermutationOfOther(value, that)).isFalse
    }
}

class Urlify {

    @Test
    fun `test that it works on the book example`() {
        val toTest = "Mr John Smith    "
        val trueSize = 13
        assertThat(urlify(toUrl = toTest, trueSize)).isEqualTo("Mr%20John%20Smith")
    }

    @Test
    fun `that it works on multiple spaces`() {
        val toTest = "Mr  John    "
        val trueSize = 8
        assertThat(urlify(toTest, trueSize)).isEqualTo("Mr%20%20John")
    }
}


class IsPalindromePermutation {

    @Test
    fun `test that it works on the example string`() {
        val toTest = "Tact Coa"
        assertThat(isPalindromePermutation(toTest)).isTrue
    }
}

