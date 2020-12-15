private const val HYPHEN = "-"
private const val FIRST_PART = 0
private const val SECOND_PART = 1
private const val THIRD_PART = 2
private const val SPACE = " "

class Day2 {
    /*
    Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the
    Official Toboggan Corporate Policy that was in effect when they were chosen.

    To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the
    corrupted database) and the corporate policy when that password was set.
    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
     */

    fun checkPasswordPolicy(passwords: List<String>): Int {

        var amount = 0
        for (password in passwords) {
            val policy = password.split(SPACE)
            val range = policy[FIRST_PART].split(HYPHEN).map { Integer.valueOf(it) }
            val min = range[FIRST_PART]
            val max = range[SECOND_PART]
            val letter = policy[SECOND_PART].first()
            val text = policy[THIRD_PART]
            if (checkPolicy(min, max, letter, text)) amount++

        }
        return amount
    }

    private fun checkPolicy(min: Int, max: Int, letter: Char, text: String): Boolean {
        if (text.contains(letter).not()) return false
        var amount = 0
        for (ch in text) {
            if (ch == letter) {
                amount++
            }
        }
        return amount in min..max
    }

}

fun main() {
    val solver = Day2()
    val input = loadResource("InputDay2.txt")
    println(solver.checkPasswordPolicy(input))
}