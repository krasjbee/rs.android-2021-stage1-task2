package subtask3

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        var blockC = Any()
        //check what type is in block B
        when (blockB) {
            String::class -> {
                val resultString = StringBuilder()
                //Filter input array for string instances
                blockA.filterIsInstance(String::class.java).forEach { resultString.append(it) }
                blockC = resultString.toString()
            }
            Int::class -> {
                var resultNumber = 0
                //Filter input array for number instances (parent class of int)
                blockA.filterIsInstance(Number::class.java).forEach { resultNumber += it.toInt() }
                blockC = resultNumber
            }
            LocalDate::class -> {
                var maxDate = LocalDate.MIN
                //Filter input array for LocalDate instances also get max date
                blockA.filterIsInstance(LocalDate::class.java).forEach { if (it.isAfter(maxDate)) maxDate = it }
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                blockC = maxDate.format(formatter)
            }
        }
        return blockC
    }
}
