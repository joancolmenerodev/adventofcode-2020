class Day1 {

    /*
     the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

     Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

    For example, suppose your expense report contained the following:

    1721
    979
    366
    299
    675
    1456
    In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
     */

    fun solveExpenses(list: List<Int>, goalSum: Int): Int {

        //Using the technique of hashing
        val map = list.mapIndexed { index, number -> number to index }.toMap()
        for (number in list) {
            //get the candidate that should be in the list
            val candidate = goalSum - number
            if (map.contains(candidate)) return candidate * number
        }
        return -1
    }

    fun solveThreeExpenses(list: List<Int>, goalSum: Int): Int {

        //sort the list to use the two pointers technique (I'd used quicksort instead)
        val sortedList = list.sorted()

        var left: Int
        var right: Int

        for (index in 0..list.size - 2) {
            left = index + 1
            right = sortedList.size - 1

            while (left < right) {
                val candidate = sortedList[index] + sortedList[left] + sortedList[right]
                when {
                    //move left one position
                    candidate < goalSum -> {
                        left++
                    }
                    //move right one less position
                    candidate > goalSum -> {
                        right--
                    }
                    else -> {
                        return sortedList[index] * sortedList[left] * sortedList[right]
                    }
                }
            }
        }
        return -1

    }

}

fun main() {
    val solver = Day1()
    val input = loadResource("InputDay1.txt").map { it.toInt() }
    println(solver.solveExpenses(input, 2020))
    println(solver.solveThreeExpenses(input, 2020))
}
