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

/* -----------------------------------  */
/*
` Assumptions:
  - case-insensitive
  - Space sensitive
 */
fun isPermutationOfOther(string: String, that: String): Boolean {
    if(string.length != that.length) return false
    val stringArr = String(string.lowercase().toCharArray().sortedArray())
    val thatArr = String(that.lowercase().toCharArray().sortedArray())
    return stringArr == thatArr
}

/*
Is the true size int ever inclusive of a space character at the end?
Can the string start with a space? If so,does that space count in the true size?


Write ptnr starts at the end of the array
Find ptnr starts at the last true character

if findPtnr is on a non space character, write it where writePtnr is. Move over.
If a space is encountered by the findPtnr, write the %20 and move the write pointer 3 spaces.

[M,r, ,J,o,h,n, ,S,m,i,t,h, , , , ]
[M,r, ,J,o,h,n, ,S,%,2,0,s,m,i,t,h]
 */
fun urlify(toUrl: String, trueSize: Int): String {
    val asArray = toUrl.toCharArray()
    var writePtnr = asArray.lastIndex
    val findPtnr = trueSize - 1

    for(i in findPtnr downTo 0) {
        val chartAt = asArray[i]
        if(chartAt != ' ') {
            asArray[writePtnr] = chartAt
            writePtnr -= 1
        } else {
            asArray[writePtnr] = '0'
            asArray[writePtnr - 1] = '2'
            asArray[writePtnr - 2] = '%'
            writePtnr -= 3
        }
    }
    return String(asArray)
}