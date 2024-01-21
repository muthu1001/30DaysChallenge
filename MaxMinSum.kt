/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    var totalSum :Long = 0L
    arr.forEach {
        totalSum += it
    }
    var maxSum: Long? =  null
    var minSum: Long? =  null
    arr.forEach { currNum->
        val sumWithoutNum = totalSum - currNum
        if(sumWithoutNum>0) {
            if (maxSum == null) maxSum = sumWithoutNum
            if (minSum == null) minSum = sumWithoutNum
            maxSum?.let {
                if (it < sumWithoutNum) {
                    maxSum = sumWithoutNum
                }
            }
            minSum?.let {
                if (it > sumWithoutNum) {
                    minSum = sumWithoutNum
                }
            }
        }
    }
    println("$minSum $maxSum")
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}
