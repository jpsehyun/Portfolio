package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseViewActivity: AppCompatActivity() {
    var characterList: ArrayList<Course> = CourseGenerator.generateData()

    private lateinit var recyclerView: RecyclerView

    private lateinit var addCourseButton: Button
    private lateinit var scheduleButton: Button
    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_view)

        var context = this
        var db = DataBaseHandler(context)
        var data = db.readData()

        var i = 0
        for (i in 0..(data.size)-1) characterList.add(Course(data.get(i).courseCode,data.get(i).courseSection,data.get(i).courseRoom,data.get(i).courseTime,data.get(i).courseDay))

        this.recyclerView = findViewById(R.id.CV_RecyclerView)

        this.recyclerView.adapter = Adapter(this.characterList, "ALL")

        this.recyclerView.layoutManager = LinearLayoutManager(this)

        initializeUI()
        initializeListener()

    }

    private fun initializeUI() {
        addCourseButton = findViewById(R.id.CV_AddCourse_Btn)
        scheduleButton = findViewById(R.id.CV_Schedule_Btn)
        homeButton = findViewById(R.id.CV_Home_Btn)
    }

    private fun initializeListener() {
        addCourseButton.setOnClickListener {
            loadAddCourse()
        }
        scheduleButton.setOnClickListener{
            loadSchedule()
        }
        homeButton.setOnClickListener {
            loadHomeScreen()
        }


    }

    private fun loadAddCourse(){
        val intentLoadNextActivity = Intent(this, AddEditViewActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

    private fun loadSchedule(){
        val intentLoadNextActivity = Intent(this, MondayActivity::class.java)
        startActivity(intentLoadNextActivity)
    }
    private fun loadHomeScreen(){
        val intentLoadNextActivity = Intent(this, MainActivity::class.java)
        startActivity(intentLoadNextActivity)
    }
}