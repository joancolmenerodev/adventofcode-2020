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

    /*
    PART 2 : The shopkeeper suddenly realizes that he just accidentally explained the password policy rules from his
    old job at the sled rental place down the street! The Official Toboggan Corporate Policy actually works a
    little differently.

    Each policy actually describes two positions in the password, where 1 means the first character, 2 means
     the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
     Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant
     for the purposes of policy enforcement.

    Given the same example list from above:

    1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
     */

    fun checkPasswordPolicyPosition(passwords: List<String>): Int {
        var amount = 0
        for (password in passwords) {
            val policy = password.split(SPACE)
            val range = policy[FIRST_PART].split(HYPHEN).map { Integer.valueOf(it) - 1 }
            val firstPosition = range[FIRST_PART]
            val secondPosition = range[SECOND_PART]
            val letter = policy[SECOND_PART].first()
            val text = policy[THIRD_PART]
            if (checkPolicyPosition(firstPosition, secondPosition, letter, text)) amount++
        }
        return amount
    }

    private fun checkPolicyPosition(firstPosition: Int, secondPosition: Int, letter: Char, text: String): Boolean {
        //using xor : is a binary operator that performs a bit by bit exclusive OR operation.
        return (text[firstPosition] == letter) xor (text[secondPosition] == letter)
    }

}

fun main() {
    val solver = Day2()
    val input = loadResource("InputDay2.txt")
    println(solver.checkPasswordPolicy(input))
    println(solver.checkPasswordPolicyPosition(input))
}