package com.example.machineproject_mobdeve_mercado_sillona_park

class CourseGenerator {
    companion object{
        fun generateData(): ArrayList<Course> {
            var tempList = ArrayList<Course>()
            tempList.add(Course("MOBDEVE", "S14", "GK201", "07:30 - 09:30", "Monday"))
            tempList.add(Course("CSARCH2", "S14", "GK201", "07:30 - 09:30", "Tuesday"))
            tempList.add(Course("LBYARCH", "S14", "GK201", "07:30 - 09:30", "Wednesday"))
            tempList.add(Course("CCPROG1", "S14", "GK201", "07:30 - 09:30", "Thursday"))
            tempList.add(Course("CCPROG2", "S14", "GK201", "07:30 - 09:30", "Friday"))
            tempList.add(Course("CCPROG3", "S14", "GK201", "07:30 - 09:30", "Saturday"))
            tempList.add(Course("CCDSALG", "S14", "GK201", "07:30 - 09:30", "Monday"))
            tempList.add(Course("GERIZAL", "S14", "GK201", "07:30 - 09:30", "Tuesday"))
            tempList.add(Course("GESPORT", "S14", "GK201", "07:30 - 09:30", "Wednesday"))
            tempList.add(Course("STALGCM", "S14", "GK201", "07:30 - 09:30", "Thursday"))
            tempList.add(Course("CSALGCM", "S14", "GK201", "07:30 - 09:30", "Friday"))
            tempList.add(Course("CSMODEL", "S14", "GK201", "07:30 - 09:30", "Saturday"))
            tempList.add(Course("STMATH1", "S14", "GK201", "07:30 - 09:30", "Monday"))

            return tempList
        }
    }
}