package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Course"
val COL_ID = "id"
val COL_CODE = "code"
val COL_SECTION = "section"
val COL_ROOM = "room"
val COL_TIME = "time"
val COL_DAY = "day"


class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME +" (" + COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_CODE + " VARCHAR(256)," + COL_SECTION +" VARCHAR(256)," + COL_ROOM + " VARCHAR(256)," + COL_TIME + " VARCHAR(256)," + COL_DAY + " VARCHAR(256) )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun initializeData(){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_CODE, "MOBDEVE")
        cv.put(COL_SECTION, "S14")
        cv.put(COL_ROOM, "GK211")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "MONDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "CSARCH2")
        cv.put(COL_SECTION, "S11")
        cv.put(COL_ROOM, "A1101")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "TUESDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "GERIZAL")
        cv.put(COL_SECTION, "S11")
        cv.put(COL_ROOM, "A1201")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "WEDNESDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "LBYARCH")
        cv.put(COL_SECTION, "S10")
        cv.put(COL_ROOM, "Y132")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "THURSDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "GETEAM")
        cv.put(COL_SECTION, "X13")
        cv.put(COL_ROOM, "R1702")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "FRIDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "LCFAITH")
        cv.put(COL_SECTION, "S11")
        cv.put(COL_ROOM, "A203")
        cv.put(COL_TIME, "07:30 - 09:00")
        cv.put(COL_DAY, "SATURDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "CCPROG1")
        cv.put(COL_SECTION, "S11")
        cv.put(COL_ROOM, "GK101")
        cv.put(COL_TIME, "12:30 - 15:00")
        cv.put(COL_DAY, "MONDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "CCPROG2")
        cv.put(COL_SECTION, "S13")
        cv.put(COL_ROOM, "A1101")
        cv.put(COL_TIME, "12:30 - 15:00")
        cv.put(COL_DAY, "TUESDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "GEDANCE")
        cv.put(COL_SECTION, "S11")
        cv.put(COL_ROOM, "R102")
        cv.put(COL_TIME, "09:30 - 12:00")
        cv.put(COL_DAY, "WEDNESDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "CSADPRG")
        cv.put(COL_SECTION, "S10")
        cv.put(COL_ROOM, "Y207")
        cv.put(COL_TIME, "10:30 - 12:00")
        cv.put(COL_DAY, "THURSDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "CSSWENG")
        cv.put(COL_SECTION, "S17")
        cv.put(COL_ROOM, "GK207")
        cv.put(COL_TIME, "10:30 - 12:00")
        cv.put(COL_DAY, "FRIDAY")

        db.insert(TABLE_NAME, null, cv)

        cv.put(COL_CODE, "GERIZAL")
        cv.put(COL_SECTION, "S10")
        cv.put(COL_ROOM, "LS205")
        cv.put(COL_TIME, "10:30 - 12:00")
        cv.put(COL_DAY, "SATURDAY")

        db.insert(TABLE_NAME, null, cv)
        Toast.makeText(context, "Add Dummy Data", Toast.LENGTH_SHORT).show()
    }

    fun insertData(course: Course){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_CODE, course.courseCode)
        cv.put(COL_SECTION, course.courseSection)
        cv.put(COL_ROOM, course.courseRoom)
        cv.put(COL_TIME, course.courseTime)
        cv.put(COL_DAY, course.courseDay)

        var result = db.insert(TABLE_NAME, null, cv)

        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
    }

    fun updateData(course: Course){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_CODE, course.courseCode)
        cv.put(COL_SECTION, course.courseSection)
        cv.put(COL_ROOM, course.courseRoom)
        cv.put(COL_TIME, course.courseTime)
        cv.put(COL_DAY, course.courseDay)

        var result = db.update(TABLE_NAME, cv, "code = ?", arrayOf(course.courseCode))

        if(result != 1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData() : MutableList<Course>{
        var list : MutableList<Course> = ArrayList()

        var db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        var result = db.rawQuery(query, null)
        if (result.moveToFirst()){
            do {
                var c = Course()
                c.id = result.getString(0).toInt()
                c.courseCode = result.getString(1).toString()
                c.courseSection = result.getString(2).toString()
                c.courseRoom = result.getString(3).toString()
                c.courseTime = result.getString(4).toString()
                c.courseDay = result.getString(5).toString()
                list.add(c)
            }while (result.moveToNext())
        }
        db.close()
        return list
    }

    fun deleteData() {
        var db = this.writableDatabase
        val query = "DROP TABLE " + TABLE_NAME
        db.delete(TABLE_NAME, null, null)
        db.close()
    }
}

