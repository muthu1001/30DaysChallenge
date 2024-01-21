/*
 * Complete the 'birthdayCakeCandles' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY candles as parameter.
 */

fun birthdayCakeCandles(candles: Array<Int>): Int {
    // Write your code here
    var maxInteger = candles[0]
    var maxIntegerCount = 0
    candles.forEach {
        if(it == maxInteger){
            maxIntegerCount++
        }else if(it>maxInteger){
            maxInteger = it
            maxIntegerCount = 1
        }
    }
    return maxIntegerCount
}

fun main(args: Array<String>) {
    val candlesCount = readLine()!!.trim().toInt()

    val candles = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = birthdayCakeCandles(candles)

    println(result)
}
