fun main(args: Array<String>) {
    var maxValue =  0L
    var minValue = 0L
    val n = readLine()!!.trim().toInt()

    val genes = readLine()!!.trimEnd().split(" ").toTypedArray()

    val health = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()



    val s = readLine()!!.trim().toInt()

    System.out.println("start time: ${System.currentTimeMillis()}")
    for (sItr in 1..s) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val first = first_multiple_input[0].toInt()

        val last = first_multiple_input[1].toInt()

        val d = first_multiple_input[2]
        val currHealth = findStrandHealth(genes,health,first,last,d)
        //val currHealth2 = findStrandHealth2(first,last,d,genes,health)
        //System.out.println("currHealth: $currHealth ")

        System.out.println("op time: ${System.currentTimeMillis()} index: $sItr")
        if(currHealth>maxValue || sItr == 1){
            maxValue = currHealth
        }
        if(currHealth<minValue || sItr == 1){
            minValue = currHealth
        }
    }
    System.out.println("end time: ${System.currentTimeMillis()}")
    print("$minValue $maxValue")
}

fun findStrandHealth2(first: Int, last: Int, d: String, genes: Array<String>, health: Array<Int>): Long {
    var strandTotalHealth = 0L
    val alphabetMap : HashMap<String,HashMap<String,Int>> = HashMap()
    val currentGenes = genes.copyOfRange(first,last+1)
    val currentHealth = health.copyOfRange(first,last+1)

    currentGenes.forEachIndexed { index, s ->
        val map = alphabetMap[s[0].toString()]
        if(map != null){
            map[s] = currentHealth[index]
        }else{
            val temp : HashMap<String,Int> = HashMap();
            temp[s] = currentHealth[index]
            alphabetMap[s[0].toString()] = temp
        }
    }

    d.toCharArray().forEachIndexed { index, c ->
        alphabetMap[c.toString()]?.mapKeys {
            if(d.contains(it.key)){
                val count = countMatches(d,it.key)
                val strandHeathIndex = it.value
                val temp = (count.toLong() * strandHeathIndex.toLong())
                strandTotalHealth += temp
                //println("contains: $s currentHealth[index] count $count ${currentHealth[index]} strandTotalHealth $strandTotalHealth")
            }
        }
    }

    return strandTotalHealth
}

fun printMinMaxValues(totalHealth: java.util.ArrayList<Int>) {
    var maxValue =  0
    var minValue = totalHealth[0]
    totalHealth.forEach {
        if(it>maxValue){
            maxValue = it
        }
        if(it<minValue){
            minValue = it
        }
    }
    print("$minValue $maxValue")
}

fun findStrandHealth(genes: Array<String>, health: Array<Int>, first: Int, last: Int, d: String): Long {
    var strandTotalHealth = 0L
    val currentGenes = genes.copyOfRange(first,last+1)
    val currentHealth = health.copyOfRange(first,last+1)
    /*for (i in first..last){
        val s = genes[i]
        if(d.contains(s)){
            val count = countMatches(d,s)
            val strandHeathIndex = health[i]
            val temp = (count.toLong() * strandHeathIndex.toLong())
            strandTotalHealth += temp
            //println("contains: $s currentHealth[index] count $count ${currentHealth[index]} strandTotalHealth $strandTotalHealth")
        }
    }*/
    currentGenes.forEachIndexed { index, s ->
        val count = countMatches(d,s)
        val strandHeathIndex = currentHealth[index]
        val temp = (count.toLong() * strandHeathIndex.toLong())
        strandTotalHealth += temp
        //println("contains: $s currentHealth[index] count $count ${currentHealth[index]} strandTotalHealth $strandTotalHealth")
    }
    //println("currentGenes: ${currentGenes.toList().toString()}")
    //println("currentHealth: ${currentHealth.toList().toString()}")
    //println("Strand: $d strandTotalHealth: $strandTotalHealth")
    return strandTotalHealth
}

/* Checks if a string is empty ("") or null. */
fun isEmpty(s: String?): Boolean {
    return s == null || s.isEmpty()
}

/* Counts how many times the substring appears in the larger string. */
fun countMatches(text: String, str: String): Int {
    if (isEmpty(text) || isEmpty(str)) {
        return 0
    }
    var count = 0
    var index = text.indexOf(str,0)
    while (index != -1){
        count++
        index = text.indexOf(str,index+1)
    }
    //System.out.println("dna $text strand : $str : count $count")
    return count
}
