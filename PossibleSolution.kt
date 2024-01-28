/*
 * Complete the 'bonetrousle' function below.
 *
 * The function is expected to return a LONG_INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. LONG_INTEGER n
 *  2. LONG_INTEGER k
 *  3. INTEGER b
 */

fun bonetrousle(n: Long, k: Long, b: Int): Array<Long> {
    // Write your code here
    var totalSum = 0L
    for (sliceStart in 1..k) {
        totalSum += sliceStart
    }
    for (sliceStart in 1..k) {
        val sliceEnd = sliceStart + b -2
        var sliceStart2 = 0
        var sliceEnd2 = k+1
        if(sliceEnd > k){
            sliceStart2 = 1
            sliceEnd2 = sliceEnd - k
        }
        var sliceArray = emptyArray<Long>()
        var sliceArraySt = emptyArray<Long>()
        var sliceArrayEnd = emptyArray<Long>()
        var remainingArray = emptyArray<Long>()
        for (item in 1 .. k){
            if(item in sliceStart..sliceEnd){
                sliceArraySt = sliceArraySt.plus(item)
            }else if(item in sliceStart2..sliceEnd2){
                sliceArrayEnd = sliceArrayEnd.plus(item)
            }else{
                remainingArray = remainingArray.plus(item)
            }
        }
        sliceArray = sliceArray.plus(sliceArraySt)
        sliceArray = sliceArray.plus(sliceArrayEnd)

        val output = checkSumMatches(n, remainingArray, sliceArray,totalSum)
        if (output.isEmpty() ||  output.size != b)
            continue
        else
            return output
    }
    return arrayOf(-1)
}

fun checkSumMatches(total: Long, remainingArray: Array<Long>, sliceArray: Array<Long>, totalLupSum: Long): Array<Long> {
    val remainingSum = remainingArray.sum()
    val sliceSum = totalLupSum - remainingSum
    for (i in remainingArray) {
        val totalSum = i + sliceSum
        if (totalSum == total) {
            return sliceArray.plus(i)
        }
    }
    return arrayOf()
}


fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toLong()

        val k = first_multiple_input[1].toLong()

        val b = first_multiple_input[2].toInt()

        val result = bonetrousle(n, k, b)

        println(result.joinToString(" "))
    }
}
