class Day1 {

    fun solveExpenses(list: IntArray, goalSum: Int): Int {

        //Using the technique of hashing
        val map = list.mapIndexed { index, number -> number to index }.toMap()
        for (number in list) {
            val candidate = goalSum - number
            if (map.contains(candidate)) return candidate * number
        }
        return -1
    }
}
