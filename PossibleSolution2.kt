/*
 * Complete the 'bonetrousle' function below.
 *
 * The function is expected to return a LONG_INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. LONG_INTEGER n
 *  2. LONG_INTEGER k
 *  3. INTEGER b
 */

fun bonetrousle2(n: Long, k: Long, b: Int): Array<Long> {
    // Write your code here
    var totalIntSliceSum = 0L
    for (sliceStart in 1..b) {
        totalIntSliceSum += sliceStart
    }

    for (i in 1..k) {
        if((i+b-1)>k){
            totalIntSliceSum -= (k - b)
        }else {
            if(i!=1L)
                totalIntSliceSum += b
        }
        //println("i $i totalSliceSum: $totalIntSliceSum")
        if(totalIntSliceSum == n){
            val sliceEnd = i + b -1
            val sliceStart2: Int
            val sliceEnd2: Long
            var outPutArray = emptyArray<Long>()
            if(sliceEnd > k){
                sliceStart2 = 1
                sliceEnd2 = sliceEnd - k
                for (item in i..k) {
                    outPutArray = outPutArray.plus(item)
                }
                for (item in sliceStart2 .. sliceEnd2){
                    outPutArray = outPutArray.plus(item)
                }
            }else{
                for (item in i..sliceEnd) {
                    outPutArray = outPutArray.plus(item)
                }
            }
            //println("n $n totalSliceSum: $totalIntSliceSum outPutArray ${outPutArray.toList()}")
            return outPutArray
        }
    }
    return arrayOf(-1)
}

fun checkSumMatches2(total: Long, remainingArray: Array<Long>, sliceArray: Array<Long>, totalLupSum: Long): Array<Long> {
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

        val result = bonetrousle2(n, k, b)

        println(result.joinToString(" "))
    }
}
