import io.kotlintest.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class Day2Test {

    @Test
    @DisplayName(
        """
        Given a list of passwords and policy
        Then it returns the number of passwords follow the policy
    """
    )
    fun returnHowManyPasswordsAreOk() {
        val actual = listOf(
            "1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc", "15-20 l: llllllllllllllrllllz"
        )
        val result = Day2().checkPasswordPolicy(actual)
        result shouldBe 3
    }

    @Test
    @DisplayName(
        """
        Given a list of passwords and policy
        When checking the policy don't find any
        Then it returns 0
    """
    )
    fun return0asswordsAreOk() {
        val actual = listOf(
            "1-3 x: abcde", "1-3 y: cdefg", "2-9 z: ccccccccc"
        )
        val result = Day2().checkPasswordPolicy(actual)
        result shouldBe 0
    }

    @Test
    @DisplayName(
        """
        Given a list of passwords and policy position
        When checking the policy don't find any
        Then it returns 0
    """
    )
    fun returnHowManyPasswordsAreOkWithPolicyPosition() {
        val actual = listOf(
            "1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"
        )
        val result = Day2().checkPasswordPolicyPosition(actual)
        result shouldBe 1
    }


}