import algos.allUniqueAsciis
import algos.allUniqueChars
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*;
import java.lang.StringBuilder

class UniqueCharsTest {

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
        for (i in 0..128) {
            val char = Char(i)
            builder.append(char)
        }
        return builder.toString()
    }

}