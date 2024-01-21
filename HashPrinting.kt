/*
 * Complete the 'staircase' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

fun staircase(n: Int): Unit {
    // Write your code here
    var totalSpaces = " ".repeat(n-1)
    var hashValue = ""
    for (i in 1..n) {
        hashValue = "$hashValue#"
        println(totalSpaces+hashValue)
        if(i!=n)
            totalSpaces = totalSpaces.substring(0, totalSpaces.length-1)
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    staircase(n)
}
