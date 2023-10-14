package com.example.machineproject_mobdeve_mercado_sillona_park

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MondayActivity : AppCompatActivity() {
    private val characterList: ArrayList<Course> = CourseGenerator.generateData()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mon_Home_Btn: Button

    var x1: Float = 0.0f
    var x2: Float = 0.0f
    val MIN_DISTANCE = 300

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                val deltaX = x2 - x1
                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    // Left to Right swipe action
                    if (x2 > x1) {
                        loadPrevScreen()
                    } else {
                        loadNextScreen()
                    }
                } else {
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monday_schedule_view)

        this.recyclerView = findViewById(R.id.mon_RecyclerView)

        this.recyclerView.adapter = Adapter(this.characterList, "Monday")

        this.recyclerView.layoutManager = LinearLayoutManager(this)

        initializeUI()
        initializeListener()

    }

    fun initializeUI() {
        mon_Home_Btn = findViewById(R.id.mon_Home_Btn)
    }

    fun initializeListener() {
        mon_Home_Btn.setOnClickListener {
            loadHomeScreen()
        }
    }

    private fun loadNextScreen() {
        val intentLoadNextActivity = Intent(this, TuesdayActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

    private fun loadPrevScreen() {
        val intentLoadNextActivity = Intent(this, SaturdayActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

    private fun loadHomeScreen(){
        val intentLoadNextActivity = Intent(this, MainActivity::class.java)
        startActivity(intentLoadNextActivity)
    }


}