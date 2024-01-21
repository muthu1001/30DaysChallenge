/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here
    val totalNumbers = arr.size
    var positiveNumbers = 0
    var negativeNumbers = 0
    var zeroNumbers = 0
    arr.forEach {
        when{
            it > 0->{
                positiveNumbers++
            }
            it < 0->{
                negativeNumbers++
            }
            it == 0->{
                zeroNumbers++
            }
        }
    }
    println(positiveNumbers.toFloat()/totalNumbers)
    println(negativeNumbers.toFloat()/totalNumbers)
    println(zeroNumbers.toFloat()/totalNumbers)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}