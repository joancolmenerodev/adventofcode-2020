import io.kotlintest.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


private const val GOAL_SUM = 2020

class Day1Test {

    @Test
    @DisplayName(
        """
        Given a list of integers
        When it checks if there's a sum between two numbers that is 2020
        Then it adds both numbers
    """
    )
    fun addsBothNumbers() {
        val testInput = intArrayOf(1721, 979, 366, 299, 675, 1456)
        val solver = Day1()
        val actualResult = solver.solveExpenses(testInput, GOAL_SUM)
        actualResult shouldBe 514579

    }

}