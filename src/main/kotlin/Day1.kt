class Day1 {

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
}

fun main(){
    val solver = Day1()
    val input = loadResource("InputDay1.txt")
    println(solver.solveExpenses(input, 2020))
}
