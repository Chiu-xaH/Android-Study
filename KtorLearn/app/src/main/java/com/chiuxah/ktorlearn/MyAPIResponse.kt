package com.chiuxah.ktorlearn

import kotlinx.serialization.Serializable

@Serializable
data class MyAPIResponse (val SettingsInfo : SettingsInfo,
                          val Lessons : Lessons,
                          val semesterId : String,
                          val TimeStamp : String,
                          val Labs : List<Lab>,
                          val Notifications : List<Notifications>,
                          val SchoolCalendar : String,
                          val Next : Boolean,
                          val API : String,
                          val useNewAPI : Boolean)
@Serializable
data class SettingsInfo(val version : String,
                        val title : String,
                        val info : String,
                        val show : Boolean,
                        val celebration : Boolean)
@Serializable
data class Lessons(val MyList : List<Schedule>,
                   val Schedule : List<Schedule>)

@Serializable
data class Schedule(
    val time : String,
    val title : String,
    val info: String,
    var startTime : List<Int>,
    var endTime : List<Int>,
    val showPublic : Boolean)
@Serializable
data class Notifications(val title : String,
                         val info : String,
                         val remark : String,
                         val url : String?
)
@Serializable
data class Lab(val title : String,
               val info : String,
               val type : String)

data class Update(val version : String?,val text : String?)


@Serializable
data class SongResponse(val songmid : String,val status : String)