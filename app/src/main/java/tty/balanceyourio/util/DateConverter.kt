package tty.balanceyourio.util

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    fun getString(d: Date): String{
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(d)
    }

    fun getDate(s: String): Date{
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(s)
    }

    fun getSimpleString(d: Date): String{
        val calendar: Calendar= Calendar.getInstance()
        calendar.time=d
        val h=calendar.get(Calendar.HOUR_OF_DAY)
//        Log.d("DC", "Hour: $h")
        return SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(d)+" "+when(h){
            in 6..10->"上午"
            in 11..12->"中午"
            in 13..18->"下午"
            in 19..23->"晚上"
            in 0..5->"凌晨"
            else->"UNDEFINED"
        }
    }

    fun getSimpleDate(s : String): Date{
        val time=s.split(" ")
        if(time.size==2){
            val calendar = Calendar.getInstance()
            try {
                val d: Date = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(s)
                calendar.time=d
                calendar.set(Calendar.HOUR_OF_DAY, when(time[1]){
                    "上午" -> 8
                    "中午" -> 11
                    "下午" -> 15
                    "晚上" -> 21
                    else -> 0
                })
            } catch (e: Exception){
                return Date()
            }
            return calendar.time
        } else {
            return Date()
        }
    }
}