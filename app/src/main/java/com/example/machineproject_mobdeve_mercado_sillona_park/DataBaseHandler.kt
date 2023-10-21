package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
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

