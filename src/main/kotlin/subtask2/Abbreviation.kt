package subtask2

import java.lang.StringBuilder

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        //quick check if a contains whole b
        if (a.contains(b, ignoreCase = true)) return "YES"
        //if a does not contain whole b, check if we can modify it
        var aCounter = 0
        var bCounter = 0
        val outString = StringBuilder()
        while (aCounter < a.length && bCounter < b.length) {
            if (a[aCounter].equals(b[bCounter], ignoreCase = true)) {
                outString.append(a[aCounter].toUpperCase())
                aCounter++
                bCounter++
            } else {
                aCounter++
            }
            if (outString.toString() == b) return "YES"
        }
        //if there was no return, a can't be modified to b , so return "NO"
        return "NO"
    }
}
