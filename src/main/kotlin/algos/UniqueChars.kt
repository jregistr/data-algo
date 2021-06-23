package algos

/*
Cracking the coding interview Chapter 1
Is Unique: Check that a string contains all unique characters.
What if you couldn't use a secondary data structure?
 */

// without other data structure
fun allUniqueChars(string: String): Boolean {
    val asArray = string.toCharArray()
    asArray.sort()
    val adjsLen = asArray.size - 2
    for (i in 0..adjsLen) {
        if(asArray[i] == asArray[i+ 1]) {
            return false
        }
    }
    return true
}

fun allUniqueAsciis(string: String): Boolean {
    if(string.length > 128) return false
    val checks = Array<Boolean>(128) { false }
    for(char in string) {
        if(checks[char.code]) return false
        checks[char.code] = true
    }
    return true
}