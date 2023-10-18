package com.example.machineproject_mobdeve_mercado_sillona_park

class Course {

    var id: Int = 0
    var courseCode: String = ""
    var courseSection: String = ""
    var courseRoom: String = ""
    var courseTime: String = ""
    var courseDay: String = ""

    constructor(code: String, section: String, room: String, time: String, day: String){
        this.courseCode = code
        this.courseSection = section
        this.courseRoom = room
        this.courseTime = time
        this.courseDay = day
    }

    constructor(){

    }
}