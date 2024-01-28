/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun timeConversion(s: String): String {
    // Write your code here
    val inputTimeAmPm = s.substring(s.length-2,s.length)
    val outputTimeHour = s.substring(0,2)
    var intHour = outputTimeHour.toInt()
    var outHourString = "00"
    if(inputTimeAmPm.contains("AM",true)){
        if(intHour != 12)
            outHourString = outputTimeHour
    }else{
        if(intHour != 12)
            intHour += 12
        outHourString = intHour.toString()
    }
    return outHourString+s.substring(2,s.length-2)
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
