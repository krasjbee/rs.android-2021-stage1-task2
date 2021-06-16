package subtask1

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val calendar = GregorianCalendar.getInstance()
        calendar.set(
            year.toInt(),
            //i don't know why the hell does it work this way
            month.toInt()-1,
            day.toInt()
        )
        //set calendar to strict mode
        calendar.isLenient=false
        //d - day of month (numeric)
        //M - month (for four M it's word format)
        //E - day of week (for four E it's word format)
        val format = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))
        return try {
            format.format(calendar.time)
        } catch (e:Exception){
            "Такого дня не существует"
        }
    }
}
