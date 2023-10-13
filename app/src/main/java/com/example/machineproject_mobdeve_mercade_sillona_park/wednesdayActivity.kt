package com.example.machineproject_mobdeve_mercade_sillona_park

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class wednesdayActivity : AppCompatActivity() {
    private val characterList: ArrayList<Course> = courseGenerator.generateData()
    private lateinit var recyclerView: RecyclerView
    private lateinit var title: TextView

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
                    // consider as something else - a screen tap for example
                }
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wednesday_schedule_view)

        this.recyclerView = findViewById(R.id.wed_RecyclerView)

        this.recyclerView.adapter = wednesdayAdapter(this.characterList)

        this.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun loadNextScreen() {
        var intentLoadNextActivity = Intent(this, thursdayActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

    private fun loadPrevScreen() {
        var intentLoadNextActivity = Intent(this, tuesdayActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

}
